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
import operacije.RegistracijaRemote;

/**
 * Servlet implementation class SearchForBooksServlet2
 */
@WebServlet("/SearchForBooksServlet2")
public class SearchForBooksServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ArrayList<Knjiga2> listaKnjiga;
    @EJB
    public RegistracijaRemote rrm;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchForBooksServlet2() {
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
		listaKnjiga = new ArrayList<Knjiga2>();
		String opcija = request.getParameter("izbor");
		String tekstKriterijuma = request.getParameter("kriterijum");
		if(opcija.equals("0")){
			listaKnjiga = rrm.vratiPoAutoru(tekstKriterijuma);
			request.setAttribute("listaKnjiga", listaKnjiga);
			request.getRequestDispatcher("searchingBookForUnregistedUsers.jsp").forward(request, response);
		}else if(opcija.equals("1")){
			listaKnjiga = rrm.vratiBestSellere();
			request.setAttribute("listaKnjiga", listaKnjiga);
			request.getRequestDispatcher("searchingBookForUnregistedUsers.jsp").forward(request, response);
		}else if(opcija.equals("2")){
			listaKnjiga = rrm.vratiPoNaslovu(tekstKriterijuma);
			request.setAttribute("listaKnjiga", listaKnjiga);
			request.getRequestDispatcher("searchingBookForUnregistedUsers.jsp").forward(request, response);
		}
	}

}
