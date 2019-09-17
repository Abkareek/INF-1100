/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
