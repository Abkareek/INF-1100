
public class Legemiddel {
	public static int middelID  = 0;
	protected String navn;
	protected int id;
	protected double pris;
	protected double virkestoff;
	protected String type;
	public Legemiddel(String navn , double pris, double virkestoff){
		this.navn = navn;
		this.pris = pris;
		this.virkestoff = virkestoff;
		this.id = middelID;
		middelID ++;

	}
    public int hentId() {
    	return id;
    }
    public String hentNavn() {
    	return navn;
    	}
    public double hentPris() {
    	return pris;
    }
    public double hentVirkestoff() {
    	return virkestoff;
    }
	public String toString(){
		return "ID :"+ this.id+ "navn :"+ this.navn+"type :"+ this.type + "pris: "+ this.pris+ "virkestoff"+
		this.virkestoff;
	}


}
