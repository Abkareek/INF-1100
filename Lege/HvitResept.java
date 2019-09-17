
public class HvitResept extends Resept {
	String farge = "Hvit";
	public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
		// TODO Auto-generated constructor stub
		super(legemiddel, utskrivendeLege, pasientId, reit);
	}
	public String farge() {
		// TODO Auto-generated method stub
		return this.farge();
	}


	public double prisAaBetale() {
		// TODO Auto-generated method stub
		return legemiddel.hentPris();
	}

}
