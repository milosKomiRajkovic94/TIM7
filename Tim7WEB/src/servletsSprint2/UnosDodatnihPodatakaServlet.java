package servletsSprint2;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Knjiga2;
import operacije.RegistracijaRemote;

/**
 * Servlet implementation class UnosDodatnihPodatakaServlet
 */
@WebServlet("/UnosDodatnihPodatakaServlet")
public class UnosDodatnihPodatakaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RegistracijaRemote rrm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosDodatnihPodatakaServlet() {
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
		float cena = Float.parseFloat(request.getParameter("cena"));
		String lokacija = request.getParameter("mesto");
		Knjiga2 knjiga = (Knjiga2)request.getSession().getAttribute("knj");
		if(rrm.unosDodatnogPodatka(cena, lokacija, knjiga)){
			String messageTwo = "Uspesan unos dodatnog podatka.";
			request.setAttribute("messageTwo", messageTwo);
			request.getRequestDispatcher("searchedBook.jsp").forward(request, response);
		}else{
			String messageTwo = "Neuspesan unos dodatnog podatka.";
			request.setAttribute("messageTwo", messageTwo);
			request.getRequestDispatcher("searchedBook.jsp").forward(request, response);
		}
	}

}
