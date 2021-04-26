package projectOne;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebServlet("/updateAccount")
public class UpdateServlet extends HttpServlet{

    private AccountDao aDao = new AccountDao();
    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        String acctName = req.getParameter("accountSelect");
        try{
            Double acctBalance = Double.parseDouble(req.getParameter("newBalance"));
            aDao.updateAccount(acctName, acctBalance);

            //make redirect
            resp.sendRedirect("index.html");
            
        }catch (NumberFormatException e){
            resp.sendRedirect("updateAccount.html");
        }
        
    }


}
