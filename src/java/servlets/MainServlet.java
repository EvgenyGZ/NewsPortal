package servlets;

import java.io.IOException;
import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.UsersFacade;

@WebServlet(name = "AdminController", loadOnStartup = 1, urlPatterns = {
    "/index",
})

public class MainServlet extends HttpServlet {
    @EJB private UsersFacade usersFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
    
        String path = request.getServletPath();

        switch (path) {
            case "/index":
                
                request.getRequestDispatcher("/index.jsp").
                        forward(request, response);
                break;
        }
    }
}    
