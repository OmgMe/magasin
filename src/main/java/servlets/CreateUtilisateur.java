package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import entities.Utilisateur;
import forms.UtilisateurForm;
import services.UtilisateurService;
import services.implementations.UtilisateurServiceImplementation;

@WebServlet("/utilisateur/create")
public class CreateUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurService utilisateurService = new UtilisateurServiceImplementation();   
  
    public CreateUtilisateur() 
    {
       
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		
		UtilisateurForm utilisateurForm = new UtilisateurForm();
		utilisateurForm.setEmail(email);
		utilisateurForm.setMdp(mdp);
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<UtilisateurForm>> constraints = validator.validate(utilisateurForm);
		
		if (constraints.isEmpty()) {
			Utilisateur utilisateur = new Utilisateur(nom, prenom, email, mdp);
			utilisateurService.create(utilisateur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
			.forward(request, response);
		}
		else {
			
			HashMap<String, String> errors = new HashMap<String, String>();
			for (ConstraintViolation<UtilisateurForm> c : constraints) {
				errors.put(c.getPropertyPath().toString(), c.getMessage());
			}
			request.setAttribute("contraintes", errors);				
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp")
			.forward(request, response);
		}
		
	}
	
	/*UserForm uf = new UserForm();
	uf.setLogin(req.getParameter("login"));
	uf.setPassword(req.getParameter("password"));
	Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	Set<ConstraintViolation<UserForm>> constraints = validator.validate(uf);
	
	if (constraints.isEmpty()) {
		Utilisateur utilisateur = new Utilisateur(nom, prenom, email, mdp);
	
		utilisateurService.create(utilisateur);
	}
	else {
		HashMap<String, String> errors = new HashMap<String, String>();
		for (ConstraintViolation<UserForm> c : constraints) {
			errors.put(c.getPropertyPath().toString(), c.getMessage());
		}
		req.setAttribute("contraintes", errors);				
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp")
		.forward(req, res);
	}*/

}
