/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.zater;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tk.zater.util.Download;

/**
 *
 * @author zater
 */
public class DownloadEx extends HttpServlet {

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
            String url = request.getParameter("urlforwarding");
            String id = url.split("/")[4];
            System.out.println("id=" + id);
            String urlinformation[] = request.getParameterValues("urlinfomation");
            // urlinformation[]
            for (int i = 0; i < urlinformation.length; i++) {
                Pattern pat = Pattern.compile("id=\"img\" src=\"[^\"]{1,}\"");
                Matcher mat = pat.matcher(urlinformation[i]);
                      mat.find();
                String nextstr = mat.group();
          
                pat = Pattern.compile("http[a-zA-Z0-9:/.;=-]{1,}");
                mat = pat.matcher(nextstr);
                 mat.find();
                nextstr = mat.group();
                  
                String downlodPath = request.getServletContext().getRealPath("/");
                String filename[] = nextstr.split("[/]");
                System.out.println("startdownload:" + nextstr + " 下载地址:" + downlodPath + "/" + id + "/" + filename[filename.length - 1]);
                new Download().download(nextstr, downlodPath + "/" + id + "/" + filename[filename.length - 1]);
            }
            out.println("发送请求成功");
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
