<%-- 
    Document   : form
    Created on : Oct 19, 2023, 3:31:49 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../layouts/header.jsp"%>

<section class="lg-bg">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100"">
            <div class="col-lg-6">
                <div class="card bg-form" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <h2 class="fw-bold mb-4 text-uppercase" style="color: #3f51b5">Create article</h2>

                        <form action="form-article" method="post" enctype='multipart/form-data'>
                            <div class="form-outline">
                                <input type="text" id="title" name="title" class="form-control mb-4" required/>
                                <label class="form-label" for="title">Title</label>
                            </div>

                            <div class="form-outline">
                                <input type="text" id="description" name="description" class="form-control mb-4" />
                                <label class="form-label" for="description">Short description</label>
                            </div>  

                            <div class="form-outline">
                                <textarea class="form-control mb-4" id="content" name="content" rows="5" required></textarea>
                                <label class="form-label" for="content">Content</label>
                            </div>

                            <select id="select" name="author" class="form-select mb-4" required>
                                <option value="" disabled selected>Choose an author</option>
                                <option value="Trần Đức Huy">Trần Đức Huy</option>
                                <option value="Elon Musk">Elon Musk</option>
                                <option value="Mark Zuckerberg">Mark Zuckerberg</option>
                                <option value="Jeff Bezos">Jeff Bezos</option>
                                <option value="Long Ma">Long Ma</option>
                            </select>

                            <input type="file" class="form-control mb-5" id="articleImage" name="articleImage" required/>

                            <button class="btn btn-primary btn-lg px-5" type="submit">Create</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="../layouts/footer.jsp" %>
