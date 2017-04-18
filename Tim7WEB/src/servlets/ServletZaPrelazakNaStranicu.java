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
 * Servlet implementation class ServletZaPrelazakNaStranicu
 */
@WebServlet("/ServletZaPrelazakNaStranicu")
public class ServletZaPrelazakNaStranicu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private RegistracijaRemote rrm;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletZaPrelazakNaStranicu() {
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
		int idknjige = Integer.parseInt(request.getParameter("idknjiga"));
		Knjiga2 k = rrm.vratiKnjiguPoIDu(idknjige);
		request.getSession().setAttribute("knj", k);
		request.getRequestDispatcher("searchedBook.jsp").forward(request, response);
	}

}