package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Person;
import model.Usuario;
import util.Hash;

import java.io.IOException;
import java.util.List;

import daos.DaoPerson;
import daos.DaoUsuario;

/**
 * Servlet implementation class ControllerAdmin
 */
public class ControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		String operacion = request.getParameter("operacion");
		
		switch (operacion) {
		case "iniciar":
			
			//Lo he diseñado pensando en mostrar lo primero la lista de actores
			List<Person> listaActores = DaoPerson.getAllActores();
			session.setAttribute("listaActores", listaActores);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
			
		case "login":
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Usuario usuario = DaoUsuario.getUsuario(email);
			if(usuario!=null) {
				
				if(usuario.getPass().equals(Hash.getSha256(password))) {
					session.setAttribute("usuario", usuario);
				}else {
					session.removeAttribute("usuario");
				}
				
			}else {
				usuario = new Usuario();
				usuario.setNick(email);
				usuario.setPass(Hash.getSha256(password));
				DaoUsuario.insertarUsuario(usuario);
				session.setAttribute("usuario", usuario);
				
			}
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
			break;
			
			
		case "logout":
			
			session.removeAttribute("usuario");
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
			
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
