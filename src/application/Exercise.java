package application;

public class Exercise {
	private int id = -1;
	private String navn;
	private String beskrivelse;
	private boolean erStyrkeOvelse;
	
	Exercise(String navn, String beskrivelse, boolean type) {
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.erStyrkeOvelse = type;
	}
	
	Exercise(int id, String navn, String beskrivelse, boolean type) {
		this.id = id;
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.erStyrkeOvelse = type;
	}
	
	public String toString() {
		return navn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public boolean erStyrkeOvelse() {
		return erStyrkeOvelse;
	}

	public void setErStyrkeOvelse(boolean type) {
		this.erStyrkeOvelse = type;
	}

}
