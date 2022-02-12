package fr.orsys.kingsley.fitness.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.orsys.kingsley.fitness.business.Adherent;
import fr.orsys.kingsley.fitness.business.Course;
import fr.orsys.kingsley.fitness.service.AdherentService;
import fr.orsys.kingsley.fitness.service.CourseService;
import fr.orsys.kingsley.fitness.service.impl.AdherentServiceImpl;
import fr.orsys.kingsley.fitness.service.impl.CourseServiceImpl;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Adherent adherent;
	private List<String> courantAdherent = new ArrayList<>();
	private String error;
	private CourseService courseService;

	private static List<Course> courses;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionServlet() {
		super();
		courses = new ArrayList<>();
		courseService = new CourseServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdherentService adherentService = new AdherentServiceImpl();

		String email = request.getParameter("email");
		String motDePasse = request.getParameter("motDePasse");

		adherent = adherentService.recupererAdherentParEmailEtMotDePasse(email, motDePasse);
		if (adherent != null) {		
			String prenomAdherent = adherent.getPrenom();
			String nomAdherent = adherent.getNom();
			String emailAdherent = adherent.getEmail();
			Long idAdherent = adherent.getId();
			String passwordAdherent = adherent.getMotDePasse();

			HttpSession session = request.getSession();
			session.setAttribute("adherent", adherent);
			if (session.getAttribute("emailAdherent") != null) {
				session.removeAttribute("prenomAdherent");
				session.removeAttribute("nomAdherent");
				session.removeAttribute("emailAdherent");
				session.removeAttribute("idAdherent");
				session.removeAttribute("passwordAdherent");
			} else {
				session.setAttribute("prenomAdherent", prenomAdherent);
				session.setAttribute("nomAdherent", nomAdherent);
				session.setAttribute("emailAdherent", emailAdherent);
				session.setAttribute("idAdherent", idAdherent);
				session.setAttribute("passwordAdherent", passwordAdherent);

			}
			response.sendRedirect("courses");
		} else {
			error = "Votre saisir est invalide";
			request.setAttribute("error", error);
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		}

	}

}
