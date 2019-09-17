

/**
 *
 * @author hani
 */
public class FossilCar extends Car {
    private double utslipp;
    FossilCar(String skilt, String name, double utslipp){
        super(name, skilt);
        this.utslipp = utslipp;
    }
public double getUtslipp(){
    return utslipp;
}
public void getInfo(){
    super.getInfo();
        System.out.printf("CO2 utslipp: %8.2f \n", utslipp);
    }



}
