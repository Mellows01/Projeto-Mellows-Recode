package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import model.Login;

@WebServlet(urlPatterns = { "/login", "/create-login", "/edit-login", "/update-login", "/delete-login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDAO loginDAO = new LoginDAO();

	Login l = new Login();

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/login":
			read(request, response);
			break;
		case "/create-login":
			create(request, response);
			break;
		case "/edit-login":
			edit(request, response);
			break;
		case "/update-login":
			update(request, response);
			break;
		case "/delete-login":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Login> lista = loginDAO.getLogin();
		request.setAttribute("login", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./Views/Login/index.jsp");
		rd.forward(request, response);
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		l.setTipo(request.getParameter("tipo"));
		loginDAO.save(l);
		response.sendRedirect("login");
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		l.setTipo(request.getParameter("tipo"));
		l.setId(Integer.parseInt(request.getParameter("id")));
		loginDAO.update(l);
		response.sendRedirect("login");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		l = loginDAO.getLoginById(id);
		request.setAttribute("id", l.getId());		
		request.setAttribute("tipo", l.getTipo());	
		
		RequestDispatcher rd = request.getRequestDispatcher("./Views/Login/update.jsp");
		rd.forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		loginDAO.deleteById(id);
		response.sendRedirect("login");
	}
}
