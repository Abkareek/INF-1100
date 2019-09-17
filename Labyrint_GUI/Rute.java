abstract class Rute {
    /**
    *  class that represents a path inside a maze
    */
    private Rute nord;
    private Rute sor;
    private Rute vest;
    private Rute ost;
    private Labyrint lab ;
    private int row;
    private int colomn;
    private String cordinates = "";
    private String path = "";
     boolean  check = true;
    /**
    constructor of the abstract class that takes the cordinates as
    arguments.
    @param row which represents the y cordinate for each item
    inside the maze
    @param colomn which  represents the x cordinate for each item
    inside the maze


    */

    Rute(int row, int colomn, Labyrint l){
        this.lab = l;
        this.row = row;
        this.colomn = colomn;
        //check = new boolean [lab.antallRader][lab.antallKoloner];




    }
    /**
    Method returens the northen cell of the a specifec cordinates
    @param row x axis cordinate
    @param colomn y axis cordinate
    @ return nord
    */
    public Rute getNorth(int row, int colomn){
        nord = lab.hentPlassen(row-1, colomn);
        return nord;

    }
    /**
    Method returens the northen cell of the a specifec cordinates
    @param row x axis cordinate
    @param colomn y axis cordinate
    @ return sor
    */
    public Rute getSouth(int row, int colomn){
        sor = lab.hentPlassen(row+1, colomn);

        return sor;
    }
    /**
    Method returens the northen cell of the a specifec cordinates
    @param row x axis cordinate
    @param colomn y axis cordinate
    @ return vest
    */
    public Rute getWest(int row, int colomn){
        vest = lab.hentPlassen(row, colomn-1);
        return vest;
    }
    /**
    Method returens the northen cell of the a specifec cordinates
    @param row x axis cordinate
    @param colomn y axis cordinate
    @ return ost
    */
    public Rute getEast(int row, int colomn){
        ost = lab.hentPlassen(row, colomn+1);
        return ost;
    }
    /**
    method to find all the possible ways to exit a maze
    @param cordinates String describes
    @ return boolean
    */

    public void finnUtvei(){
        gaa("");

    }
    public boolean validCell(int row, int colomn){
        if(row <=0 || colomn <=0 || row >lab.antallRader || colomn > lab.antallKoloner){
        return false;
    } else{
        return true;
    }

    }
    /**
        A method that  recursively returens the actuall path to the solution
    */
    public void gaa(String cordinates){
        check = false;
        path =cordinates+" ("+(colomn+1)+","+(row+1)+" ) -->";
        //path = cordinates+" ("+(row+1)+","+(colomn+1)+" ) -->";
        // if find an exit append it to the list
        if (this  instanceof Aapning){
            path = path.substring(0,(path.length() -3));
            lab.settInnStabel(path);
            return;
        }

        // GA NORTH
        if (this.getNorth(row, colomn) instanceof HvitRute  && getNorth(row, colomn).check){
            getNorth(row, colomn).gaa(path);

        }
        // GO EAST
        if (this.getEast(row, colomn) instanceof HvitRute  && getEast(row, colomn).check){
            getEast(row, colomn).gaa(path);

        }
        // GO WEST
        if (this.getWest(row, colomn) instanceof HvitRute  && getWest(row, colomn).check){
            getWest(row, colomn).gaa(path);

        }
        // GO SOUTH
        if (this.getSouth(row, colomn) instanceof HvitRute  && getSouth(row, colomn).check){
            getSouth(row, colomn).gaa(path);

        }
        // IF NOT RESET CHECK
        check = true;





    }
    public String getPath(){
        return path;
    }

    public abstract char tilTegn();
    public String getCord(){
        return " ("+(colomn+1)+","+(row+1)+" )";
    }


}
