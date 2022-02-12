package fr.orsys.kingsley.fitness.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.orsys.kingsley.fitness.business.Adherent;
import fr.orsys.kingsley.fitness.business.Course;
import fr.orsys.kingsley.fitness.service.AdherentService;
import fr.orsys.kingsley.fitness.service.CourseService;
import fr.orsys.kingsley.fitness.service.impl.AdherentServiceImpl;
import fr.orsys.kingsley.fitness.service.impl.CourseServiceImpl;

/**
 * Servlet implementation class CoursesServlet
 */
@WebServlet("/courses")

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseService courseService;
	private AdherentService adherentService;

	private String cheminDeBase = System.getProperty("catalina.base");
	private String separateur = System.getProperty("file.separator");
	private String nomApplication = "fitness";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CoursesServlet() {
		super();
		courseService = new CourseServiceImpl();
		adherentService = new AdherentServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On récupères les courses d'adherent en session
		// Ensuite en poursuivre à la jsp courses.jsp
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("current year: " + dateTime.getYear());

		String strDate = dateTime.getMonthValue() + "/" + dateTime.getDayOfMonth() + "/" + dateTime.getYear();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate dateTimeForm = LocalDate.parse(strDate, formatter);

		//
		LocalDate start = YearMonth.now().atDay(1);
		LocalDate end = YearMonth.now().atEndOfMonth();

		HttpSession session = request.getSession();
		// à regarder
		Long adherentId = ((Adherent) session.getAttribute("adherent")).getId();
		Adherent adherentCourant = adherentService.recupererAdherent(adherentId);

		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dateDebut = cal.getTime();
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		Date lastDayOfMonth = cal.getTime();

		List<Course> courses = courseService.recupererCoursesParAdherentEntreDates(adherentCourant, dateDebut,
				lastDayOfMonth);

		request.setAttribute("courses", courses);
		request.getRequestDispatcher("WEB-INF/courses.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Long adherentId = ((Adherent) session.getAttribute("adherent")).getId();
		Part part = request.getPart("fichier");
		String fileName = adherentId + ".jpg";
		String fullPath = cheminDeBase + separateur + "wtpwebapps" + separateur + nomApplication + separateur + "images" +
                separateur + fileName;
		
		part.write(fullPath);

		response.sendRedirect("courses");
	}

}
