package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class SearchForBooksServlet
 */
@WebServlet("/SearchForBooksServlet")
public class SearchForBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ArrayList<Knjiga2> listaKnjiga;
    @EJB
    public RegistracijaRemote rrm;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchForBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		listaKnjiga = new ArrayList<Knjiga2>();
		String opcija = request.getParameter("izbor");
		String tekstKriterijuma = request.getParameter("kriterijum");
		if(opcija.equals("0")){
			listaKnjiga = rrm.vratiPoAutoru(tekstKriterijuma);
			request.setAttribute("listaKnjiga", listaKnjiga);
			request.getRequestDispatcher("searchForBooks.jsp").forward(request, response);
		}else if(opcija.equals("1")){
			listaKnjiga = rrm.vratiBestSellere();
			request.setAttribute("listaKnjiga", listaKnjiga);
			request.getRequestDispatcher("searchForBooks.jsp").forward(request, response);
		}else if(opcija.equals("2")){
			listaKnjiga = rrm.vratiPoNaslovu(tekstKriterijuma);
			request.setAttribute("listaKnjiga", listaKnjiga);
			request.getRequestDispatcher("searchForBooks.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}