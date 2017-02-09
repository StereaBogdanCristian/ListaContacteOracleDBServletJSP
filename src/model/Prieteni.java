package model;

public class Prieteni {

	private int id;
	private String nume;
	private String prenume;
	private String email;
	private String nrTel;
	private int varsta;
	
	
	public Prieteni(int id, String nume, String prenume, String email, String nrTel, int varsta) {
		super();
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.nrTel = nrTel;
		this.varsta = varsta;
	}
	
	public Prieteni() {
		super();
		this.id = 0;
		this.nume = "";
		this.prenume = "";
		this.email = "";
		this.nrTel = "";
		this.varsta = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNrTel() {
		return nrTel;
	}

	public void setNrTel(String nrTel) {
		this.nrTel = nrTel;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	@Override
	public String toString() {
		return "Prieteni [id=" + id + ", nume=" + nume + ", prenume=" + prenume + ", email=" + email + ", nrTel="
				+ nrTel + ", varsta=" + varsta + "]";
	}
	
	
	
	
}
