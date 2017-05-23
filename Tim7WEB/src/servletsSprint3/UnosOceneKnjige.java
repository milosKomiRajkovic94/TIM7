package servletsSprint3;

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
 * Servlet implementation class UnosOceneKnjige
 */
@WebServlet("/UnosOceneKnjige")
public class UnosOceneKnjige extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private RegistracijaRemote rrm;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosOceneKnjige() {
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
		Knjiga2 knj = (Knjiga2)request.getSession().getAttribute("knj");
		String ocena = request.getParameter("ocena");
		if(rrm.unesiOcenuKnjige(knj, ocena)){
			String message = "Hvala na vasoj oceni knjige!";
			request.setAttribute("messageThree", message);
			request.getRequestDispatcher("searchedBook.jsp").forward(request, response);
		}
	}

}
