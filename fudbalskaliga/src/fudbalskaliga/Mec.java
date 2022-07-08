package fudbalskaliga;

import java.util.Date;

public class Mec {

	private FudbalskiKlub timA;
    private FudbalskiKlub timB;
    private int timAPostigao;
    private int timBPostigao;
    private Date date;
	
    public FudbalskiKlub getTimA() {
		return timA;
	}
	public void setTimA(FudbalskiKlub timA) {
		this.timA = timA;
	}
	public FudbalskiKlub getTimB() {
		return timB;
	}
	public void setTimB(FudbalskiKlub timB) {
		this.timB = timB;
	}
	public int getTimAPostigao() {
		return timAPostigao;
	}
	public void setTimAPostigao(int timAPostigao) {
		this.timAPostigao = timAPostigao;
	}
	public int getTimBPostigao() {
		return timBPostigao;
	}
	public void setTimBPostigao(int timBPostigao) {
		this.timBPostigao = timBPostigao;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
    
}
