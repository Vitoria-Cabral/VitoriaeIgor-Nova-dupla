/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.edu.tp1_vitoriaeigorpronto.servlets;

import br.iff.edu.tp1_vitoriaeigorpronto.entidades.Usuario;
import br.iff.edu.tp1_vitoriaeigorpronto.utilidades.HibernateUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author aluno
 */
public class MeuprimeiroServlet extends HttpServlet {

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
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome"); 
        String nomeCompleto = nome+ " "+sobrenome;
        System.out.println("Nome completo: "+nomeCompleto);
        String senha = request.getParameter ("senha");
        String docRg = request.getParameter ("docRg");
        String docCpf = request.getParameter("docCpf");
        Scanner s = new Scanner(System.in);
String str = s.nextLine(); /* Vai pegar tudo até a primeira quebra de linha.
                              Garanta que o número é válido!
                           */
try {
       int i = Integer.parseInt(str); // Caso você queira tipo int, que é o usual.
       long l = Long.parseLong(str); /* É essencialmente a mesma coisa que o int, mas tem um
                                          limite de dados maior que o int, por consumir mais
                                          memória para a variável, e, por consequência um limite
                                          superior maior para o valor da variável.
                                       */
} catch (NumberFormatException e) {
  System.out.println("Numero com formato errado!");
} finally {
  s.close(); //fechar o Scanner para gerenciar melhor a memória.
}
        Usuario user = new Usuario ();
        user.setNome(nomeCompleto);
        user.setSenha(senha);
        user.setDocRg(docRg);
        user.setDocCpf(docCpf);
      
        
        double aleatorio = Math.random();
        BigDecimal id = new BigDecimal(aleatorio);
        user.setIdUsuario(id); 
        
        Session sessaoBD = HibernateUtil.getSession();
        Transaction tr = sessaoBD.beginTransaction();
        sessaoBD.save(user);
        tr.commit();
        sessaoBD.close();
            
        response.sendRedirect("teste.jsp");
        
       
        
   
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
