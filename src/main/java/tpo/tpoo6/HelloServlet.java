package tpo.tpoo6;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "huh";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
    public void destroy() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String json = reader.lines().collect(Collectors.joining());
        requestJson requestJson = new Gson().fromJson(json, HelloServlet.requestJson.class);
        String sqlRequest = buildSQLRequest(requestJson);
        try(Connection connection = DriverManager.getConnection(Setup.DBString);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlRequest);){
            List<Restaurant> restaurants = new ArrayList<>();
            while (resultSet.next()){
                restaurants.add(new Restaurant(resultSet));
            }
            if (!requestJson.search.replaceAll("\\P{L}", "").isEmpty()){
                restaurants = filterBySearchTerm(restaurants, requestJson.search);
            }
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(restaurants));
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("there you broke it. Happy?");
        }
    }

    private List<Restaurant> filterBySearchTerm(List<Restaurant> restaurants, String search){
        List<Restaurant> filtered = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (isValidSearchTermFor(search, restaurant.name)){
                filtered.add(restaurant);
            }
        }
        if (filtered.size() > 0){
            return filtered;
        }
        return restaurants;
    }

    private boolean isValidSearchTermFor(String searchTerm, String field){
        for (String fieldPart:field.split("\\P{L}")) {
            double v = compareStringLikeness(searchTerm, fieldPart);
            System.out.println(searchTerm);
            System.out.println(field);
            System.out.println(v);
            if (v > 0.65){
                return true;
            }
        }
        return false;
    }
    private double compareStringLikeness(String toCompare, String compared){
        toCompare = toCompare.toLowerCase();
        compared = compared.toLowerCase();
        double points = 0.0;
        for (char c:toCompare.toCharArray()) {
            if (compared.contains(String.valueOf(c))){
                int indexDiff = Math.abs(toCompare.indexOf(c)-compared.indexOf(c));
                if (indexDiff == 0){
                    points += 1.0;
                } else if (indexDiff == 1) {
                    points+=0.5;
                }else if (indexDiff == 2) {
                    points+=0.1;
                }
            }
        }
        return points/compared.length();
    }

    private String buildSQLRequest(requestJson json){
        StringBuilder query = new StringBuilder("SELECT * FROM Restaurant");
        if (json.features.length > 0){
            query.append(" INNER JOIN Restaurant_Feature ON Restaurant.restaurant_id = Restaurant_Feature.Restaurant_restaurant_id \n" +
                    "INNER JOIN Feature ON Restaurant_Feature.Feature_feature_id = Feature.feature_id \n");
        }
        if (json.cuisines.length > 0){
            query.append(" INNER JOIN Restaurant_Cuisine ON Restaurant.restaurant_id = Restaurant_Cuisine.Restaurant_restaurant_id \n" + "INNER JOIN Cuisine ON Restaurant_Cuisine.Table_3_cuisine_id = Cuisine.cuisine_id \n");
        }
        chainSQLWhere(json.cuisines, json.prices.length,query," Cuisine.cuisine_name ", "OR");
        chainSQLWhere(json.prices, json.features.length, query ," Restaurant.price_range ", "OR");
        subQueries(json.features, query);
        return query.toString();
    }
    private StringBuilder chainSQLWhere(String[] arr, int nextLen, StringBuilder query, String whereSubject, String operator){
        //I know this looks bad but I actually cooked here
        int length = arr.length;
        if (length > 0){
            if (!query.toString().contains("WHERE")){
                query.append(" WHERE ");
            }
            if (operator.equals("OR") && length > 1){
                query.append("(");
            }
            for (int i = 0; i < length; i++) {
                query.append(whereSubject).append(" = '").append(arr[i]).append("' ");
                if (i < length-1){
                    query.append(operator);
                }
            }
            if (operator.equals("OR")  && length > 1){
                query.append(")");
            }
        }
        if (nextLen != 0 && query.toString().contains("WHERE")){
            query.append(" AND ");
        }
        return query;
    }
    private StringBuilder subQueries(String[] arr, StringBuilder query){
        int length = arr.length;
        if (length > 0){
            if (!query.toString().contains("WHERE")) {
                query.append(" WHERE ");
            }
            for (int i = 0; i < length; i++) {
                query.append("Restaurant.restaurant_id IN( SELECT Restaurant_Feature.Restaurant_restaurant_id \n" +
                        "    FROM Restaurant_Feature \n" +
                        "    INNER JOIN Feature ON Restaurant_Feature.Feature_feature_id = Feature.feature_id \n" +
                        "    WHERE Feature.feature_text = '").append(arr[i]).append("' ").append("\n)");
                if (i < length - 1) {
                    query.append(" AND ");
                }
            }
        }
        return query;
    }

    class requestJson{
        String search;
        String[] features;
        String[] cuisines;
        String[] prices;
    }

    class returnJson{
        String name;
        String address;
        String website;
        String zip_code;
        double rating;
        String price_range;
        double lat;
        double lon;
    }

    //DTO
    class Restaurant {
        private int restaurantId;
        private String name;
        private String address;
        private String website;
        private String zipCode;
        private float rating;
        private String priceRange;
        private double lat;
        private double lon;

        public Restaurant(ResultSet resultSet) throws SQLException {
            this.restaurantId = resultSet.getInt("restaurant_id");
            this.name = resultSet.getString("name");
            this.address = resultSet.getString("address");
            this.website = resultSet.getString("website");
            this.zipCode = resultSet.getString("zip_code");
            this.rating = resultSet.getFloat("rating");
            this.priceRange = resultSet.getString("price_range");
            this.lat = resultSet.getDouble("lat");
            this.lon = resultSet.getDouble("lon");
        }
    }
}