/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Darshan
 */
public class HeaderServlet extends HttpServlet {

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
            out.println("<title>HTTP Request Headers</title>");            
            out.println("<style> "
                    + ".tableHeader{"
                    + "background-color: pink;} "
                    + "#headerTable{width:100%}"
                    + ".ClientServer{width:50%;margin-top:20px}"
                    + ".heading{text-align:\"left\"}"
                    + "div{display: flex;}"
                    + "th{text-align:left;padding:3px;background-color:#FFFF11;}"
                    + "td{padding:3px;background-color:#E7E9EB;}"
                    + "table{border:2px solid black}"
                    + "</style>");            
            out.println("</head>");
            out.println("<body bgcolor=white>");
            out.println("<table id=\"headerTable\" border=1 cellspacing=0><tr><td colspan=2 align=center class=\"tableHeader\"><h1>Request Header</h1></td></tr>");
//            out.println("<table border=1>");
            Enumeration e = request.getHeaderNames();
            while(e.hasMoreElements()) {
                String name = (String)e.nextElement();
                String value = request.getHeader(name);
                out.println("<tr><th bgcolor='#FFFFFF78'>" + name + "</th><td>" + value + "</td></tr>");
            }
            out.println("</table>");
   
            out.println("<div><table class=\"ClientServer\" border=1 cellspacing=0><tr><td colspan=2 align=\"center\" class=\"tableHeader\"><h1>Client/Browser</h1></td></tr>");
            out.println("<tr><th class=\"heading\">Remote Address</th><td>"+request.getRemoteAddr()+"</td></tr>");
            out.println("<tr><th>Remote Host</th><td>"+request.getRemoteHost()+"</td></tr></table>");
            
            out.println("<table class=\"ClientServer\" border=1 cellspacing=0><tr><td colspan=2 align=\"center\" class=\"tableHeader\"><h1>Server</h1></td></tr>");
            out.println("<tr><th>Server Name</td><td>"+request.getServerName()+"</td></tr>");
            out.println("<tr><th>Server Port</td><td>"+request.getServerPort()+"</td></tr></table></div>");
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
