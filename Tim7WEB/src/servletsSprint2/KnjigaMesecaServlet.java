package servletsSprint2;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Knjiga2;
import operacije.LogIn;
import operacije.LogInRemote;
/**
 * Servlet implementation class KnjigaMesecaServlet
 */
@WebServlet("/KnjigaMesecaServlet")
public class KnjigaMesecaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	public LogInRemote lir;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KnjigaMesecaServlet() {
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
		Knjiga2 knj = lir.vratiKnjigu();
		if(knj == null){
			String message = "Nije jos uvek dosao na red prvi dan u mesecu.";
			request.setAttribute("messageTwo", message);
			request.getRequestDispatcher("bookReadersClub.jsp").forward(request, response);
		}else{
			request.getSession().setAttribute("knj", knj);
			request.getRequestDispatcher("bookReadersClub.jsp").forward(request, response);
		}
	}

}
