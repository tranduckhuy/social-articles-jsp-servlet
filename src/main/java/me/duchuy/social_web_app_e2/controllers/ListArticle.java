package me.duchuy.social_web_app_e2.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import me.duchuy.social_web_app_e2.dao.ArticleDAOImpl;
import me.duchuy.social_web_app_e2.models.Article;

/**
 *
 * @author ADMIN
 */

@WebServlet(name = "list-article", urlPatterns = {"/list-article"})
public class ListArticle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter("page");
        int pageNum = 1;
        if (page != null && page.matches("\\d+")) {
            int temp = Integer.parseInt(page);
            if (temp > 1) {
                pageNum = temp;
            }
        }
        
        if (pageNum != 1) {
            pageNum -= 1;
            pageNum = pageNum*4 + 1;
        }
        
        ArticleDAOImpl articleDAO = new ArticleDAOImpl();
        
        List<Article> listArticle = articleDAO.getArticles(pageNum, 4);
        
        int total = articleDAO.getTotalNumArticle();
        request.setAttribute("total", total);
        
        HttpSession session = request.getSession();
        session.setAttribute("listArticle", listArticle);
        
        request.getRequestDispatcher("views/article/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
