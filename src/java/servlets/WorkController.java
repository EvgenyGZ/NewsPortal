/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.ejb.EJB;

import entity.Person;
import entity.Roles;
import entity.User;
import entity.UserRoles;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.PersonFacade;
import session.UserFacade;
import session.UserRolesFacade;
import session.RolesFacade;
import util.EncryptPass;
import util.RoleManager;

@WebServlet(name = "WorkController",  urlPatterns = {
    "/showProfile",
    "/changePerson",
})
        
        
        
        
public class WorkController extends HttpServlet {
    @EJB private PersonFacade personFacade;
    @EJB private UserFacade userFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        EncryptPass ep = new EncryptPass();
        HttpSession session = request.getSession(false);
        if(null == session){
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
        if(!roleManager.isRoleUser("USER",user)){
            request.setAttribute("info", "У вас нет прав");
            request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
            return;
        }                
        switch (path) {
            case "/showProfile":

                request.getRequestDispatcher("/WEB-INF/showProfile.jsp").
                        forward(request, response);
                break;
            case "/changePerson":
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String login = request.getParameter("nickName");
                String password1 = request.getParameter("password1");
                String password2 = request.getParameter("password2");
               
                
                if("".equals(password1) || !password1.equals(password2)){
                    request.setAttribute("info", "Несовпадают пароли");
                    request.getRequestDispatcher("/showUserProfile")
                        .forward(request, response);
                    break;
                }
                Person person=null;
                try{
                    person = personFacade.find(user.getPerson().getId());
                    person.setFirstName(firstName);
                    person.setLastName(lastName);
                    person.setNickName(login);
                    user.setLogin(login);
                    String salts = ep.createSalts();
                    String encryptPassword = ep.setEncryptPass(password1, salts);
                    user.setPassword(encryptPassword);
                    user.setSalts(salts);
                    personFacade.edit(person);
                    user.setPerson(person);
                    userFacade.edit(user);
                    session.setAttribute("user", user);
                    request.setAttribute("info", "Профиль читателя "+person.getFirstName()+" "+person.getLastName()+" изменен");
                }catch(NumberFormatException e){
                    personFacade.remove(person);
                    request.setAttribute("info", "Некорректные данные");
                }
                request.getRequestDispatcher("/index")
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
