package projectOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {

    final String url = "jdbc:postgresql://localhost:5432/projectOne";
    final String userSQL = "projectOne";
    final String password = "password";
    public static Connection connection;
    


    public Database(){
        try {
            connection = DriverManager.getConnection(url, userSQL, password);
        }catch (SQLException e){
            System.out.println("SQL connection error");
        }
    }

    private static Database database = new Database();

    public static Database getInstance(){
        return database;
    }

    public Connection getConnection(){
        return connection;
    }


}
