package fi.antti.jee.spring.h4.servlet;

import java.io.IOException;

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

/**
 * Servlet implementation class Controller
 */
//@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(Controller.class);

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    	System.out.println("Controller.Controller()");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubs
	System.out.println("Controller.doGet()");	
	
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	
	
	String jsp = "/WEB-INF/login.jsp";

	RequestDispatcher dp = getServletContext().getRequestDispatcher(jsp);
	logger.info("Siirret‰‰n kirjautumaan");
	dp.forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Controller.doPost()");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		

		
	}
}
