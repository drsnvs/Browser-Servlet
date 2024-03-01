/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DARSHAN
 */
public class Calculate extends HttpServlet {

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
            double principal = Double.parseDouble(request.getParameter("pa"));
            double rate = Double.parseDouble(request.getParameter("ir"));
            int months = Integer.parseInt(request.getParameter("month"));
            int years = Integer.parseInt(request.getParameter("year"));
            
            int compoundInterval = Integer.parseInt(request.getParameter("ci"));
            double timeInMonths = years * 12 + months;
            double timeInYears = timeInMonths / 12.0;

            double compoundInterest = principal * Math.pow(1 + rate / (compoundInterval * 100), compoundInterval * timeInYears);

            DecimalFormat df = new DecimalFormat("#.##");
            compoundInterest = Double.parseDouble(df.format(compoundInterest));
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calculate</title><style>"
                    + ".cal{"
                    + "background-color: blanchedalmond;"
                    + "border:5px solid black;}"
                    + ".set{"
                    + "margin: 10px;"
                    + "padding: 15px;"
                    + "width: 50%;"
                    + "border:2px solid black;}"
                    + "td{"
                    + "padding: 10px;"
                    + "text-align: center"
                    + "/*width:50%;*/}"
                    + "input{"
                    + "width:400px;}"
                    + "button{"
                    + "color: white;"
                    + "background-color:brown;"
                    + "border:2px solid black;}"
                    + "h1{"
                    + "color: brown;"
                    + "border-bottom: 3px solid black;"
                    + "padding-bottom: 15px;"
                    + "font-weight:1000;}"
                    + "</style>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"cal\" align=\"center\">"
                    + "<h1>Calculator</h1>"
                    + "<table class=\"set\" border=\"1\" cellspacing=0>"
                    + "<tr>"
                    + "<td>Principal Amount (₹)</td>"
                    + "<td>"+request.getParameter("pa")+"</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>Interest Rate (%)</td>"
                    + "<td>"+request.getParameter("ir")+"</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>Year</td>"
                    + "<td>"+request.getParameter("year")+"</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>Month</td>"
                    + "<td>"+request.getParameter("month")+"</td>"
                    
                    + "<tr>"
                    + "<td>Answer</td>"
                    + "<td style=\"color:brown;\"><b>"+compoundInterest+"</b></td>"
                    + "</tr>"
                    + "</table>"
                    + "</div>");
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
