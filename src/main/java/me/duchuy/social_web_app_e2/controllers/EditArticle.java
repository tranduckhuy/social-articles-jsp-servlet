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
@WebServlet(name = "EditArticle", urlPatterns = {"/edit-article"})
@MultipartConfig(maxFileSize = 16177215)
public class EditArticle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String articleId = request.getParameter("articleId");
        
        if (articleId != null) {
            ArticleDAOImpl articleDAO = new ArticleDAOImpl();
            
            Article article = articleDAO.getArticlesById(articleId);
            
            if (article != null) {
                request.setAttribute("edit-article", article);
                request.getRequestDispatcher("views/article/form-edit.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("list-article?page=1");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String articleId = request.getParameter("articleId");
        
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String content = request.getParameter("content");

        String author = request.getParameter("author");

        // Image
        Part part = request.getPart("articleImage");
        InputStream inputStream = part.getInputStream();
        InputStream articleImage = inputStream;
        
        Article article = new Article(articleId, title, description, content, author, articleImage);

        ArticleDAOImpl articleDAO = new ArticleDAOImpl();

        int result = articleDAO.update(article);
        
        if (result > 0) {
            System.out.println("Edit ok");
        }
        response.sendRedirect("list-article?page=1");
    }

}
