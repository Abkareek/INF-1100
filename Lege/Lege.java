
public class Lege  implements Comparable<Lege>  {
	private String navn;

	private Koe<Resept> reseptlist;
	Lege(String navn){
		this.navn = navn;

		reseptlist = new Koe<Resept>();

	}


	public String hentNavn() {
		return this.navn;

	}
    @Override
	public int compareTo(Lege annenLeg) {
    	if (this.navn.compareTo(annenLeg.navn)> 0){
			return 1;

		}else if(this.navn.compareTo(annenLeg.navn)< 0){
			return -1;
		}else{
			return 0;
		}
    }
    public void leggTilResept(Resept resept) {
		reseptlist.settInn(resept);
    	 }
    public Koe<Resept> hentReseptliste() {
    	return reseptlist;
    }
	public String toString(){
		return hentNavn();
	}

}
