package servlets;

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
 * Servlet implementation class UnosUtiskaServlet
 */
@WebServlet("/UnosUtiskaServlet")
public class UnosUtiskaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private RegistracijaRemote rrm;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosUtiskaServlet() {
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
		String utisak = request.getParameter("utisak");
		Knjiga2 k2 = (Knjiga2) request.getSession().getAttribute("knj");
		String message = "";
		if(rrm.unesiUtisak(utisak, k2)){
			message = "Uspesan utisak o knjizi. Osvezite prikaz utisaka o knjizi.";
			request.getSession().setAttribute("message", message);
			request.getRequestDispatcher("searchedBook.jsp").forward(request, response);
		}else{
			message = "Neuspesan utisak o knjizi.";
			request.getSession().setAttribute("message", message);
			request.getRequestDispatcher("searchedBook.jsp").forward(request, response);
		}
		
		
	}

}