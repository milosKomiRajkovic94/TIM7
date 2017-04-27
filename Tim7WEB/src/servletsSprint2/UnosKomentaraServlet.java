package servletsSprint2;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Forum;
import operacije.RegistracijaRemote;

/**
 * Servlet implementation class UnosKomentaraServlet
 */
@WebServlet("/UnosKomentaraServlet")
public class UnosKomentaraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	private RegistracijaRemote rrm;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosKomentaraServlet() {
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
		String objava = request.getParameter("objava");
		Forum f = (Forum) request.getSession().getAttribute("forum");
		if(rrm.unosObjave(objava, f)){
			String message = "Uspesan unos objave!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("searchedForum.jsp").forward(request, response);
		}else{
			String message = "Neuspesan unos objave!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("searchedForum.jsp").forward(request, response);
		}
	}

}
