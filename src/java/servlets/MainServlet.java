package servlets;

import entity.Users;
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
    "/showLogin",
    "/showRegistration",
    "/registration",
})

public class MainServlet extends HttpServlet {

    @EJB
    private UsersFacade usersFacade;

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

            case "/showLogin":
                request.getRequestDispatcher("/WEB-INF/showLogin.jsp").forward(request, response);
                break;
                
            case "/showRegistration":
                request.getRequestDispatcher("/WEB-INF/showRegistration.jsp").forward(request, response);
                break;
            case "/registration":
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String nickname = request.getParameter("nickname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");
            
            //Проверка двух введенных паролей на идентичность
            if(!password.equals(password2)){
                    request.setAttribute("info", "Несовпадают пароли");
                    request.getRequestDispatcher("/showRegistration")
                        .forward(request, response);
                    break;
                }
            
            request.setAttribute("firstname", firstname); // оставит данные в форме после обновления из-за ошибки
            // написать для всех полей  
            
            // создаю новую запись в бд
             
            if (null == firstname || "".equals(firstname) || null == password || "".equals(password) ) // перебираем все поля
            {
                 request.setAttribute("info", "Заполните все поля");
                 request.getRequestDispatcher("/showRegistration").forward(request, response);
                 break;
            }
            

            Users user = new Users (email,firstname,lastname,nickname,password, null, null);
            usersFacade.create(user);
            // оставим место для шифрования пароля
            
            request.setAttribute("info", "Пользователь "+user.getFirstName()+" "+user.getLastName()+" добавлен");
             request.getRequestDispatcher("/index").forward(request, response);
            
            
           
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
