
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta http-equiv="x-ua-compatible" content="ie=edge" />
        <title>Login</title>
        <!-- icon -->
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
        <style>
            .lg-bg {
                background-color: #242a55;
            }

            .social-media a {
                border: 1px solid #ac8585;
                width: 40px;
                height: 40px;
                border-radius: 50%;
                margin: 10px;
                text-decoration: none;
            }

            .bg-form {
                background-color: #242a59;
            }

            .text-color-prime {
                color: #fefcfd;
            }

            .text-color-second {
                color: #ffffff;
            }

            .a-hover {
                color: #f2eaea;
            }

            .a-hover:hover {
                font-weight: 600;
                text-decoration: underline;
            }

            .btn:hover {
                color: #0e183e;
                background-color: #fefcfd;
            }

            .form-outline input:not(:placeholder-shown)+.form-label {
                transform: translateY(-2rem);
                font-size: 0.75rem;
            }

            @media screen and (min-width: 991px) {
                .lg-bg {
                    height: 100vh;
                }
            }
        </style>
    </head>

    <body>
        <%
            response.addHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setDateHeader("Expires", 0);

            String uId = (String) session.getAttribute("uId");
            if (uId != null) {
                response.sendRedirect("list-article?page=1");
            }
            
            String error = (String) request.getAttribute("error");
        %>
        <section class="lg-bg">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card bg-form text-white" style="border-radius: 1rem;">
                            <div class="card-body px-5 text-center">

                                <div class="mt-md-4 py-2">

                                    <h2 class="fw-bold mb-2 text-uppercase text-color-prime">Login</h2>
                                    <p id="error" class="mb-5 <%= (error != null) ? "text-danger" : "" %>">
                                        <%= (error != null) ? error : "Please enter your email and password!" %></p>

                                    <form action="login" method="post" id="formLogin">
                                        <div class="form-outline form-white mb-5">
                                            <input type="email" id="email" name="email" class="form-control form-control-lg" required/>
                                            <label class="form-label" for="email" style="background-color: #242a59; line-height: 0.75rem;">Email</label>
                                        </div>

                                        <div class="form-outline form-white mb-4">
                                            <input type="password" id="password" name="password"
                                                   class="form-control form-control-lg" required/>
                                            <label class="form-label" for="password">Password</label>
                                        </div>
                                        <div class="d-flex justify-content-center m-1"> <!-- Add text-center class here -->
                                            <div class="g-recaptcha" data-sitekey="6LcTHtQoAAAAAEir6px0o-hcQiOCMi50ojtxuvrd"></div>
                                        </div>
                                        <p class="small mb-3 pb-lg-2"><a class="a-hover" href="#!">Forgot
                                                password?</a>
                                        </p>

                                        <button class="btn btn-outline-light btn-lg px-5 mb-2 text-color-prime" type="submit">Login</button>
                                    </form>

                                    <p style="margin-top: 10px; margin-bottom: 0;">or</p>

                                    <div class="d-flex justify-content-center text-center pt-1 social-media">
                                        <a href="#" class="d-flex align-items-center justify-content-center text-color-prime">
                                            <span class="fab fa-facebook-f fa-lg"><i class="sr-only">Facebook</i></span>
                                        </a>
                                        <a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:8080/SocialWebApp/LoginGoogleHandler&response_type=code
                                        &client_id=922488704689-4h5aack1bi9kqodei9dngofdt8b5hcpe.apps.googleusercontent.com&approval_prompt=force" 
                                        class="d-flex align-items-center justify-content-center text-color-prime">
                                            <span class="fab fa-google fa-lg"><i class="sr-only">Google</i></span>
                                        </a>
                                    </div>

                                </div>

                                <div>
                                    <p class="mb-0">Don't have an account? <a href="#!"
                                                                              class="fw-bold a-hover">Sign
                                            Up</a>
                                    </p>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- MDB -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/views/js/mdb.min.js"></script>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        
        <script>
            
            window.onload = () => {
                const form = document.getElementById("formLogin");
                const error = document.getElementById("error");
                
                form.addEventListener("submit", (event) => {
                    event.preventDefault();
                    const response = grecaptcha.getResponse();
                    console.log(response);
                    if (response) {
                        form.submit();
                    } else {
                        error.innerHTML = "Please fill out all the required fields.";
                        error.classList.add("text-danger");
                    }
                })
            }
            
            
        </script>
    </body>
</html>
