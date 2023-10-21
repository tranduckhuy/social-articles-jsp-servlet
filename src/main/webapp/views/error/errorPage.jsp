<%-- 
    Document   : errorPage
    Created on : Oct 20, 2023, 10:36:55 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon" />
        <!-- Font Awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            />
        <!-- Google Fonts Roboto -->
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap"
            />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/mdb.min.css" />
    </head>
    <body>
        <h1 class=" alert-danger text-center m-0 p-3">Error <i class="fa-solid fa-exclamation"></i></h1>
        <div class="alert alert-warning text-center p-5" role="alert">
            <p>An error occurred. Please try again later.</p>
        </div>
        <div class="text-center">
            <a href="./list-article?page=1" class="btn btn-primary">Back to Home</a>
        </div>
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/views/js/mdb.min.js"></script>
    </body>
</html>
