INSERT INTO login (name, login, password, accessLevel) VALUES
("Teppo Testaaja", "oppilas", "1234qwerty", "0"),
("Olli Oppilas", "oppilas1", "1234qwerty", "0"),
("Outi Oppilas", "oppilas2", "1234qwerty", "0"),
("Opettaja", "opettaja", "1234qwerty", "1");

INSERT INTO kurssit (oppilas_id, H1_arvosana, H2_arvosana, H3_arvosana, H4_arvosana,H5_arvosana,H6_arvosana, H7_arvosana) VALUES
("1", 2,3,4,1,2,3,0),
("2", 1,0,0,2,3,4,1),
("3", 2,5,2,0,0,0,2);

select * from login
natural join kurssit
where login.id = 1;
