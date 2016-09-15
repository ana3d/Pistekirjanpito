package fi.antti.jee.spring.h4.dao;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fi.antti.jee.spring.h4.bean.Arvosanat;

public class ArvosanatDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void talleta(Arvosanat a) {
		String sql = "UPDATE kurssit SET H1_arvosana = ? , H2_arvosana = ? , H3_arvosana = ? , H4_arvosana = ?, H5_arvosana = ?, H6_arvosana = ? , H7_arvosana = ? WHERE oppilas_id = ?";
		Object[] parametrit = new Object[] { a.getH1(), a.getH2(), a.getH3(), a.getH4(), a.getH5(), a.getH6(), a.getH7(), a.getId() };

		jdbcTemplate.update(sql, parametrit);

	}
	
	public void uudetArvosanat(Arvosanat a) {
		String sql = "insert into kurssit(oppilas_id) values(?)";
		Object[] parametrit = new Object[] {  a.getId() };

		jdbcTemplate.update(sql, parametrit);

	}

	public Arvosanat etsi(int id) {
		String sql = "select * from kurssit join login where oppilas_id = login.id and oppilas_id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Arvosanat> mapper = new ArvosanatRowMapper();

		Arvosanat a = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		return a;

	}

	/*
	 * select * from login
natural join kurssit
where login.id = 1;
	 * 
	 */
	
	public List<Arvosanat> haeKaikki() {

		String sql = "select * from login natural join kurssit";
		RowMapper<Arvosanat> mapper = new ArvosanatRowMapper();
		List<Arvosanat> arvosanat = jdbcTemplate.query(sql, mapper);

		return arvosanat;
	}

}
