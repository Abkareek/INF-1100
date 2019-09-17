class LegemiddelB extends Legemiddel {
    private int styrke;
    LegemiddelB(String navn, double pris, double virkestoff, int styrke){
        super(navn , pris, virkestoff);

        this.styrke = styrke;
    }
public int hentVanedannendeStyrke() {
return styrke;
}
public String toString(){
    return super.toString()+ "styrke :"+ styrke;
}


}
