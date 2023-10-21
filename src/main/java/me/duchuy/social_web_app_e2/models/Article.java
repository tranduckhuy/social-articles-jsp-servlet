package me.duchuy.social_web_app_e2.models;

import java.io.InputStream;
import java.sql.Timestamp;

/**
 *
 * @author ADMIN
 */
public class Article {

    private String article_Id;
    private String title;
    private String description;
    private String content;
    private String author;
    private Timestamp timeCreated;
    private InputStream articleImg;

    public Article() {
    }

    public Article(String article_Id, String title, String description, String content, String author, InputStream articleImg) {
        this.article_Id = article_Id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
        this.articleImg = articleImg;
    }

    public Article(String article_Id, String title, String description, String content, String author,
            Timestamp timeCreated, InputStream articleImg) {
        this.article_Id = article_Id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
        this.timeCreated = timeCreated;
        this.articleImg = articleImg;
    }

    public String getArticle_Id() {
        return article_Id;
    }

    public void setArticle_Id(String article_Id) {
        this.article_Id = article_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public InputStream getArticleImg() {
        return articleImg;
    }

    public void setArticleImg(InputStream articleImg) {
        this.articleImg = articleImg;
    }

}
