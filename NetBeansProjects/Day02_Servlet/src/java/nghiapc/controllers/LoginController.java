/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghiapc.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mickw
 */
public class LoginController extends HttpServlet {
 private static final String ERROR = "ErrorServlet";
 private static final String ADMIN = "AdminServlet";
 private static final String USER  = "UserServlet";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            //1. Nhận request từ client hay từ controller khác
            String username = request.getParameter("txtUsername");
            // parametter có thể nhận dữ liệu từ 3 nguồn. Trên thẻ param, 
            //form khi người dùng nhấn submit hoặc trên URL
            String password = request.getParameter("txtPassword");
            //2. gọi model
            RegistrationDAO dao = new RegistrationDAO();
            String role = dao.checkLogin(username, password);
            //3. check login
            if(role.equals("failed")){
                request.setAttribute("ERROR", "Invalid username or password");
            }
            else{
                if(role.equals("admin")){
                    url = ADMIN;
                } else if(role.equals("user")){
                    url = USER;
                } else{
                    request.setAttribute("ERROR", "Your role is not supported");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            request.getRequestDispatcher(url).forward(request, response);
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
