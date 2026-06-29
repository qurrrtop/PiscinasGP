package controladores;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "AuthController", urlPatterns = {"/auth", "/auth/*"})
public class AuthController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getPathInfo();
        if (accion == null) { accion = "/login"; }

        switch (accion) {
            case "/login" ->
                request.getRequestDispatcher("/WEB-INF/vistas/login.jsp")
                       .forward(request, response);
            default ->
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getPathInfo();
        if (accion == null) { accion = "/login"; }

        switch (accion) {
            case "/login" -> procesarLogin(request, response);
            default -> response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void procesarLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validación mínima en el controlador (la fuerte va en tus validadores)
        if (email == null || email.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Debe completar todos los campos");
            request.getRequestDispatcher("/WEB-INF/vistas/login.jsp")
                   .forward(request, response);
            return;
        }

        // TODO: acá enganchás tu lógica real contra el modelo/servicio
        boolean credencialesValidas = email.equals("admin@pool.com") && password.equals("1234");

        if (credencialesValidas) {
            HttpSession session = request.getSession(true);
            session.setAttribute("usuarioLogueado", email);
            response.sendRedirect(request.getContextPath() + "/dashboard");
        } else {
            request.setAttribute("errorMessage", "Credenciales incorrectas");
            request.getRequestDispatcher("/WEB-INF/vistas/login.jsp")
                   .forward(request, response);
        }
    }
}