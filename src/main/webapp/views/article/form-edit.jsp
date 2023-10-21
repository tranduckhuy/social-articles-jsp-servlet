<%-- 
    Document   : form-edit
    Created on : Oct 20, 2023, 2:34:47 PM
    Author     : ADMIN
--%>

<%@page import="me.duchuy.social_web_app_e2.models.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layouts/header.jsp"%>

<%
    Article article = (Article) request.getAttribute("edit-article");
%>
<section class="lg-bg">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100"">
            <div class="col-lg-6">
                <div class="card bg-form" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <h2 class="fw-bold mb-4 text-uppercase" style="color: #3f51b5">Edit article</h2>

                        <form action="edit-article" method="post" enctype='multipart/form-data'>
                            <input type="hidden" name="articleId" value="<%= article.getArticle_Id() %>">
                            <div class="form-outline">
                                <input type="text" id="title" name="title" class="form-control mb-4" value="<%= article.getTitle() %>" required/>
                                <label class="form-label" for="title">Title</label>
                            </div>

                            <div class="form-outline">
                                <input type="text" id="description" name="description" class="form-control mb-4" value="<%= article.getDescription() %>"/>
                                <label class="form-label" for="description">Short description</label>
                            </div>  

                            <div class="form-outline">
                                <textarea class="form-control mb-4" id="content" name="content" rows="5" required><%= article.getContent()%></textarea>
                                <label class="form-label" for="content">Content</label>
                            </div>

                            <select id="select" name="author" class="form-select mb-4" required>
                                <option value="" disabled selected>Choose an author</option>
                                <option value="Trần Đức Huy" <%=(article.getAuthor().equals("Trần Đức Huy"))?"selected='selected'":"" %>>Trần Đức Huy</option>
                                <option value="Elon Musk" <%=(article.getAuthor().equals("Elon Musk"))?"selected='selected'":"" %>>Elon Musk</option>
                                <option value="Mark Zuckerberg" <%=(article.getAuthor().equals("Mark Zuckerberg"))?"selected='selected'":"" %>>Mark Zuckerberg</option>
                                <option value="Jeff Bezos" <%=(article.getAuthor().equals("Jeff Bezos"))?"selected='selected'":"" %>>Jeff Bezos</option>
                                <option value="Long Ma" <%=(article.getAuthor().equals("Long Ma"))?"selected='selected'":"" %>>Long Ma</option>
                            </select>

                            <input type="file" class="form-control mb-5" id="articleImage" name="articleImage" required/>

                            <button class="btn btn-primary btn-lg px-5" type="submit">Edit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="../layouts/footer.jsp" %>
