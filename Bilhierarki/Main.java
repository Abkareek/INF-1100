

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/* *
 * A main class the test the Car project
 * @author hani
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
    // create Scanner object to read the input file
     ArrayList <Car> car = new ArrayList<Car>(); // Creating an ArrayList with Car type to append each car type in it
    ArrayList <String> text = new ArrayList<String>();// string aaraylist to append the data extracting from the file
    //Scanner console = new Scanner(System.in);
    //System.out.println("Input file: ");
    //String inputFileName = console.next();
    String fileName = args[0]; // assign the  the first elemnet of the args array to the file name

// read the file name from the command-line
    Scanner in = new Scanner(new File(fileName));
// while loop to go over each line in the file
    while(in.hasNextLine()){
        // read each line and split it into words
        String[] ord = in.nextLine().split(" ");
        // for each word in the file read it and add it to the ArrayList text
        for(int i = 0; i < ord.length; i++){
        text.add(ord[i]);
        


        }
    }
    // now check String in the ArrayList if it is equal "El"

    for(int i=0; i<text.size();i++){
    if(text.get(i).equals("EL")){
        // create a String variable which has value of "El" it will be the variable name in Car class
        String a= text.get(i);
        // increase the counter by one
        i++;
        // read the second string and assigne it to the variable b , it will be the regNumber in Car class
        String b = text.get(i);

        i++;
        // counvert the third element to double and this will be CO2-Utslip variable in ElCar class
        double c = Double.parseDouble(text.get(i));
        // create a new object of class ElCar and pass the variable into it's constructor
        Car elcar = new Elcar(a,b,c);
        // add the object to the ArrayList car
        car.add(elcar);
    }
    // check if the first word is PERSONBIL
    else if(text.get(i).equals("PERSONBIL")){
        // repeate the previous process
        String a = text.get(i);
        i++;
        String b = text.get(i);
        i++;
        double c = Double.parseDouble(text.get(i));
        i++;
        int d  = Integer.parseInt(text.get(i));
        Car personbil = new PersonalCar(a,b,c,d);
        car.add(personbil);
        } else if(text.get(i).equals("LASTEBIL")){
            String a = text.get(i);
            i++;
            String b = text.get(i);
            i++;
            double c = Double.parseDouble(text.get(i));
            i++;
            double d = Double.parseDouble(text.get(i));
            Car lastebil = new Trucks(a,b,c,d);
            car.add(lastebil);

        }
    }


try{
    // to read the specific type of car from the command-line
    // first check if the user entered the word "El"
    if(args[1].equals("EL")){
        // check if the element in the Arraylist Car isinstance of Elcar
     for(Car c: car){
     if(c instanceof Elcar){
         // call the getInfo method from the specific class
         c.getInfo();
     }
 }// repeate the process with the word FOSSIL
} else if (args[1].equals("FOSSIL")){
         for(Car d: car){
         if(d instanceof FossilCar){
             d.getInfo();


     }
     }

}
}
catch (Exception e) {
// if the user has not provided a second command-line show all types of cars
for(Car c: car){
    c.getInfo();
}
}
}
    }
