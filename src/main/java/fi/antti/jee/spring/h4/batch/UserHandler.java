package fi.antti.jee.spring.h4.batch;

import java.util.List;

import fi.antti.jee.spring.h4.bean.Arvosanat;
import fi.antti.jee.spring.h4.bean.User;
import fi.antti.jee.spring.h4.dao.ArvosanatDAO;
import fi.antti.jee.spring.h4.dao.UserDAO;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserHandler {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		UserDAO db = (UserDAO)context.getBean("daoLuokka");
		
		System.out.println("********************************************");
		System.out.println("**LISTATAAN TIETOKANNASSA OLEVAT KÄYTTÄJÄT**");
		System.out.println("********************************************");
		
		List<User> user = db.haeKaikkiKayttajat();
		for (User u : user) {
			System.out.println(u.toString());
		}

	
		System.out.println("Haetaan oppilas ID=2");
		User oppilas2 = db.etsiUser("oppilas");
		System.out.println(oppilas2);
		
		
		ArvosanatDAO aDb = (ArvosanatDAO)context.getBean("arvosanatDaoLuokka");
		
		
		
		System.out.println("*********************************************************");
		System.out.println("**LISTATAAN TIETOKANNASSA OLEVAT Oppilaat arvosanoineen**");
		System.out.println("*********************************************************");
		
		List<Arvosanat> arvosana = aDb.haeKaikki();
		for (Arvosanat a : arvosana) {
			System.out.println(a.toString());
		}
		
		context.close();
		
		
	}


}
