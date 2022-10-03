package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LivroDAO;
import dao.UsuarioDAO;
import model.Livro;
import model.Usuario;

@WebServlet(urlPatterns = { "/livro", "/create-livro", "/edit-livro", "/update-livro", "/delete-livro" })
public class LivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LivroDAO livroDAO = new LivroDAO();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	Usuario usuario = new Usuario();
	Livro l = new Livro();

	public LivroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/livro":
			read(request, response);
			break;
		case "/create-livro":
			create(request, response);
			break;
		case "/edit-livro":
			update(request, response);
			break;
		case "/update-livro":
			edit(request, response);
			break;
		case "/delete-livro":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Livro> lista = livroDAO.getLivro();
		request.setAttribute("livro", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./Views/Livro/index.jsp");
		rd.forward(request, response);
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		l.setNomeLivro(request.getParameter("livro"));
		l.setAutor (request.getParameter("autor"));
		l.setGenero(request.getParameter("genero"));
		l.setUsuario(usuarioDAO.getUsuarioById(Integer.parseInt(request.getParameter("idUsuario"))));
		livroDAO.save(l);
		response.sendRedirect("livro");
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idlivros"));
		l = livroDAO.getLivroById(id);
		request.setAttribute("idlivro", l.getIdLivro());
		request.setAttribute("livro", l.getNomeLivro());
		request.setAttribute("autor", l.getAutor());
		request.setAttribute("genero", l.getGenero());
		request.setAttribute("idUsuario", l.getUsuario());

		RequestDispatcher rd = request.getRequestDispatcher("./Views/Livro/update.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		l.setIdLivro(Integer.parseInt(request.getParameter("idlivro")));
		l.setNomeLivro(request.getParameter("livro"));
		l.setAutor(request.getParameter("autor"));
		l.setGenero(request.getParameter("genero"));
		l.setUsuario(usuarioDAO.getUsuarioById(Integer.parseInt(request.getParameter("idUsuario"))));

		livroDAO.update(l);
		response.sendRedirect("livro");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		livroDAO.deleteById(id);
		response.sendRedirect("livro");
	}
}
