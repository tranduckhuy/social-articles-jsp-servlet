<%-- 
    Document   : list
    Created on : Oct 19, 2023, 4:40:28 PM
    Author     : ADMIN
--%>

<%@page import="java.util.List"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="java.util.Base64"%>
<%@page import="java.util.ArrayList"%>
<%@page import="me.duchuy.social_web_app_e2.models.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String uId = (String) session.getAttribute("uId");
    if (uId == null) {
        response.sendRedirect("login");
    }
    
    List<Article> listArticle = (List<Article>) session.getAttribute("listArticle");

    int total = (int) request.getAttribute("total");

    String p = request.getParameter("page");
    int pageNum = 1;

    if (page != null && p.matches("\\d+")) {
        pageNum = Integer.parseInt(p);
    }

%>
<%@include file="../layouts/header.jsp"%>

<div class="d-flex container justify-content-lg-between mt-3">
    <p class="m-0">Total: <%= total%> articles</p>
    <div class="">
        <a href="form-article" class="btn btn-rounded btn-dark">
            Create new Article
        </a>
    </div>
</div>


<div class="container border p-0 mt-3 mb-5" style="min-height: 500px">
    <table class="table align-middle mb-0 bg-white">
        <thead class="table-primary table-bordered">
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Content</th>
                <th>Author</th>
                <th>Image</th>
                <th>More detail</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Article article : listArticle) {
            %>        
            <tr>

                <td>
                    <h6 class="text-success m-0"><%= article.getTitle()%></h6>
                </td>
                <td style="width: 210px;">
                    <p class="fw-normal m-0"><%= article.getDescription()%></p>
                    <!--<p class="text-muted mb-0"></p>-->
                </td>
                <td style="width: 400px;"><%= article.getContent() + "..."%></td>

                <td class="text-primary" style="width: 150px;"><%= article.getAuthor()%></td>


                <td style="width: 200px;">
                    <div class="d-flex align-items-center">
                        <img
                            src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(IOUtils.toByteArray(article.getArticleImg()))%>"
                            alt=""
                            style="width: 130px; height: 110px"
                            />
                    </div>
                </td>

                <td style="width: 210px;">
                    <a href="detail-article?articleId=<%= article.getArticle_Id()%>" class="btn btn-link btn-sm btn-rounded">
                        Detail
                    </a>
                    <a href="edit-article?articleId=<%= article.getArticle_Id()%>" class="btn btn-link btn-sm btn-rounded" title="Edit">
                        <i class="fa-solid fa-pen"></i>
                    </a>  
                    <a href="delete-article?articleId=<%= article.getArticle_Id()%>" class="btn btn-link btn-sm btn-rounded" title="Delete">
                        <i class="fa-solid fa-trash"></i>
                    </a> 
                </td>
            </tr>

            <% }%>




        </tbody>
    </table>
</div>
<nav aria-label="..." class="d-flex justify-content-center mb-4">
    <ul class="pagination pagination-circle">
        <li class="page-item">
            <a class="page-link" href="list-article?page=<%= (pageNum > 1) ? (pageNum - 1) : 1%>">Previous</a>
        </li>

        <li class="page-item <%= (pageNum == 1) ? " active" : ""%>" aria-current="page">
            <a class="page-link" href="list-article?page=1">1</span></a>
        </li>
        <%
            if (total > 4) {
                for (int i = 0; i <= (total - 4) / 4; i++) {%>
        <li class="page-item <%= (pageNum == (i + 2)) ? " active" : ""%>"><a class="page-link" href="list-article?page=<%= i + 2%>"><%= i + 2%></a></li>
            <% }
                }
            %>

        <li class="page-item">
            <a class="page-link" href="list-article?page=<%= (pageNum < (total / 4 + 1)) ? (pageNum + 1) : (total / 4 + 1)%>">Next</a>
        </li>
    </ul>
</nav>

<%@include file="../layouts/footer.jsp" %>
