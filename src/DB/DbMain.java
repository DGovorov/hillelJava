package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 16.05.2016.
 */
public class DbMain {

    private Connection connection;

    public DbMain(Connection connection) {
        this.connection = connection;
    }

    public List<Product> findAllProducts() throws Exception {
        Statement statement = connection.createStatement();
        String sql = "SELECT id, name, category, price FROM product";
        ResultSet resultSet = statement.executeQuery(sql);

        List<Product> products = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String category = resultSet.getString("category");
            int price = resultSet.getInt("price");

            Product product = new Product(id, name, category, price);
            products.add(product);
        }

        resultSet.close();
        statement.close();
        return products;
    }

    public Product findById(int id) throws Exception {
        Statement statement = connection.createStatement();
        String sql = "SELECT name, category, price FROM product WHERE id=" + id;
        ResultSet resultSet = statement.executeQuery(sql);

        Product product = null;
        while (resultSet.next()){
            //int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String category = resultSet.getString("category");
            int price = resultSet.getInt("price");

            product = new Product(id, name, category, price);
        }

        resultSet.close();
        statement.close();
        return product;
    }

    public Map<String, Integer> findNameAndPrice() throws Exception {
        Statement statement = connection.createStatement();
        String sql = "SELECT name, price FROM product";
        ResultSet resultSet = statement.executeQuery(sql);

        Map<String, Integer> nameAndPrice = new HashMap<>();
        while (resultSet.next()){
            String name = resultSet.getString(1);
            int price = resultSet.getInt(2);
            nameAndPrice.put(name, price);
        }

        resultSet.close();
        statement.close();
        return nameAndPrice;
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("jdbc.drivers", "org.postgresql,Driver");

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

        DbMain main = new DbMain(connection);
        Map<String, Integer> stringIntegerMap = main.findNameAndPrice();
        System.out.println(stringIntegerMap);

        System.out.println(main.findAllProducts());
        System.out.println(main.findById(1));

        connection.close();

    }

}