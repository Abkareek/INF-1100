

public class Legeliste extends OrdnetLenkeliste<Lege> {
    protected String [] listeNaven;
    protected Node check = null;
    protected Node other = null;
    protected Lege out ;
    protected int i = 0;
	//OrdnetLenkeliste<Lege> liste = new OrdnetLenkeliste<Lege>();
	/**
     * Soeker gjennom listen etter en lege med samme navn som `navn`
     * og returnerer legen (uten aa fjerne den fra listen).
     * Hvis ingen slik lege finnes, returneres `null`.
     * @param   navn    navnet til legen
     * @return  legen
     */
    public Lege finnLege(String navn) {
        check = head;
        if (super.erTom()){
            out = null;
        }else {
            while(check != null){
                if (check.item.hentNavn().compareTo(navn)== 0){
                    out = check.item;
                    break;
                }else{
                    check = check.next;
                }
            }
        }
        return out;

    }

    /**
     * Returnerer et String[] med navnene til alle legene i listen
     * i samme rekkefoelge som de staar i listen.
     * @return array med navn til alle legene
     */
    public String[] stringArrayMedNavn() {
        // fullfoer metoden
        listeNaven = new String[super.storrelse()];
        other = head;
        while (other != null){
            listeNaven[i] = other.item.hentNavn();
            i++;
            other = other.next;
        }
    	return listeNaven;
    }

}
