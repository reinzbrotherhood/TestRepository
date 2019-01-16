/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nghiapc.dtos.RegistrationDTO;

/**
 *
 * @author mickw
 */
public class AdminServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Welcome admin</h1>");
            out.println("<h2>Search</h2>");
            out.println("<form action = 'SearchController' method ='POST'>");
            out.println("FULLNAME: <input type='text' name = 'txtSearch'/><br/>");
            out.println("<input type ='submit' value = 'Search'/>");
            out.println("</form>");
            List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("INFO");
            if(result != null){
                if(result.size() > 0){
                    out.println("<table border ='1'>");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>Np</th>");
                    out.println("<th>Username</th>");
                    out.println("<th>Fullname</th>");
                    out.println("<th>Role</th>");
                    out.println("<th> Action</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");
                    int count = 0;
                    for(RegistrationDTO registrationDTO : result){
                        count++;
                        out.println("<tr>");
                        out.println("<td>" + count +"</td>");
                        out.println("<td>" + registrationDTO.getUsername()+ "</td>");
                        out.println("<td>" + registrationDTO.getFullname()+ "</td>");
                        out.println("<td>" + registrationDTO.getRole()+ "</td>");
                        out.println("<td><a href='DeleteController?username="+ registrationDTO.getUsername() +"& txtSearch = "+ request.getParameter("txtSearch") +" '>Delete</a></td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                }
                else {
                    out.println("No record found");
                }
            }
            out.println("</body>");
            out.println("</html>");
            
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
