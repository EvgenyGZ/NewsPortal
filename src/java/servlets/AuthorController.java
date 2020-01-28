/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.PersonFacade;
import session.UserFacade;
import util.EncryptPass;
import util.RoleManager;

@WebServlet(name = "AuthorController", urlPatterns = {
    "/showCabinet",
    "/showAddNews",
    "/showAllNews",
})

public class AuthorController extends HttpServlet {

    @EJB
    private PersonFacade personFacade;
    @EJB
    private UserFacade userFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        EncryptPass ep = new EncryptPass();
        HttpSession session = request.getSession(false);
        if (null == session) {
            request.setAttribute("info", "У вас нет прав");
            request.getRequestDispatcher("/index.jsp")
                    .forward(request, response);
            return;
        }
        User user = (User) session.getAttribute("user");
        RoleManager roleManager = new RoleManager();
        String userRole = roleManager.getTopRole(user);
        request.setAttribute("user", user);
        request.setAttribute("userRole", userRole);
        if (!roleManager.isRoleUser("USER", user)) {
            request.setAttribute("info", "У вас нет прав");
            request.getRequestDispatcher("/index.jsp")
                    .forward(request, response);
            return;
        }
        switch (path) {
            case "/showCabinet":
                request.getRequestDispatcher("/WEB-INF/showCabinet.jsp").forward(request, response);

                break;
            case "/showAddNews":
                request.getRequestDispatcher("/WEB-INF/authorWeb/showAddNews.jsp").forward(request, response);
                
                
                break;
            case "/showAllNews":
                request.getRequestDispatcher("/WEB-INF/authorWeb/showAllNews.jsp").forward(request, response);
                
                
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
