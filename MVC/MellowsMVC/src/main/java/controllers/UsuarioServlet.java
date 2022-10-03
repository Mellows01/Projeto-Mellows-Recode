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
import dao.UsuarioDAO;
import model.Login;
import model.Usuario;

@WebServlet(urlPatterns = { "/usuario", "/create-usuario", "/edit-usuario", "/update-usuario", "/delete-usuario" })
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UsuarioDAO usuarioDao = new UsuarioDAO();
	Usuario usuario = new Usuario();
	LoginDAO logdao = new LoginDAO();
	Login login = new Login();

	public UsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/usuario":
			read(request, response);
			break;
		case "/create-usuario":
			create(request, response);
			break;
		case "/edit-usuario":
			edit(request, response);
			break;
		case "/update-usuario":
			update(request, response);
			break;
		case "/delete-usuario":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> listaUsuarios = usuarioDao.getUsuario();

		request.setAttribute("usuario", listaUsuarios);
		RequestDispatcher rd = request.getRequestDispatcher("./Views/Usuario/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setDataNascimento(request.getParameter("dataNascimento"));
		usuario.setLogin(logdao.getLoginById(Integer.parseInt(request.getParameter("idLogin"))));

		usuarioDao.save(usuario);
		response.sendRedirect("usuario");
	}

	// EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setDataNascimento(request.getParameter("dataNascimento"));
		usuario.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
		usuario.setLogin(logdao.getLoginById(Integer.parseInt(request.getParameter("idLogin"))));

		usuarioDao.update(usuario);
		response.sendRedirect("usuario");
	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id= Integer.parseInt(request.getParameter("idUsuario"));

		usuario = usuarioDao.getUsuarioById(id);
		
		int idLogin = usuario.getLogin().getId();
		login = logdao.getLoginById(idLogin);

		request.setAttribute("idUsuario", usuario.getIdUsuario());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("email", usuario.getEmail());
		request.setAttribute("senha", usuario.getSenha());
		request.setAttribute("dataNascimento", usuario.getDataNascimento());
		request.setAttribute("idLogin", login.getTipo());

		RequestDispatcher rd = request.getRequestDispatcher("./Views/Usuario/update.jsp");
		rd.forward(request, response);

	}

	// DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idUsuario"));
		usuarioDao.deleteById(id);
		response.sendRedirect("usuario");
	}
}
