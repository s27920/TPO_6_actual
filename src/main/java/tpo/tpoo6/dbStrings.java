package tpo.tpoo6;

public class dbStrings {
    public static String[] drops = {
            "ALTER TABLE Restaurant_Cuisine DROP CONSTRAINT Restaurant_Cuisine_Restaurant",
            "ALTER TABLE Restaurant_Cuisine DROP CONSTRAINT Restaurant_Cuisine_Table_3",
            "ALTER TABLE Restaurant_Feature DROP CONSTRAINT Restaurant_Feature_Feature",
            "ALTER TABLE Restaurant_Feature DROP CONSTRAINT Restaurant_Feature_Restaurant",
            "DROP TABLE Cuisine",
            "DROP TABLE Feature",
            "DROP TABLE Restaurant",
            "DROP TABLE Restaurant_Cuisine",
            "DROP TABLE Restaurant_Feature"
    };

    public static String[] creates = {
            "CREATE TABLE Cuisine (" +
                    "    cuisine_id INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
                    "    cuisine_name VARCHAR(100) NOT NULL," +
                    "    description VARCHAR(250) NOT NULL," +
                    "    CONSTRAINT Cuisine_pk PRIMARY KEY (cuisine_id)" +
                    ")",

            "CREATE TABLE Feature (" +
                    "    feature_id INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
                    "    feature_text VARCHAR(100) NOT NULL," +
                    "    CONSTRAINT Feature_pk PRIMARY KEY (feature_id)" +
                    ")",

            "CREATE TABLE Restaurant (" +
                    "    restaurant_id INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
                    "    name VARCHAR(100) NOT NULL," +
                    "    address VARCHAR(100) NOT NULL," +
                    "    iframe VARCHAR(1000) NOT NULL," +
                    "    website VARCHAR(1000) NOT NULL," +
                    "    zip_code VARCHAR(100) NOT NULL," +
                    "    rating DECIMAL(2,1) NOT NULL," +
                    "    price_range VARCHAR(10) NOT NULL," +
                    "    CONSTRAINT Restaurant_pk PRIMARY KEY (restaurant_id)" +
                    ")",

            "CREATE TABLE Restaurant_Cuisine (" +
                    "    Table_3_cuisine_id INT NOT NULL," +
                    "    Restaurant_restaurant_id INT NOT NULL," +
                    "    CONSTRAINT Restaurant_Cuisine_pk PRIMARY KEY (Restaurant_restaurant_id, Table_3_cuisine_id)" +
                    ")",

            "CREATE TABLE Restaurant_Feature (" +
                    "    Feature_feature_id INT NOT NULL," +
                    "    Restaurant_restaurant_id INT NOT NULL," +
                    "    CONSTRAINT Restaurant_Feature_pk PRIMARY KEY (Restaurant_restaurant_id, Feature_feature_id)" +
                    ")",

            "ALTER TABLE Restaurant_Cuisine ADD CONSTRAINT Restaurant_Cuisine_Restaurant" +
                    "    FOREIGN KEY (Restaurant_restaurant_id)" +
                    "    REFERENCES Restaurant (restaurant_id)",

            "ALTER TABLE Restaurant_Cuisine ADD CONSTRAINT Restaurant_Cuisine_Table_3" +
                    "    FOREIGN KEY (Table_3_cuisine_id)" +
                    "    REFERENCES Cuisine (cuisine_id)",

            "ALTER TABLE Restaurant_Feature ADD CONSTRAINT Restaurant_Feature_Feature" +
                    "    FOREIGN KEY (Feature_feature_id)" +
                    "    REFERENCES Feature (feature_id)",

            "ALTER TABLE Restaurant_Feature ADD CONSTRAINT Restaurant_Feature_Restaurant" +
                    "    FOREIGN KEY (Restaurant_restaurant_id)" +
                    "    REFERENCES Restaurant (restaurant_id)"
    };

