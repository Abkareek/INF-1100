import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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
}
