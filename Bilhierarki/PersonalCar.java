/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *@param  String regNumber
 * @author hani
 */
public class PersonalCar extends FossilCar {
    private int numberOfSeats;
    PersonalCar(String regNumber,String name ,double utslipp , int numberOfSeats){


        super(name,regNumber,utslipp);
        this.numberOfSeats = numberOfSeats;

    }
public int antallSeter(){
    return numberOfSeats;

}
/**
*function returns the info of the car
*
*/
public void getInfo(){
    super.getInfo();
    System.out.printf("Number of seats:%d\n", numberOfSeats);
    System.out.println("----------------------");

    }

}
