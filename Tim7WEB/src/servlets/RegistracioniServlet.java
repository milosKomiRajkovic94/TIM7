package servlets;

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

import model.Korisnik;
import operacije.Registracija;
import operacije.RegistracijaRemote;

/**
 * Servlet implementation class RegistracioniServlet
 */
@WebServlet("/RegistracioniServlet")
public class RegistracioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RegistracijaRemote rre;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistracioniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("registracija.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String mesto = request.getParameter("mesto");
		String datumRodjenja = request.getParameter("datumRodjenja");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date datum;
		try {
			datum = sdf.parse(datumRodjenja);
			Korisnik k = new Korisnik (datum, email, ime, mesto, password, prezime);
			if(rre.registracijaKorisnika(k)){
				String message = "Uspesno!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("registracija.jsp").forward(request, response);
			}else{
				String message = "Neuspesno!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("registracija.jsp").forward(request, response);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
