CREATE TABLE login(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	login VARCHAR(255),
	password VARCHAR(255),
	accessLevel INT,
	isDeleted BOOLEAN NOT NULL DEFAULT 0,
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE kurssit(
	id INT NOT NULL AUTO_INCREMENT,
	oppilas_id INT NOT NULL,
	H1_arvosana INT,
	H2_arvosana INT,
	H3_arvosana INT,
	H4_arvosana INT,
	H5_arvosana INT,
	H6_arvosana INT,	
	H7_arvosana INT,
	PRIMARY KEY (id),
	FOREIGN KEY (oppilas_id) REFERENCES login(id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;