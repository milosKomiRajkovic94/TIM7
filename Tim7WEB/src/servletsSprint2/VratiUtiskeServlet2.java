package servletsSprint2;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Knjiga2;
import model.Utiscioknjizi;
import operacije.RegistracijaRemote;

/**
 * Servlet implementation class VratiUtiskeServlet2
 */
@WebServlet("/VratiUtiskeServlet2")
public class VratiUtiskeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private List<Utiscioknjizi> listaUtisaka;
	
	@EJB
	private RegistracijaRemote rrm;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VratiUtiskeServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Knjiga2 k = (Knjiga2) request.getSession().getAttribute("knj");
		listaUtisaka = rrm.vratiUtiske(k);
		request.setAttribute("listaUtisaka", listaUtisaka);
		request.getRequestDispatcher("bookReadersClub.jsp").forward(request, response);
	}

}
