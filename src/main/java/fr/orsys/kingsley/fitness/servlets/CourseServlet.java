package fr.orsys.kingsley.fitness.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import fr.orsys.kingsley.fitness.business.Tapis;
import fr.orsys.kingsley.fitness.service.AdherentService;
import fr.orsys.kingsley.fitness.service.CourseService;
import fr.orsys.kingsley.fitness.service.TapisService;
import fr.orsys.kingsley.fitness.service.impl.AdherentServiceImpl;
import fr.orsys.kingsley.fitness.service.impl.CourseServiceImpl;
import fr.orsys.kingsley.fitness.service.impl.TapisServiceImpl;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HttpSession session;
	private TapisService tapisService;
	private AdherentService adherentService;

	private List<Tapis> tapis;
	private CourseService courseService;

	private Course course;
	private static boolean idExists;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseServlet() {
		super();
		tapisService = new TapisServiceImpl();
		tapis = new ArrayList<>();
		courseService = new CourseServiceImpl();
		adherentService = new AdherentServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		tapis = tapisService.recupererDesTapis();

		if (request.getParameter("courseId") != null) {
			Long courseId = Long.parseLong(request.getParameter("courseId"));
			idExists = true;
			course = courseService.recupererCourse(courseId);
			String tapisSelectionne = course.getTapis().getDesignation();
			
			// Split de dateHeure
			LocalDateTime localDateTime = course.getDateHeureDebut();
	        LocalDate dateFromDateTime = localDateTime.toLocalDate();
	        LocalTime timeFromDateTime = localDateTime.toLocalTime();
	        
	        request.setAttribute("idExists", idExists);
	        request.setAttribute("courseId", courseId);
	        request.setAttribute("dateFromDateTime", dateFromDateTime);
	        request.setAttribute("timeFromDateTime",  timeFromDateTime);
			request.setAttribute("course", course);
			request.setAttribute("tapis", tapis);
			request.setAttribute("tapisSelected", tapisSelectionne);
			request.getRequestDispatcher("WEB-INF/course.jsp").forward(request, response);
		}
		request.setAttribute("tapis", tapis);
		request.getRequestDispatcher("WEB-INF/course.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int distance = Integer.parseInt(request.getParameter("distance"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		Float calories = Float.parseFloat(request.getParameter("calories"));

		String tapisId = request.getParameter("tapis");
		Tapis tapisAjoute = tapisService.recupererTapis(Long.parseLong(tapisId));

		String minuteHeure = request.getParameter("minuteHeure");
		String dateEntree = request.getParameter("dateEntree");

		// LocalDateTime Format
		String strDate = dateEntree + " " + minuteHeure;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(strDate, formatter);

		session = request.getSession();
		Long idAdherent = (Long)session.getAttribute("idAdherent");
		Adherent adherentCourant = adherentService.recupererAdherent(idAdherent);
		
		course = new Course(idAdherent, calories, dateTime, duree, distance, adherentCourant, tapisAjoute);
		 
		if (request.getParameter("courseAModifierId") != null) {
			// Mise à jour de course
			courseService.modifierCourse(course);
		} else {
			// Ajout de course
			courseService.ajouterCourse(course);
		}
		response.sendRedirect("courses");
	}

}
