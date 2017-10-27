package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Utilisateur;
import services.UtilisateurService;
import services.implementations.UtilisateurServiceImplementation;

@WebServlet("/utilisateur/index")
public class IndexUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurService utilisateurService = new UtilisateurServiceImplementation();      
   
    public IndexUtilisateur() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Utilisateur> listUtilisateurs = null;
		
		listUtilisateurs = utilisateurService.readAll();
		request.setAttribute("listeUtilisateurs", listUtilisateurs);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
