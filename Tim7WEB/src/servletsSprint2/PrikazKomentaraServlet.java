package servletsSprint2;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Forum;
import model.Komentar;
import operacije.RegistracijaRemote;

/**
 * Servlet implementation class PrikazKomentaraServlet
 */
@WebServlet("/PrikazKomentaraServlet")
public class PrikazKomentaraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private RegistracijaRemote rrm;
	
	private ArrayList<Komentar> listaKomentara;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikazKomentaraServlet() {
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
		Forum forum = (Forum)request.getSession().getAttribute("forum");
		listaKomentara = rrm.vratKomentare(forum);
		request.setAttribute("listaKomentara", listaKomentara);
		request.getRequestDispatcher("searchedForum.jsp").forward(request, response);
	}

}
