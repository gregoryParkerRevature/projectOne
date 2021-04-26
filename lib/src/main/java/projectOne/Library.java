
package projectOne;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebServlet("api/accounts")
public class Library extends HttpServlet{

    private AccountDao aDao = new AccountDao();
    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Account> accounts = aDao.getAccounts();

        String jsonString = mapper.writeValueAsString(accounts);
        resp.setContentType("application/json");
        resp.getWriter().print(jsonString);
        resp.getWriter().flush();
    }
}
