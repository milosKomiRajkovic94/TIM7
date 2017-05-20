package servletsSprint3;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Administrator;
import operacije.LogInRemote;

/**
 * Servlet implementation class LogInServlet2
 */
@WebServlet("/LogInServlet2")
public class LogInServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private LogInRemote lim;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet2() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Administrator a = lim.ulogujAdministratora(email, password);
		if(a != null){
			request.setAttribute("a", a);
			request.getRequestDispatcher("unosZanimljivosti.jsp").forward(request, response);
		}else{
			String message = "Neuspesna prijava!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("logInAsAdministrator.jsp").forward(request, response);
		}
	}

}
