package me.duchuy.social_web_app_e2.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import me.duchuy.social_web_app_e2.dao.ArticleDAOImpl;
import me.duchuy.social_web_app_e2.models.Article;

/**
 *
 * @author ADMIN
 */

@WebServlet(name = "form-article", urlPatterns = {"/form-article"})
@MultipartConfig(maxFileSize = 16177215)
public class FormArticle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("views/article/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String content = request.getParameter("content");

        String author = request.getParameter("author");

        // Time
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
        long currentTime = System.currentTimeMillis();
        Timestamp timeCreated = new Timestamp(currentTime);
        sdf.format(timeCreated);

        // Image
        Part part = request.getPart("articleImage");
        InputStream inputStream = part.getInputStream();
        InputStream articleImage = inputStream;
        
        Article article = new Article((currentTime+1610) + "", title, description, content, author, timeCreated, articleImage);

        ArticleDAOImpl articleDAO = new ArticleDAOImpl();

        int result = articleDAO.add(article);
        
        if (result > 0) {
            response.sendRedirect("list-article?page=1");
        } else {
            System.out.println("Error create at time: " + timeCreated);
        }
    }

}
