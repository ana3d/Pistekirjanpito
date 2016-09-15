package fi.antti.jee.spring.h4.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.antti.jee.spring.h4.bean.Arvosanat;
import fi.antti.jee.spring.h4.bean.User;
import fi.antti.jee.spring.h4.dao.ArvosanatDAO;
import fi.antti.jee.spring.h4.dao.UserDAO;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/Login")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(CheckLogin.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("CheckLogin.doPost()");

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		UserDAO db = (UserDAO) context.getBean("daoLuokka");
		ArvosanatDAO aDb = (ArvosanatDAO)context.getBean("arvosanatDaoLuokka");

		String login = "" + request.getParameter("username");
		String password = request.getParameter("password");

		String jsp = "/WEB-INF/login.jsp";

		User user = new User();
		user.setLogin(login);
		user = db.etsiUser(login);
		logger.info("Tarkistetaan t‰sm‰‰kˆ salasana");
		
		if (user == null || !password.equals(user.getPassword()) ) {

			request.setAttribute("error_message",
					"Wrong username or password, please try again!");
			RequestDispatcher dp = getServletContext()
					.getRequestDispatcher(jsp);
			logger.info("Siirret‰‰n takaisin kirjautumaan");
			dp.forward(request, response);
		}	
		
		
		if (password.equals(user.getPassword())) {
			jsp = "/WEB-INF/authorized.jsp";
			RequestDispatcher dp = getServletContext()
					.getRequestDispatcher(jsp);
			request.setAttribute("user", user);
			request.setAttribute("accessLevel", user.getAccessLevel());
			
			if (user.getAccessLevel() == 0) {
			Arvosanat arvosana = aDb.etsi(user.getId());
			request.setAttribute("arvosana", arvosana);
			logger.info("Haetaan oppilaan omat arvosanat ");
			}
			
			if (user.getAccessLevel() == 1){
				List<Arvosanat> arvosanat = aDb.haeKaikki();
				List<User> students = db.haeKaikkiOppilaat();
				request.setAttribute("arvosanat", arvosanat);
				request.setAttribute("students", students);
				logger.info("Haetaan tarvittavat tiedot opettajan n‰kym‰‰n");
		
			}
			
			if (user.getAccessLevel() == 2){ // Admin view
				List<User> students = db.haeKaikkiKayttajat();
				request.setAttribute("students", students);
				logger.info("Haetaan tarvittavat tiedot admin paneeliin");
		
			}
			logger.info("Siirret‰‰n kirjautuneen k‰ytt‰j‰n n‰kym‰‰n & lis‰t‰‰n oikeudet mit‰ n‰hd‰‰n.");
			
			dp.forward(request, response);
			
		}
		

	}

	
	
	
}
