package fi.antti.jee.spring.h4.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.antti.jee.spring.h4.bean.Arvosanat;
import fi.antti.jee.spring.h4.bean.User;
import fi.antti.jee.spring.h4.dao.ArvosanatDAO;
import fi.antti.jee.spring.h4.dao.UserDAO;

/**
 * Servlet implementation class NewUser
 */
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("NewUser.doPost()");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		UserDAO db = (UserDAO) context.getBean("daoLuokka");
		ArvosanatDAO aDb = (ArvosanatDAO)context.getBean("arvosanatDaoLuokka");

		String name = request.getParameter("name");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String accessLevel = request.getParameter("accessLevel");
		String adder = request.getParameter("user");
		
		String jsp = "/WEB-INF/authorized.jsp";
		
		User uusiKayttaja = new User();
		
		uusiKayttaja.setName(name);
		uusiKayttaja.setLogin(login);
		uusiKayttaja.setPassword(password);
		uusiKayttaja.setAccessLevel(Integer.parseInt(accessLevel));
		db.talleta(uusiKayttaja);
		
		if (uusiKayttaja.getAccessLevel() == 0) {
			Arvosanat defaultArvosanat = new Arvosanat();
			uusiKayttaja = db.etsiUser(login);
			defaultArvosanat.setId(uusiKayttaja.getId());
			aDb.uudetArvosanat(defaultArvosanat);
			
		}
		
		User lisaaja = new User();

		lisaaja.setLogin(adder);
		lisaaja = db.etsiUser(adder);
		List<User> allUsers = db.haeKaikkiKayttajat();
		request.setAttribute("user", lisaaja);
		request.setAttribute("accessLevel", lisaaja.getAccessLevel());
		request.setAttribute("students", allUsers);
		
		RequestDispatcher dp = getServletContext().getRequestDispatcher(jsp);
		
		dp.forward(request, response);
		
		
	}

}
