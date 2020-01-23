package servlets;

import entity.Roles;
import entity.User;
import entity.UserRoles;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.PersonFacade;
import session.RolesFacade;
import session.UserFacade;
import session.UserRolesFacade;
import util.EncryptPass;
import util.RoleManager;

@WebServlet(name = "AdminController", urlPatterns = {
    "/showControlPanel",
})

public class AdminController extends HttpServlet{
    @EJB private UserFacade userFacade;
    @EJB private RolesFacade rolesFacade;
    @EJB private UserRolesFacade userRolesFacade;
    @EJB private PersonFacade PersonFacade;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        RoleManager rm = new RoleManager();
        HttpSession session = request.getSession(false);
        if(null == session){
            request.setAttribute("info", "У вас нет прав");
            request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
            return;
        }
        User user = (User) session.getAttribute("user");
        if(null == user){
            request.setAttribute("info", "У вас нет прав");
            request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
            return;
        }
        RoleManager roleManager = new RoleManager();
        String userRole = roleManager.getTopRole(user);
        request.setAttribute("user", user);
        request.setAttribute("userRole", userRole);
        if(!roleManager.isRoleUser("AUTHOR",user)){
            request.setAttribute("info", "У вас нет прав");
            request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
            return;
        }
     
        String path = request.getServletPath();

        switch (path) {
            case "/showControlPanel":
                request.getRequestDispatcher("/WEB-INF/showControlPanel.jsp")
                        .forward(request, response);
                
                
                break;
            
        }
    }
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold> 
}
