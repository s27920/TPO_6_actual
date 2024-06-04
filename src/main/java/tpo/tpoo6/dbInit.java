package tpo.tpoo6;

import java.sql.*;

public class dbInit {
    public static String dbPath = "jdbc:derby:tpoDB;create=true";
    public static void main(String[] args) {

    }
    public static void initDb(){
        try(Connection connection = DriverManager.getConnection(dbPath);
            Statement statement = connection.createStatement()) {
//            testExecute(connection, dbStrings.drops);
            testExecute(connection, dbStrings.creates);
            testExecute(connection, dbStrings.inserts);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Restaurant");
            while (resultSet.next()){
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
    private static void testExecute(Connection con, String[] arr) throws SQLException {
        try(Statement statement = con.createStatement();) {
            for (String query:arr){
                statement.executeUpdate(query);
            }
        }
    }
}
