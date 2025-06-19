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

@WebServlet(name = "alumnos_matricula", value = "/alumnos_matricula")
public class SistemaMatricula extends HttpServlet {
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
        HttpSession session = request.getSession();
        List<Alumno> alumnos = (List<Alumno>) session.getAttribute("alumnos");
        if(alumnos == null) {
            alumnos = new ArrayList<>();
            session.setAttribute("alumnos", alumnos);
        }
        String mensaje = "";
        String estiloMensaje = "alert alert-warning alert-dismissible fade show";
        String accion = request.getParameter("accion");
        if("delete".equals(accion)) {
            String identidad = request.getParameter("identidad");
            alumnos.removeIf(id -> id.getIdentidad().equals(identidad));
            mensaje = "Alumno eliminado";
            System.out.println("Alumno eliminado: "+identidad);
        }else if("create".equals(accion)) {
            String identidad = request.getParameter("identidad");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            alumnos.add(new Alumno(nombre, apellido, email, identidad));
            mensaje = "Alumno Matriculado";
            estiloMensaje = "alert alert-success alert-dismissible fade show";
            System.out.println("Alumno Matriculado: "+identidad);
        }
        session.setAttribute("alumnos", alumnos);
        response.sendRedirect("matricula.jsp?message="+mensaje+"&style="+estiloMensaje);
    }

    public void destroy() {
    }
}
