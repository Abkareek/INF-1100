/*
 * A class represents an electrical car
 * A car is defined by its model name and its plate number
 * An electrical car has a battary Capasity in addition to
 * what any car would be defind with.
 */

/**
 *
 * @author hani
 */
public class Elcar extends Car {
    private double battaryCapasity ;
    Elcar(String name,String skilt, double batCap){
        super(name,skilt);
        this.battaryCapasity = batCap;

    }
    public void  getInfo(){
         super.getInfo();
         System.out.printf("Battaty Capasity:%8.2f \n", battaryCapasity);
         System.out.println("----------------------");

    }


}
