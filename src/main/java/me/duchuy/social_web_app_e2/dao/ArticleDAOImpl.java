package me.duchuy.social_web_app_e2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.duchuy.social_web_app_e2.models.Article;
import me.duchuy.social_web_app_e2.utils.DBUtil;

/**
 *
 * @author ADMIN
 */
public class ArticleDAOImpl implements ArticleDAO {

    @Override
    public int add(Article article) {

        int result = 0;

        String query = "INSERT INTO articles (article_id, title, description, content, author_name, time_created, articleImg) VALUES (?,?,?,?,?,?,?)";

        try ( Connection conn = DBUtil.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, article.getArticle_Id());
            ps.setString(2, article.getTitle());
            ps.setString(3, article.getDescription());
            ps.setString(4, article.getContent());
            ps.setString(5, article.getAuthor());
            ps.setTimestamp(6, article.getTimeCreated());
            ps.setBlob(7, article.getArticleImg());
            result = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public List<Article> getArticles(int start, int total) {

        List<Article> articleList = new ArrayList<>();

        String query = "SELECT * FROM articles LIMIT " + (start - 1) + "," + total;

        try ( Connection conn = DBUtil.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Article article = new Article();

                article.setArticle_Id(rs.getString("article_id"));
                article.setTitle(rs.getString("title"));
                article.setDescription(rs.getString("description"));
                article.setContent(rs.getString("content"));
                article.setAuthor(rs.getString("author_name"));
                article.setTimeCreated(rs.getTimestamp("time_created"));
                article.setArticleImg(rs.getBinaryStream("articleImg"));

                articleList.add(article);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articleList;
    }

    public Article getArticlesById(String articleId) {

        Article article = new Article();

        String query = "SELECT * FROM articles WHERE article_id = ?";

        try ( Connection conn = DBUtil.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, articleId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                article.setArticle_Id(rs.getString("article_id"));
                article.setTitle(rs.getString("title"));
                article.setDescription(rs.getString("description"));
                article.setContent(rs.getString("content"));
                article.setAuthor(rs.getString("author_name"));
                article.setTimeCreated(rs.getTimestamp("time_created"));
                article.setArticleImg(rs.getBinaryStream("articleImg"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return article;
    }

    public int getTotalNumArticle() {

        int total = 0;

        String query = "SELECT COUNT(*) AS total FROM articles";

        try ( Connection conn = DBUtil.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    @Override
    public int update(Article article) {
        int result = 0;

        String query = "UPDATE articles SET title = ?, description = ?, content = ?, author_name = ?, articleImg = ? WHERE article_id = ?";

        try ( Connection conn = DBUtil.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getDescription());
            ps.setString(3, article.getContent());
            ps.setString(4, article.getAuthor());
            ps.setBlob(5, article.getArticleImg());
            ps.setString(6, article.getArticle_Id());
            result = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public int delete(String articleId) {
        int result = 0;

        String query = "DELETE FROM articles WHERE article_id = ?";

        try ( Connection conn = DBUtil.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, articleId);
            result = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

}
