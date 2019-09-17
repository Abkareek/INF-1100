
public class Pasient  {
	public static int overAllId = 0;

	protected String navn;
	protected Long fodselsnummer;
	protected String gateadresse;
	protected int postnummer;
	protected int id;
	Stabel<Resept> liste;
	Pasient(int id ,String navn, long fodselsnummer, String gateadresse,
            int postnummer) {
		this.navn = navn;
		this.fodselsnummer = fodselsnummer;
		this.gateadresse = gateadresse;
		this.postnummer = postnummer;
		this.id = id;
		liste = new Stabel<Resept>();
	}

	Pasient(String navn, long fodselsnummer, String gateadresse,
            int postnummer) {
		this.navn = navn;
		this.fodselsnummer = fodselsnummer;
		this.gateadresse = gateadresse;
		this.postnummer = postnummer;
		this.id = Pasient.overAllId++;
		liste = new Stabel<Resept>();
	}
	@Override
	public String toString() {
		return "navn :"+ this.navn +" fodselsnummer:"+ this.fodselsnummer
		+"postnummer"+ this.postnummer ;
	}

    public int hentId() {
    	return this.id;
    	}
    public String hentNavn() {
    	return navn;
    	}
    public long hentFodselsnummer() {
    	return fodselsnummer;
    	}
    public String hentGateadresse() {
    	return gateadresse;
    }
    public int hentPostnummer() {
    	return postnummer;
    	}
    public void leggTilResept(Resept resept) {
    	liste.settInn(resept);
    	 }
    public Stabel<Resept> hentReseptliste() {
    	return liste;

    }

}
