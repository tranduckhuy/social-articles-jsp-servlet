<%-- 
    Document   : detail
    Created on : Oct 19, 2023, 4:40:35 PM
    Author     : ADMIN
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="java.util.Base64"%>
<%@page import="java.util.Base64"%>
<%@page import="me.duchuy.social_web_app_e2.models.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Article article = (Article) request.getAttribute("articleId");
    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
%>

<%@include file="../layouts/header.jsp"%>

<section class="lg-bg">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100"">
            <div class="col-lg-6">
                <div class="card bg-form" style="border-radius: 1rem;">
                    <div class="card-body p-4 text-center">

                        <h3 class="fw-bold mb-3" style="color: #3f51b5"><%= article.getTitle()%></h3>

                        <img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(IOUtils.toByteArray(article.getArticleImg())) %>"
                             class="img-fluid shadow-2-strong rounded-5 mb-4 w-75" alt="" />

                        <section>

                            <p><strong><%= article.getDescription()%></strong></p>

                            <p class="text-success" style="min-height: 50px; font-weight: bold">
                                <%= article.getContent()%>
                            </p>
                            
                            <p class="note note-light">
                                <strong>Author: </strong> <%= article.getAuthor() %>
                            </p>
                            
                            <p><strong>Time create: <%= sdf.format(article.getTimeCreated()) %></strong></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="../layouts/footer.jsp" %>
