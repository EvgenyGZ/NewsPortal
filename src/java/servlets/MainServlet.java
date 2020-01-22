package servlets;

import entity.Person;
import entity.Roles;
import entity.User2;
import entity.UserRoles;
import java.io.IOException;
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
//import session.PersonFacade;
//import session.UserFacade;
//import session.UserRoleFacade;
//import session.RolesFacade;

import util.EncryptPass;
//import util.RoleManager;

@WebServlet(name = "MainServlet", loadOnStartup = 1, urlPatterns = {
    "/index",
    "/showLogin",
//    "/showRegistration",
//    "/registration",
})

public class MainServlet extends HttpServlet {

//    @EJB     private PersonFacade personFacade;
//    @EJB     private UserFacade userFacade;
//    @EJB     private UserRoleFacade userRoleFacade;
//    @EJB     private RolesFacade rolesFacade;

//    @Override
//    public void init() throws ServletException {
//        List<User> listUsers = null;
//        try {
//            listUsers = userFacade.findAll();
//        } catch (Exception e) {
//            listUsers = new ArrayList();
//        }
//        if (listUsers != null && !listUsers.isEmpty()) {
//            return;
//        }
//
//        Person person = new Person("Ivan", "Ivanov", "I.I.", "empty");
//        personFacade.create(person);
//        EncryptPass ep = new EncryptPass();
//        String salts = ep.createSalts();
//        String password = ep.setEncryptPass("123123", salts);
//        User user = new User("admin", password, salts, person);
//        userFacade.create(user);
//
//        UserRoles userRoles = new UserRoles();
//        userRoles.setUsers(user);
//
//        Roles role = new Roles();
//        role.setRole("ADMIN");
//        rolesFacade.create(role);
//        userRoles.setRole(role);
//        userRoleFacade.create(userRoles);
//
//        role.setRole("AUTHOR");
//        rolesFacade.create(role);
//        userRoles.setRole(role);
//        userRoleFacade.create(userRoles);
//
//        role.setRole("USER");
//        rolesFacade.create(role);
//        userRoles.setRole(role);
//        userRoleFacade.create(userRoles);
//    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
//        EncryptPass ep = new EncryptPass();
//        HttpSession session = null;
//        RoleManager roleManager = new RoleManager();
        String path = request.getServletPath();

        switch (path) {
            case "/index":

//                session = request.getSession(false);
//                User user = null;
//                String userRole = null;
//                if (session != null) {
//                    user = (User) session.getAttribute("user");
//                    if (user != null) {
//                        userRole = roleManager.getTopRole(user);
//                    }
//                    request.setAttribute("userRole", userRole);
//                }
//                request.setAttribute("userRole", userRole);
//                request.setAttribute("user", user);

                request.getRequestDispatcher("/index.jsp").
                        forward(request, response);
                break;

            case "/showLogin":
                request.getRequestDispatcher("/WEB-INF/showLogin.jsp").forward(request, response);
                break;

//            case "/showRegistration":
//                request.getRequestDispatcher("/WEB-INF/showRegistration.jsp").forward(request, response);
//                break;
//            case "/registration":
//                String firstname = request.getParameter("firstname");
//                String lastname = request.getParameter("lastname");
//                String nickname = request.getParameter("nickname");
//                String login = request.getParameter("login");
//                String password = request.getParameter("password");
//                String password2 = request.getParameter("password2");
//
//                //Проверка двух введенных паролей на идентичность
//                if (!password.equals(password2)) {
//                    request.setAttribute("info", "Несовпадают пароли");
//                    request.getRequestDispatcher("/showRegistration")
//                            .forward(request, response);
//                    break;
//                }
//
//                request.setAttribute("firstname", firstname); // оставит данные в форме после обновления из-за ошибки
//                // написать для всех полей  
//
//                // создаю новую запись в бд
//                if (null == firstname || "".equals(firstname) || null == password || "".equals(password)) // перебираем все поля
//                {
//                    request.setAttribute("info", "Заполните все поля");
//                    request.getRequestDispatcher("/showRegistration").forward(request, response);
//                    break;
//                }
//
//                Person person = null;
//                try {
//                    person = new Person(firstname, lastname, nickname, null);
//                    personFacade.create(person);
//                    ep = new EncryptPass();
//                    String salts = ep.createSalts();
//                    String encryptPassword = ep.setEncryptPass(password, salts);
//                    user = new User(login, encryptPassword, salts, person);
//                    try {
//                        userFacade.create(user);
//                        UserRoles userRoles = new UserRoles();
//                        userRoles.setUsers(user);
//                        Roles role = rolesFacade.findRoleByName("USER");
//
//                        userRoles.setRole(role);
//                        userRoleFacade.create(userRoles);
//                    } catch (Exception e) {
//                        personFacade.remove(person);
//                        request.setAttribute("info", "Такой пользователь уже существует");
//                        request.getRequestDispatcher("/index")
//                                .forward(request, response);
//                        break;
//                    }
//                    request.setAttribute("info", "Читатель " + person.getFirstName() + " " + person.getLastName() + " добавлен");
//                } catch (NumberFormatException e) {
//                    personFacade.remove(person);
//                    request.setAttribute("info", "Некорректные данные");
//                }
//                request.getRequestDispatcher("/index")
//                        .forward(request, response);
//                break;
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
