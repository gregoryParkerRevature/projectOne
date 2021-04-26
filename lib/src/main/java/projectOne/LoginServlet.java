package projectOne;

import java.io.IOException;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    private UserDao uDao = new UserDao();
    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("we got here");
        User loggedUser = uDao.login(req.getParameter("username"), req.getParameter("password"));
        System.out.println(req.getParameter("username") + " " + req.getParameter("password"));

        if(loggedUser != null){
            Cookie cookie = new Cookie("currentUser", loggedUser.getUsID()+"");
            resp.addCookie(cookie);

            if(loggedUser.getUserName().equals("admin")){
                resp.sendRedirect("managerDashboard.html");
            }
            resp.sendRedirect("employeeDashboard.html");
        }
        resp.sendRedirect("index.html");
        
    }


}
