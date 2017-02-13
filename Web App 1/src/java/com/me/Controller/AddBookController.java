/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Controller;


import com.me.DAO.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Pranay
 */
public class AddBookController extends AbstractController {
    
   
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       ModelAndView mav = new ModelAndView();
       String action = request.getParameter("action");
       if(action.equals("get"))
       {
           String number = request.getParameter("noOfBooks");
            int noOfBooks = Integer.parseInt(number);
            if(noOfBooks>0)
            {
                mav.addObject("numberBooks",noOfBooks);
                mav.setViewName("Books");
            }
       }else if(action.equals("post"))
       {
           DAO dao = new DAO();
           Connection conn =null;
           PreparedStatement preparedStatement = null;
           try{
           
           conn = dao.getConnection();
           String[] isbn = request.getParameterValues("isbn");
           String[] title = request.getParameterValues("title");
            String[] authors = request.getParameterValues("authors");
        String[] price = request.getParameterValues("Price");
         String insertQuery = "insert into books(isbn,title,authors,price)" + "values(?,?,?,?)";
        int count=0;
         for(int i=0;i<isbn.length;i++)
         {
            
                preparedStatement = conn.prepareStatement(insertQuery);
                preparedStatement.setString(1, isbn[i]);
                preparedStatement.setString(2, title[i]);
                preparedStatement.setString(3, authors[i]);
                preparedStatement.setFloat(4,Float.parseFloat(price[i]));
                int result = preparedStatement.executeUpdate();
                count++;
           }
            mav.addObject("noOfRecords", count);
            mav.setViewName("Result");
         }finally{
               dao.closeConnection(conn);
               dao.closeStatement(preparedStatement);
               }
       
       }
    
       
       return mav;
}
}