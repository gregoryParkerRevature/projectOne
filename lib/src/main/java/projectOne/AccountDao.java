package projectOne;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountDao {

    private Connection connection;

    public AccountDao(){

        connection = Database.getInstance().getConnection();

    }

    public List<Account> getAccounts(){
        List<Account> acctList = new ArrayList<>();
        Account account = null;
        try{
            Statement statement = connection.createStatement();
            ResultSet rSet = statement.executeQuery("SELECT * FROM accounts;");
            while(rSet.next()){
                account = new Account();
                account.setAcctName(rSet.getString("acctName"));
                account.setAcctBalance(rSet.getDouble("acctBalance"));
                acctList.add(account);
            }
        }catch (SQLException e){
            System.out.println("error with database");
        }

        return acctList;
    }

    public void deleteAccount(String acctName){
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM accounts where acctName = ?");
            statement.setString(1, acctName);
            statement.execute();
        }catch (SQLException e){
            //add logger
        }
    }

    public void updateAccount(String acctName, Double acctBalance){
        try{

            PreparedStatement statement = connection.prepareStatement("UPDATE accounts SET acctBalance = ? where acctName = ?");
            System.out.println(acctName + " " + acctBalance);
            statement.setDouble(1, acctBalance);
            statement.setString(2, acctName);
            statement.execute();
        }catch (SQLException e){
            System.out.println("error");
        }
    }
    
}
