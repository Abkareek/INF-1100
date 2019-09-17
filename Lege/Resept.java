
public abstract class Resept {
	public  static int totalId;
	protected int id;
	protected Legemiddel legemiddel;
	protected Lege lege;
	protected int pasientId ;
	private int reit;
	private String farge;
	boolean  using ;
	public Resept (Legemiddel legemiddel, Lege lege, int pasientId, int reit){
		this.id  = totalId;
		this.legemiddel = legemiddel;
		this.lege = lege;
		this.pasientId = pasientId;
		this.reit = reit;
		totalId ++; // increase the static ID
		//legemiddel = new Legemiddel();



	}
	public int hentId() {
		return id;
	}
    public Legemiddel hentLegemiddel() {
		return legemiddel;

    }
    public Lege hentLege() {
		return lege;
    }
    public int hentPasientId() {
    	return pasientId;
    }
    public int hentReit() {
    	return reit;
    }

    /**
     * Bruker resepten én gang. Returner false om resepten er
     * oppbrukt, ellers returnerer den true.
     * @return      om resepten kunne brukes
     */
    public boolean bruk() {
    	using = reit !=0 ;
		reit--;
		return using;
    }
    @Override
	public String toString() {
		return this.id + "hvit/blaa "+ this.farge+ "pasientID "+ this.pasientId+
		" legenavn "+ this.lege + "legemiddelID"+ this.legemiddel+ "reit "+ this.reit;
	}

    /**
     * Returnerer reseptens farge. Enten "blaa" eller "hvit".
     * @return      reseptens farge
     */
    abstract public String farge();

    /**
     * Returnerer prisen pasienten maa betale.
     * @return      prisen pasienten maa betale
     */
    abstract public double prisAaBetale();

}
