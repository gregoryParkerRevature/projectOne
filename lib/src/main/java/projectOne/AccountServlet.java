
package projectOne;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebServlet("/accountManager")
public class AccountServlet extends HttpServlet{

    private AccountDao aDao = new AccountDao();
    ObjectMapper mapper = new ObjectMapper();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acctName = req.getParameter("removeAccount");
        aDao.deleteAccount(acctName);

        //make redirect
        RequestDispatcher dispatcher = req.getRequestDispatcher("managerDashboard.html");
        dispatcher.forward(req, resp);
    }
}

