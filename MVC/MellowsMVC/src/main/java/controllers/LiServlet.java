package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LiDAO;
import model.LI;


@WebServlet(urlPatterns = { "/li", "/create-li", "/edit-li", "/update-li", "/delete-li" })
public class LiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LiDAO liDAO = new LiDAO();
	LI li = new LI();
	
    public LiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/li":
			read(request, response);
			break;
		case "/create-li":
			create(request, response);
			break;
		case "/edit-li":
			edit(request, response);
			break;
		case "/update-li":
			update(request, response);
			break;
		case "/delete-li":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}
	
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LI> listaLi = liDAO.getLivros();
		request.setAttribute("li", listaLi);
		RequestDispatcher rd = request.getRequestDispatcher("./Views/Li/index.jsp");
		rd.forward(request, response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		li.setGenero(request.getParameter("genero"));
		li.setNivel(request.getParameter("nivel"));
		li.setNome(request.getParameter("nome"));
		liDAO.save(li);	
		response.sendRedirect("li");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		li.setGenero(request.getParameter("genero"));
		li.setNivel(request.getParameter("nivel"));
		li.setNome(request.getParameter("nome"));
		li.setIdLi(Integer.parseInt(request.getParameter("idlivro")));
		liDAO.update(li);
		response.sendRedirect("li");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		li = liDAO.buscarID(id);
		request.setAttribute("idlivro", li.getIdLi());
		request.setAttribute("nome", li.getNome());
		request.setAttribute("genero", li.getGenero());
		request.setAttribute("nivel", li.getNivel());
		RequestDispatcher rd = request.getRequestDispatcher("./Views/Li/update.jsp");
		rd.forward(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		liDAO.removeById(id);
		response.sendRedirect("li");
	}
}
