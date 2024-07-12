package cl.praxis.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.praxis.model.Usuario;
import cl.praxis.model.dao.UsuarioDAO;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuarioLogueado = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuarioLogueado != null && usuarioLogueado.getRol().equals("administrador")) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<Usuario> usuarios = usuarioDAO.usuariosConDireccion();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Error de permisos: usted no tiene acceso a esta información.");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }
}