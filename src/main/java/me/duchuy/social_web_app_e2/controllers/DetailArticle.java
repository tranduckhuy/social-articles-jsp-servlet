package me.duchuy.social_web_app_e2.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import me.duchuy.social_web_app_e2.dao.ArticleDAOImpl;
import me.duchuy.social_web_app_e2.models.Article;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "detail-article", urlPatterns = {"/detail-article"})
public class DetailArticle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String articleId = request.getParameter("articleId");
        
        if (articleId != null) {
            ArticleDAOImpl articleDAO = new ArticleDAOImpl();
            
            Article articleDetail = articleDAO.getArticlesById(articleId);
            
            if (articleDetail != null) {
                request.setAttribute("articleId", articleDetail);
                request.getRequestDispatcher("views/article/detail.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("list-article?page=1");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    }


}
