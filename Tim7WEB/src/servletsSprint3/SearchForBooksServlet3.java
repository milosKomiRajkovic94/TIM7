package servletsSprint3;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Knjiga2;
import operacije.OcenjivanjeKnjige;
import operacije.RegistracijaRemote;

/**
 * Servlet implementation class SearchForBooksServlet3
 */
@WebServlet("/SearchForBooksServlet3")
public class SearchForBooksServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private OcenjivanjeKnjige rrm;
	
	public ArrayList<Knjiga2> listaKnjiga;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchForBooksServlet3() {
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
		listaKnjiga = rrm.vratiKnjige();
		request.setAttribute("listaKnjiga", listaKnjiga);
		request.getRequestDispatcher("bestBooks.jsp").forward(request, response);
	}

}
