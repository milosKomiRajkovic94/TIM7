package servletsSprint3;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Administrator;
import model.Korisnik;
import model.Sajmovi;
import operacije.RegistracijaRemote;

/**
 * Servlet implementation class UnosZanimljivostiServlet
 */
@WebServlet("/UnosZanimljivostiServlet")
public class UnosZanimljivostiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private RegistracijaRemote rre;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosZanimljivostiServlet() {
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
		String tekst = request.getParameter("tekst");
		String datum = request.getParameter("datum");
		Administrator a = rre.vratiAdministratora();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date;
		try {
			date = sdf.parse(datum);
			Sajmovi s = new Sajmovi(tekst, date, a);
			if(rre.unesiSajam(s)){
				String message = "Uspesno!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("unosZanimljivosti.jsp").forward(request, response);
			}else{
				String message = "Neuspesno!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("unosZanimljivosti.jsp").forward(request, response);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
