package projectOne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private Connection connection;

    public UserDao(){

        connection = Database.getInstance().getConnection();

    } 

    public User login(String username, String password){
        User loggedUser = null;

        try{
            PreparedStatement statement = connection.prepareStatement("select * from users where userName = ? and userPassword = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rSet = statement.executeQuery();

            rSet.next();
            loggedUser = new User(rSet.getString("userName"), rSet.getString("userPassword"));
        }catch (SQLException e){
            //logger
        }

        return loggedUser;
    }
}
