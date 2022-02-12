package fr.orsys.kingsley.fitness.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.orsys.kingsley.fitness.business.Tapis;
import fr.orsys.kingsley.fitness.service.TapisService;
import fr.orsys.kingsley.fitness.service.impl.TapisServiceImpl;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Tapis tapisColombie;
	private Tapis tapisAmercican;
	private int nombreDeTapis = 2;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TapisService TapisService = new TapisServiceImpl();
		tapisColombie = new Tapis("12345", "Tapis Colombie");
		tapisAmercican = new Tapis("67899", "Tapis Amerique");
		
		 if ( (int) TapisService.recupererDesTapis().size()  < nombreDeTapis) {
			 TapisService.ajouterTapis(tapisAmercican);
			 TapisService.ajouterTapis(tapisColombie);
		 }
		 
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
