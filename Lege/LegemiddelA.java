class LegemiddelA extends Legemiddel {
    private int styrke;
    LegemiddelA(String navn, double pris , double virkestoff, int styrke){
        super(navn, pris, virkestoff);

        this.styrke = styrke;
    }

     public int hentNarkotiskStyrke() {
     return styrke;
 }
 public String toString(){
     return super.toString()+"Styrke :"+ this.styrke;
 }

}
