import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
class Labyrint {

    public Rute[][] array ;
    static int antallRader;
    static int antallKoloner;
    public Stabel<String> utvier;
    private Labyrint(int rader, int koloner){
        this.antallRader = rader;
        this.antallKoloner = koloner;
        array = new Rute[rader][koloner];
        utvier = new Stabel<String>();
    }
    public Rute hentPlassen(int row, int colomn){
        return  array[row][colomn];

    }
    public void settInnStabel(String path){
        utvier.settInn(path);
    }

    @Override
    public String toString(){
        String out= "" ;
        for(int i=0; i < antallRader; i++){
            for(int j=0; j< antallKoloner; j++){

                out = out + array[i][j].tilTegn();
            }
            out += "\n";

        }
        return out;
    }

    public static  Labyrint lesFraFil(File fil) throws FileNotFoundException  {



        Scanner scanner = new Scanner(fil);
        String[]  cordinates = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(cordinates[0]);
        int colomns = Integer.parseInt(cordinates[1]);
        Labyrint maze = new Labyrint(rows,colomns);
        int x = 0;
        while(scanner.hasNextLine()) {

            String reader = scanner.nextLine();
            char[] splitter = reader.toCharArray();
            for(int i =0; i< splitter.length; i++) {
                if(splitter[i] == '#'){
                    Rute black = new SortRute(x,i, maze);
                    maze.array[x][i]= black;
                }else{
                    if(x>0 && x< antallRader-1 && i>0 && i<antallKoloner-1){
                        Rute white = new HvitRute(x,i, maze);
                        maze.array[x][i] = white;

                    }else{
                        Rute open = new Aapning(x,i, maze);
                        maze.array[x][i] = open;

                    }


                }


            }
            x++;
        }


        return maze;
    }
    public Stabel<String> finnUtveiFra(int kol, int rad){
        array[rad-1][kol-1].finnUtvei();
        return utvier;
    }

    public String settMinimalUtskrift(){
        return toString();
    }
    /**
    * Konverterer losning-String fra oblig 5 til en boolean[][]-representasjon
    * av losningstien.
    * @param losningString String-representasjon av utveien
    * @param bredde        bredde til labyrinten
    * @param hoyde         hoyde til labyrinten
    * @return              2D-representasjon av rutene der true indikerer at
    *                      ruten er en del av utveien.
    */
    static boolean[][] losningStringTilTabell(String losningString, int bredde, int  hoyde) {
        boolean [][] losning = new boolean [hoyde][bredde];
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
        java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
        while(m.find()) {
            int x = Integer.parseInt(m.group(1))-1;
            int y = Integer.parseInt(m.group(2))-1;
            losning[y][x] =   true  ;
            }
            return losning;
        }


}
