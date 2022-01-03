package avenue814.controller.GestioneProdotti;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import avenue814.model.*;



@WebServlet("/addProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 3,
				maxFileSize = 1024 * 1024 * 10,
				maxRequestSize = 1024 * 1024 * 50)
public class AggiungiProdottoServlet extends HttpServlet{
	
	private static Logger logger = Logger.getLogger("global");
	
	public AggiungiProdottoServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDAO productModel = new ProductDAO();
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("profilo");
		
		if(user == null) {/*Eccezione*/
			request.setAttribute("errore", "Non hai accesso a questa pagina");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/PaginaAddon/errorpage.jsp");
			dispatcher.forward(request, response);
		}
		
		
		String nome = request.getParameter("nome_prodotto");
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		
		try {
			ProductBean product = productModel.retrieveProductByName(nome);
			if(product != null && product.getPrezzo() == prezzo) {
				logger.info("Il prodotto gi� esiste, modifichiamo solo la quantit�...");
				product.setQuantita(product.getQuantita() + quantita);
				productModel.aggiungiQuantita(product);
				productModel.toUpdateDisp(product, true);
				response.sendRedirect("/Avenue814/PaginaShop/shop.jsp");
				return;
			}else if(product != null) {
				session.setAttribute("error", "Nome gi� esistente");
				response.sendRedirect("/Avenue814/PaginaShop/aggiungi_prodotti.jsp");
				return;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String categoria = request.getParameter("categoria");
		String sesso = request.getParameter("sesso");
		String descrizione = request.getParameter("descrizione");
		ArrayList<String> files = null;
		String savePath = "C:\\Users\\Utente\\git\\ProgettoIS_Avenue814\\Avenue814\\WebContent\\IMAGES_PRODOTTI";
		String savePath2 = "/Avenue814/IMAGES_PRODOTTI/";
		String stringa = "";
		int flag = 1;
		if(request.getParts() != null && request.getParts().size() > 0) {
			logger.info("Troviamo il percorso...");
			for(Part part: request.getParts()) {
				String filename = extractFileName(part);
					try {
						files = productModel.getPathFiles();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					for(String e: files) {
						if(filename.equals(e)) {
							String temp = filename;
							String[] temp1 = temp.split(Pattern.quote("."));
							
							temp1[0] = nome+"_"+categoria;
							filename = temp1[0]+"."+temp1[1];
							if(filename != null && !filename.equals("")) {
								part.write(savePath +File.separator +filename);
								stringa = savePath2+filename;
								flag = 0;
							}
						}
					}
				 
				if(filename != null && !filename.equals("") && flag == 1) {
					part.write(savePath +File.separator +filename);
					stringa = savePath2+filename;
				}
			}
		}
		
		logger.info("Percorso finale: "+stringa);
		
		ProductBean bean = new ProductBean(nome, prezzo, descrizione, categoria, quantita, stringa, sesso, true);
		
		try {
			logger.info("Inserimento nuovo prodotto "+bean.getNome()+"...");
			productModel.doSave(bean, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("error", null);
		response.sendRedirect("/Avenue814/PaginaShop/shop.jsp?Sesso=uomo");
		
	}
	
	private String extractFileName(Part part) {
		//content-disposition: form-data; name="foto"; filename="file.txt";
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s: items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=")+2, s.length() - 1);
			}
		}
		return "";
	}
	
}