    // Inserts
    public static String[] inserts = {
            "INSERT INTO Cuisine (cuisine_name, description) VALUES ('Italian', 'Traditional Italian cuisine with a variety of pasta and pizzas')",
            "INSERT INTO Cuisine (cuisine_name, description) VALUES ('Chinese', 'Authentic Chinese dishes with a mix of flavors and spices')",
            "INSERT INTO Cuisine (cuisine_name, description) VALUES ('Mexican', 'Spicy and flavorful Mexican food including tacos and burritos')",
            "INSERT INTO Cuisine (cuisine_name, description) VALUES ('Korean', 'Delicious Korean dishes including kimchi and bibimbap')",
            "INSERT INTO Cuisine (cuisine_name, description) VALUES ('Japanese', '')",
            "INSERT INTO Cuisine (cuisine_name, description) VALUES ('Georgian', '')",
            "INSERT INTO Cuisine (cuisine_name, description) VALUES ('Balkan', '')",
            "INSERT INTO Cuisine (cuisine_name, description) VALUES ('Greek', '')",
            "INSERT INTO Cuisine (cuisine_name, description) VALUES ('Turkish', '')",
            "INSERT INTO Cuisine (cuisine_name, description) VALUES ('Breakfast', '')",
            "INSERT INTO Cuisine (cuisine_name, description) VALUES ('Polish', '')",

            "INSERT INTO Feature (feature_text) VALUES ('Outdoor Seating')",
            "INSERT INTO Feature (feature_text) VALUES ('Takeout')",
            "INSERT INTO Feature (feature_text) VALUES ('Pet Friendly')",
            "INSERT INTO Feature (feature_text) VALUES ('Wheelchair Accessible')",
            "INSERT INTO Feature (feature_text) VALUES ('Air conditioning')",
            "INSERT INTO Feature (feature_text) VALUES ('Shopping')",
            "INSERT INTO Feature (feature_text) VALUES ('Fast Service')",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) VALUES ('Gruzinka', 'Francuska 44','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.4010285110426!2d21.05306854048768!3d52.23609916491362!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecd488294d75f%3A0x693e8eacf4df1cb1!2sGruzinka!5e0!3m2!1spl!2spl!4v1717441482859!5m2!1spl!2spl', 'https://www.pyszne.pl/menu/gruzinka-1', '03-905', 4.8 , '$$')",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (1, 6)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (1, 5)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (1, 2)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Vegan Ramen Shop', 'Finlandzka 12a', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.3595917890243!2d21.048058535617784!3d52.23685187595374!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecdacbff4dbf5%3A0x58de2241137fdf0a!2sVegan%20Ramen%20Shop!5e0!3m2!1spl!2spl!4v1717441716146!5m2!1spl!2spl', 'https://wolt.com/en/pol/warsaw/restaurant/vegan-ramen-shop-finlandzka', '03-903', 4.7, '$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (2, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (2, 2)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (2, 5)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Bałkańska dusza Saska Kępa', 'Zwycięzców 46', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.5531771168407!2d21.065002041699774!3d52.233335272104064!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecdc52bf9af33%3A0x5d7b32c307b06d49!2zQkHFgUtBxYNTS0EgRFVTWkEgU2Fza2EgS8SZcGE!5e0!3m2!1spl!2spl!4v1717441991670!5m2!1spl!2spl', 'unavailable', '03-938', 4.7, '$$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (3, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (3, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (3, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (3, 5)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (3, 7)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Restauracja Ruza Roza', 'Francuska 3', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.6334633009187!2d21.052722941699788!3d52.23187677210372!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecda9a184bcff%3A0x1883740c970070f3!2sRestauracja%20Ruza%20Roza!5e0!3m2!1spl!2spl!4v1717442265765!5m2!1spl!2spl', 'https://www.pyszne.pl/menu/kuchnia-balkanska-ruza-roza', '03-906', 4.6, '$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (4, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (4, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (4, 2)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (4, 7)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Uki Uki', 'Krucza 23/31', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2444.0194396611296!2d21.013448641699462!3d52.224864622101975!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471eccf1a54f7b63%3A0x7014ad591a5ad1b8!2sUKI%20UKI!5e0!3m2!1spl!2spl!4v1717442601648!5m2!1spl!2spl', 'https://glovoapp.com/pl/pl/warszawa/uki-uki-waw1/', '00-521', 4.7, '$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (5, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (5, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (5, 2)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (5, 5)",
            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Pizzaiolo', 'Krucza 16/22', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.9670482345036!2d21.01658644169943!3d52.22581647210225!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecdae9fc7022f%3A0x7487f8ac49c48e9d!2sPizzaiolo%20Krucza!5e0!3m2!1spl!2spl!4v1717443047412!5m2!1spl!2spl', 'https://www.pyszne.pl/menu/piccolo-pizzaiolo', '00-525', 4.6, '$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (6, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (6, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (6, 2)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (6, 1)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Señor Lucas Taquería', 'Poznańska 26', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.914372663216!2d21.00858564169942!3d52.2267734721025!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecd4dd98ae9d9%3A0x27685bb2d55387c6!2sSe%C3%B1or%20Lucas%20Taquer%C3%ADa!5e0!3m2!1spl!2spl!4v1717443234947!5m2!1spl!2spl', 'https://wolt.com/pl/pol/warsaw/restaurant/seor-lucas', '00-684', 4.8, '$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (7, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (7, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (7, 7)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (7, 3)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Mr Greek Souvlaki', 'Londyńska 16', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.3839186348396!2d21.060873041700006!3d52.236409972104845!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecd11ab658941%3A0xb4cfe7d467e3bc2f!2sMr.%20Greek%20Souvlaki!5e0!3m2!1spl!2spl!4v1717443410647!5m2!1spl!2spl', 'https://wolt.com/pl/pol/warsaw/restaurant/mr-greek-souvlaki-warszawa-saska-kpa', '03-922', 4.7, '$$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (8, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (8, 5)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (8, 3)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (8, 1)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (8, 8)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Arigator Ramen Shop', 'Piękna 56', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2444.1164846238066!2d21.0094562416992!3d52.22310147210147!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471eccee8f2e60d9%3A0x479fbe3fed08ab6e!2sArigator%20Ramen%20Shop!5e0!3m2!1spl!2spl!4v1717443500885!5m2!1spl!2spl', 'https://wolt.com/pl/pol/warsaw/restaurant/arigator-ramen-shop-wwa', '00-672', 4.5, '$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (9, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (9, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (9, 5)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (9, 5)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('G-Ramen Kikuya', 'Stanisława Nowakowskiego 12', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2444.213441961999!2d21.007798941699253!3d52.22133987210101!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecdcbe840668b%3A0x2b2a507f1fec00c6!2sG-Ramen%20Kikuya!5e0!3m2!1spl!2spl!4v1717443644766!5m2!1spl!2spl', 'unavailable', '00-666', 4.7, '$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (10, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (10, 7)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (10, 5)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('parowóz powiśle', 'Solec 109', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.3657906546246!2d21.02597194169994!3d52.23673927210487!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecc58367b53c1%3A0xd3d5978c3ff70cc6!2zUGFyb3fDs3ogUG93acWbbGU!5e0!3m2!1spl!2spl!4v1717443769273!5m2!1spl!2spl', 'https://www.ubereats.com/pl/store/parowoz-powisle/FKm8iwDASLSNlRGzWlrG1A', '00-382', 4.7, '$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (11, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (11, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (11, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (11, 7)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (11, 2)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('ciao a tutti', 'al. Niepodległości 217', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d39110.85456680385!2d20.932196321679676!3d52.21743399999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471eccea12c7b2ab%3A0xeae04d58028bd09c!2sCiao%20a%20Tutti!5e0!3m2!1spl!2spl!4v1717443931985!5m2!1spl!2spl', 'https://glovoapp.com/pl/pl/warszawa/ciao-a-tutti-waw/', '02-087', 4.6, '$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (12, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (12, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (12, 5)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (12, 1)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Efes Kebab', 'Francuska 1', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d39093.884125482815!2d20.987428031615224!3d52.23670353763621!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecda9a10cc009%3A0xa482d6e565b4feed!2sEFES%20KEBAB!5e0!3m2!1spl!2spl!4v1717444036744!5m2!1spl!2spl', 'unavailable', '03-906', 4.4, '$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (13, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (13, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (13, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (13, 5)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (13, 7)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (13, 9)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('La Sirena The Mexican Food Cartel', 'Piękna 54', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2444.1151856791967!2d21.009721141699345!3d52.22312507210152!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471eccee8f2e60d9%3A0x7b7d12dc197f93b8!2sLa%20Sirena%3A%20The%20Mexican%20Food%20Cartel!5e0!3m2!1spl!2spl!4v1717444182898!5m2!1spl!2spl', 'https://glovoapp.com/pl/pl/warszawa/la-sirena-waw/', '00-672', 4.5, '$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (14, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (14, 1)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (14, 3)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Mała Sicilia Di Stefano Terrazzino', 'Kinowa 19', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1221.5182874887507!2d21.069383128830776!3d52.24271931498093!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecd603371ad53%3A0x1b17e10086666cda!2sMa%C5%82a%20Sicilia%20Di%20Stefano%20Terrazzino!5e0!3m2!1spl!2spl!4v1717447261765!5m2!1spl!2spl', 'unavailable', '04-019', 4.8, '$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (15, 3)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (15, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (15, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (15, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (15, 7)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (15, 6)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (15, 1)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Manekin', 'Marszałkowska 140', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d9773.240708234915!2d20.989586555419915!3d52.23774950000003!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecc8a7266c1b3%3A0x9122b453fc1dc614!2sManekin!5e0!3m2!1spl!2spl!4v1717444406586!5m2!1spl!2spl', 'https://wolt.com/pl/pol/warsaw/restaurant/manekinmarsz', '00-061', 4.6, '$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (16, 6)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (16, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (16, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (16, 7)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (16, 10)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('La Bomboniera', 'al. Solidarności 82', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.0391483878525!2d20.99121834170022!3d52.24267257210641!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecc7dbb9d61b1%3A0xeb96ab93c209c62d!2sLa%20Bomboniera!5e0!3m2!1spl!2spl!4v1717444684605!5m2!1spl!2spl', 'unavailable', '00-145', 4.8, '$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (17, 6)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (17, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (17, 7)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (17, 4)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (17, 1)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('żona krawca - kawiarnia', 'Kamionkowska 29', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d78168.51326175065!2d20.92044604335936!3d52.24763309999998!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecdb5da845a01%3A0xcfc778eac97bf223!2s%C5%BBona%20Krawca%20-%20Kawiarnia!5e0!3m2!1spl!2spl!4v1717444780766!5m2!1spl!2spl', 'https://glovoapp.com/pl/pl/warszawa/zona-krawca/', '03-805', 4.7, '$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (18, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (18, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (18, 7)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (18, 10)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Pyzy flaki gorące', 'Brzeska 29/31', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2442.4760662363005!2d21.03869024170073!3d52.25289957210911!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecc47eab857bf%3A0x314660c3d0799146!2sPyzy%2C%20Flaki%20Gor%C4%85ce!5e0!3m2!1spl!2spl!4v1717444905775!5m2!1spl!2spl', 'https://glovoapp.com/pl/pl/warszawa/pyzy-flaki-gorace-waw1/', '03-739', 4.7, '$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (19, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (19, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (19, 7)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (19, 11)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Santa Catrina', 'Radna 14', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d39090.29646411053!2d20.951112321679688!3d52.24077660000001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecdb8370c490d%3A0xb202034c2446e31e!2sSanta%20Catrina!5e0!3m2!1spl!2spl!4v1717445098593!5m2!1spl!2spl', 'https://www.ubereats.com/pl/store/santa-catrina/UpPQNE5jT_GotfEfFMtGIA', '00-341', 4.7, '$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (20, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (20, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (20, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (20, 5)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (20, 3)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('pezzo - pizza na nożyczki', 'Francuska 31', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.45513609823!2d21.050669141699856!3d52.2351162721045!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecdd3efc065df%3A0xcfaf19e456743e27!2sPezzo%20-%20pizza%20na%20no%C5%BCyczki!5e0!3m2!1spl!2spl!4v1717445217830!5m2!1spl!2spl', 'https://wolt.com/pl/pol/warsaw/restaurant/pezzo-pizza-na-noyczki', '03-905', 4.7, '$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (21, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (21, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (21, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (21, 5)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (21, 1)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('nonna Pizzeria', 'Oboźna 11', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d9773.05716743137!2d21.001180255419914!3d52.238583000000006!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecdf5bcd2551f%3A0x5a4e128d03aed313!2sNonna%20Pizzeria!5e0!3m2!1spl!2spl!4v1717445350903!5m2!1spl!2spl', 'https://www.ubereats.com/pl/store/nonna-pizzeria/jb5hcAWWRTu5-cC2ag223w', '00-328', 4.8, '$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (22, 7)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (22, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (22, 1)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (22, 2)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (22, 1)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('K-Food', 'Międzynarodowa 42', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.5791815366!2d21.064611141699757!3d52.232862872104015!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecdc91bc0a285%3A0xc8468914169c0725!2sK-Food!5e0!3m2!1spl!2spl!4v1717445510093!5m2!1spl!2spl', 'https://wolt.com/pl/pol/warsaw/restaurant/k-food-saska-kpa', '03-922', 4.9, '$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (23, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (23, 7)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (23, 1)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (23, 4)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('jeju korea', 'Francuska 50', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.368267911462!2d21.050394341699985!3d52.23669427210491!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecd3b893d4049%3A0xf1ffb5d13d56dfaf!2sJeju%20Korea!5e0!3m2!1spl!2spl!4v1717445650646!5m2!1spl!2spl', 'https://wolt.com/pl/pol/warsaw/restaurant/jeju-korea', '03-905', 4.3, '$$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (24, 2)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (24, 4)",

            "INSERT INTO Restaurant (name, address, iframe, website, zip_code, rating, price_range) \n" +
                    "VALUES ('Miss kimchi', 'Żelazna 28/30', 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2443.7365531732985!2d20.991499841699646!3d52.230003972103276!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecc85d2f64dc3%3A0xe35f891e106337b4!2sMiss%20Kimchi!5e0!3m2!1spl!2spl!4v1717445736875!5m2!1spl!2spl', 'https://www.ubereats.com/pl/store/miss-kimchi/gqidu5F0UJ6-2wo9Mk-SAA', '00-832', 4.6, '$')\n",

            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (25, 4)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (25, 7)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (25, 2)",
            "INSERT INTO Restaurant_Feature (Restaurant_restaurant_id, Feature_feature_id) VALUES (25, 5)",
            "INSERT INTO Restaurant_Cuisine (Restaurant_restaurant_id, Table_3_cuisine_id) VALUES (25, 4)",


    };
}