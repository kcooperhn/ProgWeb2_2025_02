package uth.hn.pruebajsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "validate", value = "/validate")
public class Validacion extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String usuario = request.getParameter("username");
        String clave = request.getParameter("password");
        if(usuario!= null && !usuario.isEmpty() && clave.equals(clave.toUpperCase()) && usuario.equalsIgnoreCase(clave)){
            response.sendRedirect(request.getContextPath() + "/matricula.jsp");
            request.getSession().setAttribute("usuario", usuario);
        }else{
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    public void destroy() {
    }
}
