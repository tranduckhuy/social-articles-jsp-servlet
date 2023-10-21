package me.duchuy.social_web_app_e2.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import me.duchuy.social_web_app_e2.dao.ArticleDAOImpl;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "DeleteArticle", urlPatterns = {"/delete-article"})
public class DeleteArticle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String articleId = request.getParameter("articleId");

        if (articleId != null) {
            ArticleDAOImpl articleDAO = new ArticleDAOImpl();

            int result = articleDAO.delete(articleId);
            if (result > 0) {
                System.out.println("Delete successfully! ArticleId = " + articleId);
            }
        }
        response.sendRedirect("list-article?page=1");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
