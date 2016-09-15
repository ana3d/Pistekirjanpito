package fi.antti.jee.spring.h4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.antti.jee.spring.h4.bean.User;

public class UserRowMapper implements RowMapper<User> {
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		u.setLogin(rs.getString("login"));
		u.setPassword(rs.getString("password"));
		u.setAccessLevel(rs.getInt("accessLevel"));		
		
		return u;
	}

}
