package fi.antti.jee.spring.h4.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
 * Servlet implementation class Edit
 */
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(CheckLogin.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
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
		System.out.println("Edit.doPost()");
		String jsp = "/WEB-INF/authorized.jsp";

		String id = request.getParameter("id");
		String h1 = request.getParameter("H1_arvosana");
		String h2 = request.getParameter("H2_arvosana");
		String h3 = request.getParameter("H3_arvosana");
		String h4 = request.getParameter("H4_arvosana");
		String h5 = request.getParameter("H5_arvosana");
		String h6 = request.getParameter("H6_arvosana");
		String h7 = request.getParameter("H7_arvosana");
		String editor = request.getParameter("user");

		System.out.println(id + " " + h1 + " " + h2 + " " + h3 + " " + h4 + " "
				+ h5 + " " + h6 + " " + h7);

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		UserDAO db = (UserDAO) context.getBean("daoLuokka");
		ArvosanatDAO aDb = (ArvosanatDAO) context.getBean("arvosanatDaoLuokka");

		int int_id, int_h1, int_h2, int_h3, int_h4, int_h5, int_h6, int_h7;

		int_id = Integer.parseInt(id);
		int_h1 = Integer.parseInt(h1);
		int_h2 = Integer.parseInt(h2);
		int_h3 = Integer.parseInt(h3);
		int_h4 = Integer.parseInt(h4);
		int_h5 = Integer.parseInt(h5);
		int_h6 = Integer.parseInt(h6);
		int_h7 = Integer.parseInt(h7);

		User user = db.etsi(int_id);
		Arvosanat arvosana = new Arvosanat(int_id, int_h1, int_h2, int_h3,
				int_h4, int_h5, int_h6, int_h7);

		aDb.talleta(arvosana);

		User muokkaaja = new User();

		muokkaaja.setLogin(editor);
		muokkaaja = db.etsiUser(editor);
		System.out.println(muokkaaja);
		List<Arvosanat> arvosanat = aDb.haeKaikki();
		List<User> students = db.haeKaikkiOppilaat();
		request.setAttribute("user", muokkaaja);
		request.setAttribute("accessLevel", muokkaaja.getAccessLevel());
		request.setAttribute("arvosanat", arvosanat);
		request.setAttribute("students", students);

		RequestDispatcher dp = getServletContext().getRequestDispatcher(jsp);

		dp.forward(request, response);

	}

}
