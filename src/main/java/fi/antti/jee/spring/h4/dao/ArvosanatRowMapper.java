package fi.antti.jee.spring.h4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import fi.antti.jee.spring.h4.bean.Arvosanat;

public class ArvosanatRowMapper implements RowMapper<Arvosanat> {
	
	public Arvosanat mapRow(ResultSet rs, int rowNum) throws SQLException {
		Arvosanat a = new Arvosanat();
				
		a.setId(rs.getInt("id"));
		a.setH1(rs.getInt("H1_arvosana"));
		a.setH2(rs.getInt("H2_arvosana"));
		a.setH3(rs.getInt("H3_arvosana"));
		a.setH4(rs.getInt("H4_arvosana"));
		a.setH5(rs.getInt("H5_arvosana"));
		a.setH6(rs.getInt("H6_arvosana"));
		a.setH7(rs.getInt("H7_arvosana"));
		
		return a;
	}


}
