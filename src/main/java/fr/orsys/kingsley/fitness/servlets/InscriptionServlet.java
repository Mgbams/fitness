package fr.orsys.kingsley.fitness.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.orsys.kingsley.fitness.business.Adherent;
import fr.orsys.kingsley.fitness.service.AdherentService;
import fr.orsys.kingsley.fitness.service.impl.AdherentServiceImpl;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private AdherentService adherentService = new AdherentServiceImpl(); 
	private Adherent adherent;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdherentService adherentService = new AdherentServiceImpl();
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String motDePasse = request.getParameter("motDePasse");
		
		adherent = new Adherent(nom, prenom, email, motDePasse);
		
		adherentService.ajouterAdherent(adherent);
		
		request.getRequestDispatcher("WEB-INF/inscription.jsp").forward(request, response);
		
	}

}
