package magazine;

public class Almanac extends Magazine{
	private int annee;
	
	public Almanac(String nom, int prix,int annee) {
		super(nom, prix);
		this.annee=annee;
		
	}
	
	@Override
	public String nomClass() {
		return "almanac "+this.annee;
	}

}
