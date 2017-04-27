package servletsSprint2;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Korisnik;
import operacije.RegistracijaRemote;

/**
 * Servlet implementation class unosNovogForuma
 */
@WebServlet("/unosNovogForuma")
public class unosNovogForuma extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private RegistracijaRemote rrm;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public unosNovogForuma() {
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
		String naziv = request.getParameter("naziv");
		Korisnik k = (Korisnik)request.getSession().getAttribute("k");
		if(rrm.unosForuma(naziv, k)){
			String message = "Uspesan unos nove teme!";
			request.getSession().setAttribute("message", message);
			request.getRequestDispatcher("bookReaders.jsp").forward(request, response);
		}else{
			String message = "Neuspesan unos nove teme!";
			request.getSession().setAttribute("message", message);
			request.getRequestDispatcher("bookReaders.jsp").forward(request, response);
		}
	}

}
