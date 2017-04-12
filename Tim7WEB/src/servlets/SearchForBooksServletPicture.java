package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchForBooksServletPicture
 */
@WebServlet("/SearchForBooksServletPicture")
public class SearchForBooksServletPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchForBooksServletPicture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    final String DB_URL = "jdbc:mysql://nastava.is.pmf.uns.ac.rs:3306/pris";
	    final String User = "pris";
	    final String Password = "pris";
	    try {
	        Class.forName(JDBC_DRIVER);
	        Connection conn = DriverManager.getConnection(DB_URL, User, Password);

	        PreparedStatement stmt = conn.prepareStatement("select SLIKA from KNJIGA2 where IDKNJIGA=?");
	        stmt.setLong(1, Long.valueOf(request.getParameter("id")));
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            response.setContentType("image/gif");
	            response.getOutputStream().write(rs.getBytes("SLIKA"));
	            request.getRequestDispatcher("searchForBooks.jsp").forward(request, response);
	        }
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
