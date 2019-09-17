
public class BlaaResept extends Resept {
	public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
		// TODO Auto-generated constructor stub
		super(legemiddel, utskrivendeLege, pasientId, reit);
	}

	@Override
	public String farge() {
		// TODO Auto-generated method stub
		return "blue";
	}

	@Override
	public double prisAaBetale() {
		// TODO Auto-generated method stub
		return 0.25 * legemiddel.hentPris();
	}

}
