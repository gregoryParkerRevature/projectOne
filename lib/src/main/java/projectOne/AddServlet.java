package projectOne;

import java.io.IOException;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebServlet("/addAccount")
public class AddServlet extends HttpServlet{

    private AccountDao aDao = new AccountDao();
    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        String acctName = req.getParameter("newAccount");
        boolean isAccount = aDao.checkAccountName(acctName);
        System.out.println(isAccount);
        if(isAccount){
            try{
                Double acctBalance = Double.parseDouble(req.getParameter("newBalance"));
                aDao.addAccount(acctName, acctBalance);

                //make redirect
                resp.sendRedirect("managerDashboard.html");
                
            }catch (NumberFormatException e){
                resp.sendRedirect("newAccount.html");
            }
        }else{
            resp.sendRedirect("newAccount.html");
        }
        
    }


}
