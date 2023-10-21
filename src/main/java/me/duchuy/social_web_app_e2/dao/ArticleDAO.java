package me.duchuy.social_web_app_e2.dao;

import java.util.List;
import me.duchuy.social_web_app_e2.models.Article;

/**
 *
 * @author ADMIN
 */
public interface ArticleDAO {
    
    public int add(Article article);
    
    public List<Article> getArticles(int start, int total);
    
    public int update(Article article);
    
    public int delete(String articleId);
}
