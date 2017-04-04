package servlets;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Knjiga2;
import model.Korisnik;
import operacije.RegistracijaRemote;

/**
 * Servlet implementation class InsertionOfBookServlet
 */
@WebServlet("/InsertionOfBookServlet")
public class InsertionOfBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private RegistracijaRemote rrm;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertionOfBookServlet() {
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
	//Dodavanje ostatka metoda za unos knjige.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Korisnik k = (Korisnik) request.getSession().getAttribute("k");
		String naslov = request.getParameter("naslov"); 
		String autor = request.getParameter("autor");
		String oblast = request.getParameter("oblast");
		String opis = request.getParameter("opis");
		String best = request.getParameter("bestseller");
		boolean bestseller = false;
		if(best == "true"){
			bestseller = true;
			String file = request.getParameter("slika");
			byte[] img = extractBytes(file);
			//nije dobra provera pokusacu Exception da napravim, ali u svakom slucaju unosi slike u tom okviru.
			if(img.length < 4147339){
				Knjiga2 knjiga = new Knjiga2(autor, bestseller, naslov, oblast, opis, img, k);
				if(rrm.unesiKnjigu(knjiga)){
					String message = "Uspesan unos knjige!";
					request.setAttribute("message", message);
					request.getRequestDispatcher("insertionOfBook.jsp").forward(request, response);
				}
			}else{
				String message = "Neuspesan unos knjige, zbog velicine slike, kompresujte sliku!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("insertionOfBook.jsp").forward(request, response);
			}
		}else{
			String file = request.getParameter("slika");
			byte[] img = extractBytes(file);
			if(img.length < 4147339){
				Knjiga2 knjiga = new Knjiga2(autor, bestseller, naslov, oblast, opis, img, k);
				if(rrm.unesiKnjigu(knjiga)){
					String message = "Uspesan unos knjige!";
					request.setAttribute("message", message);
					request.getRequestDispatcher("insertionOfBook.jsp").forward(request, response);
				}
			}else{
				String message = "Neuspesan unos knjige, zbog velicine slike, kompresujte sliku!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("insertionOfBook.jsp").forward(request, response);
			}
		}
	}
	
	/*
	Metoda za pretvaranje fajla  (putanje do fajla) u niz bajtova, kako bi sacuvali istu sliku
	u bazi podataka.
	 */
	public byte[] extractBytes (String ImageName) throws IOException {
		 // open image
		 File imgPath = new File(ImageName);
		 BufferedImage bufferedImage = ImageIO.read(imgPath);

		 // get DataBufferBytes from Raster
		 WritableRaster raster = bufferedImage .getRaster();
		 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

		 return ( data.getData() );
		}

}
