package servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		Blob image = null;
		Connection con = null;
		byte[ ] imgData = null ;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://nastava.is.pmf.uns.ac.rs:3306/pris","pris","pris");
			stmt = con.prepareStatement("SELECT SLIKA FROM KNJIGA2 WHERE IDKNJIGA=?");
	        stmt.setLong(1, Long.valueOf(request.getParameter("idknjiga")));
			rs = stmt.executeQuery();

			if (rs.next()) {
					image = rs.getBlob(1);
					imgData = image.getBytes(1,(int)image.length());

			} else {
				System.out.println("Display Blob Example");
				System.out.println("image not found for given id>");
				return;
			}

			// display the image
			response.setContentType("image/gif");
			OutputStream o = response.getOutputStream();
			o.write(imgData);
            request.getRequestDispatcher("searchForBooks.jsp").forward(request, response);
			o.flush();
			o.close();
		} catch (Exception e) {
			System.out.println("Unable To Display image");
			System.out.println("Image Display Error=" + e.getMessage());
			return;
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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