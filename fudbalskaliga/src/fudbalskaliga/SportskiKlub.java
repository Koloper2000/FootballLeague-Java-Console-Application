package fudbalskaliga;

public abstract class SportskiKlub {
	private String ime;
	private String lokacija;
	
	
	@Override
    public boolean equals(Object o) {
        return this.ime.equals(((SportskiKlub)o).ime);
    }
    
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getLokacija() {
		return lokacija;
	}
	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}
	
	
}
