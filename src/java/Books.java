/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Isaac kiplel
 */
public class Books extends HttpServlet {

    int counter = 0;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void Service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String First_Name = request.getParameter("FirstName");
        String Last_name = request.getParameter("LastName");
        String Email = request.getParameter("Email");
        String Country = request.getParameter("Country");
        String Date = request.getParameter("Date");
        String Phone_Number = request.getParameter("Phone_Number");
        String Adults = request.getParameter("Adults");
        String Children = request.getParameter("Children");
        String Special_Requirements = request.getParameter("Special_Requirements");
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            counter++;
            out.println("<center><h3>"+"Users who have booked "+counter+"</h3>");
            MyDb db = new MyDb();
            out.print("Echo");
            Connection con = db.getCon();
            out.print("Echo");

           out.print("Echo");
           String sql = "insert into bookings (First_Name,Last_name,Email,Country,Date,Phone_Number,Adults,Children,Special_Requirements) values('"+First_Name+"','"+Last_name+"','"+Email+"','"+Country+"','"+Date+"','"+Phone_Number+"','"+Adults+"','"+Children+"','"+Special_Requirements+"')";
           
           Statement stmt = con.createStatement();
           out.print("Echo");
           stmt.executeUpdate(sql);
           out.print("Echo");
           out.println("Insert successful");
           response.sendRedirect("index.html");
        } catch(SQLException ex)
        {
         JOptionPane.showMessageDialog(null,"Error!\n"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);   
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
        Service(request, response);
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
        Service(request, response);
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
