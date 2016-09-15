package fi.antti.jee.spring.h4.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fi.antti.jee.spring.h4.bean.User;

public class UserDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void talleta(User u) {
		String sql = "insert into login(name, login, password, accessLevel) values(?,?,?,?)";
		Object[] parametrit = new Object[] { u.getName(), u.getLogin(), u.getPassword(), u.getAccessLevel() };

		jdbcTemplate.update(sql, parametrit);

	}

	public User etsi(int id) {
		String sql = "select name, login, password, accessLevel, id from login where id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<User> mapper = new UserRowMapper();

		User u = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		return u;

	}
	
	public User etsiUser(String login){

		String sql = "select name, login, password, accessLevel, id from login where login = ?";
		Object[] parametrit = new Object[] { login };
		RowMapper<User> mapper = new UserRowMapper();
		User u;
		try {
			u = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (Exception e) {
			u = null;
		}
		
		return u;
		
	}

	public List<User> haeKaikkiOppilaat() {

		String sql = "select name, login, password, accessLevel, id from login where accessLevel = 0";
		RowMapper<User> mapper = new UserRowMapper();
		List<User> henkilot = jdbcTemplate.query(sql, mapper);

		return henkilot;
	}
	
	public List<User> haeKaikkiKayttajat() {

		String sql = "select name, login, password, accessLevel, id from login";
		RowMapper<User> mapper = new UserRowMapper();
		List<User> henkilot = jdbcTemplate.query(sql, mapper);

		return henkilot;
	}

}
