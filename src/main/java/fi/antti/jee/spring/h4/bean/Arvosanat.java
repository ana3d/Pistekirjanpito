package fi.antti.jee.spring.h4.bean;

public class Arvosanat {

	private int id, h1, h2, h3, h4, h5, h6, h7;

	public Arvosanat(int id, int h1, int h2, int h3, int h4, int h5, int h6,
			int h7) {
		super();
		this.id = id;
		this.h1 = h1;
		this.h2 = h2;
		this.h3 = h3;
		this.h4 = h4;
		this.h5 = h5;
		this.h6 = h6;
		this.h7 = h7;
	}

	public Arvosanat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getH1() {
		return h1;
	}

	public void setH1(int h1) {
		this.h1 = h1;
	}

	public int getH2() {
		return h2;
	}

	public void setH2(int h2) {
		this.h2 = h2;
	}

	public int getH3() {
		return h3;
	}

	public void setH3(int h3) {
		this.h3 = h3;
	}

	public int getH4() {
		return h4;
	}

	public void setH4(int h4) {
		this.h4 = h4;
	}

	public int getH5() {
		return h5;
	}

	public void setH5(int h5) {
		this.h5 = h5;
	}

	public int getH6() {
		return h6;
	}

	public void setH6(int h6) {
		this.h6 = h6;
	}

	public int getH7() {
		return h7;
	}

	public void setH7(int h7) {
		this.h7 = h7;
	}

	@Override
	public String toString() {
		return "Arvosanat [id=" + id + ", h1=" + h1 + ", h2=" + h2 + ", h3="
				+ h3 + ", h4=" + h4 + ", h5=" + h5 + ", h6=" + h6 + ", h7="
				+ h7 + "]";
	}
	
}
