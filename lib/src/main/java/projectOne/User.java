package projectOne;

import java.sql.Connection;

public class User {
    private String username;
    private String password;
    private int UsID;



    public User(){

    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUserName(){
        return username;
    }

    public int getUsID(){
        return UsID;
    }

    public void setUsID(int UsID){
        this.UsID = UsID;
    }

}
