<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="${pageContext.request.contextPath}/assets/js/wc/Auth.js" type="module" defer></script>
        <style>
            *, *::before, *::after {
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }
            
            html, body {
                height: 100%;
                width: 100%;
            }
            
            body {
                display: flex;
                flex-direction: column;
            }
            
            main {
                flex: 1;
                display: flex !important;
                justify-content: center !important;
                align-items: center !important;
            }
            
            .auth-section {
                width: 100%;
                max-width: 480px;
                display: flex;
                justify-content: center;
            }
            
            login-form {
                height: 100vh; /* Le decimos al componente que ocupe todo el alto del main */
                display: flex;
            }
        </style>
    </head>
    <body>
        <header></header>
        <nav></nav>
        <main>
            <section class="auth-section">
                <login-form base-path="${pageContext.request.contextPath}"></login-form>
            </section>
            <aside></aside>
        </main>
        <footer></footer>
    </body>
</html>
