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
 * Servlet implementation class UnosUtiskaServleta2
 */
@WebServlet("/UnosUtiskaServleta2")
public class UnosUtiskaServleta2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private RegistracijaRemote rrm;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosUtiskaServleta2() {
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
		if(k2 == null){
			message = "Knjiga meseca jos uvek ne postoji!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("bookReadersClub.jsp").forward(request, response);
		}else{
			if(rrm.unesiUtisak(utisak, k2)){
				message = "Uspesan utisak o knjizi. Osvezite prikaz utisaka o knjizi.";
				request.getSession().setAttribute("message", message);
				request.getRequestDispatcher("bookReadersClub.jsp").forward(request, response);
			}else{
				message = "Neuspesan utisak o knjizi.";
				request.getSession().setAttribute("message", message);
				request.getRequestDispatcher("bookReadersClub.jsp").forward(request, response);
			}
		}
	}

}
