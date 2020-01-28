package servlets;

import entity.Category;
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
import session.CategoryFacade;
import util.EncryptPass;
import util.RoleManager;

@WebServlet(name = "AdminController", urlPatterns = {
    "/showControlPanel",
    "/changeUserRole",
    "/addCategory",
    "/delCategory",
})

public class AdminController extends HttpServlet {

    @EJB
    private UserFacade userFacade;
    @EJB
    private RolesFacade rolesFacade;
    @EJB
    private UserRolesFacade userRolesFacade;
    @EJB
    private PersonFacade PersonFacade;
    @EJB
    private CategoryFacade categoryFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        RoleManager rm = new RoleManager();
        HttpSession session = request.getSession(false);
        if (null == session) {
            request.setAttribute("info", "У вас нет прав");
            request.getRequestDispatcher("/index.jsp")
                    .forward(request, response);
            return;
        }
        User user = (User) session.getAttribute("user");
        if (null == user) {
            request.setAttribute("info", "У вас нет прав");
            request.getRequestDispatcher("/index.jsp")
                    .forward(request, response);
            return;
        }
        RoleManager roleManager = new RoleManager();
        String userRole = roleManager.getTopRole(user);
        request.setAttribute("user", user);
        request.setAttribute("userRole", userRole);
        if (!roleManager.isRoleUser("AUTHOR", user)) {
            request.setAttribute("info", "У вас нет прав");
            request.getRequestDispatcher("/index.jsp")
                    .forward(request, response);
            return;
        }

        String path = request.getServletPath();

        switch (path) {
            case "/showControlPanel":
//                request.getRequestDispatcher("/WEB-INF/showControlPanel.jsp")
//                        .forward(request, response);

//                break;
//        case "/showChangeUserRole":
                List<Roles> listRoles = rolesFacade.findAll();
                List<User> listUsers = userFacade.findAll();
                List<Category> listCategory = categoryFacade.findAll();
                Map<User, String> mapUsers = new HashMap<>();
                for (User u : listUsers) {
                    if ("admin".equals(u.getLogin())) {
                        continue;
                    }
                    mapUsers.put(u, rm.getTopRole(u));
                }
                request.setAttribute("listRoles", listRoles);
                request.setAttribute("mapUsers", mapUsers);
                request.setAttribute("listCategory", listCategory);
                request.getRequestDispatcher("/WEB-INF/showControlPanel.jsp")
                        .forward(request, response);
                break;
            case "/changeUserRole":
                String userId = request.getParameter("userId");
                String roleId = request.getParameter("roleId");
                if (null == userId || "".equals(userId)
                        || null == roleId || "".equals(roleId)) {
                    request.setAttribute("info", "Не выбран пользователь или роль");
                    request.getRequestDispatcher("/showControlPanel")
                            .forward(request, response);
                    break;
                }
                user = userFacade.find(Long.parseLong(userId));
                Roles role = rolesFacade.find(Long.parseLong(roleId));
                rm.setRoleUser(role, user);
                request.setAttribute("info", "Пользователю " + user.getLogin() + " назначена роль " + role.getRole());
                request.getRequestDispatcher("/showControlPanel")
                        .forward(request, response);
                break;
            case "/addCategory":
                String Category = request.getParameter("Category");
                if (null == Category || "".equals(Category)) {
                    request.setAttribute("info", "Заполните поле ввода");
                    request.getRequestDispatcher("/showControlPanel")
                            .forward(request, response);
                }
                try {
                    Category category = new Category(Category);
                    categoryFacade.create(category);
                    request.setAttribute("info", "Категория " + category.getCategory() + "добавлена!");

                } catch (NumberFormatException e) {
                    request.setAttribute("info", "Некорректные данные");
                }
                request.getRequestDispatcher("/showControlPanel")
                        .forward(request, response);
                break;
                
            case "/delCategory":
                String categoryId = request.getParameter("categoryId");
                Category category = categoryFacade.find(Long.parseLong(categoryId));
                request.getRequestDispatcher("/showControlPanel")
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
