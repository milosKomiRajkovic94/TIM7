package servletsSprint2;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DodatniPodaci;
import operacije.RegistracijaRemote;

/**
 * Servlet implementation class VratiSveDodatneInformacijeServlet
 */
@WebServlet("/VratiSveDodatneInformacijeServlet")
public class VratiSveDodatneInformacijeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private RegistracijaRemote rrm;
    
    public List<DodatniPodaci> listaDodatnihInformacija;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VratiSveDodatneInformacijeServlet() {
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
		listaDodatnihInformacija = rrm.vratiSveDP();
		request.setAttribute("listaDodatnihInformacija", listaDodatnihInformacija);
		request.getRequestDispatcher("searchedBook.jsp").forward(request, response);
	}

}
