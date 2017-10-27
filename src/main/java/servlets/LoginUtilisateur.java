package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Utilisateur;
import services.UtilisateurService;
import services.implementations.UtilisateurServiceImplementation;

@WebServlet("/utilisateur/login")
public class LoginUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurService utilisateurService = new UtilisateurServiceImplementation();   
       
   
    public LoginUtilisateur() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Utilisateur utilisateur = null;
		Boolean erreur = false;
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		utilisateur = utilisateurService.login(email, mdp);
		
		if (utilisateur != null)
		{
			
				HttpSession session = request.getSession();
				session.setAttribute("userconnecte", utilisateur);
				request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			
		}
		
		else
		{
			erreur=true;
			request.setAttribute("erreur", erreur);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

			//response.sendRedirect("index");
		}
		
				
	}
	

}
