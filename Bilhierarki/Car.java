

/**
 *
 * @author hani
 */
public  class Car {
    private String regNumber;// the car registering number
    private String name;

    Car(String name, String skilt){
        this.regNumber = skilt;
        this.name = name;

    }
    public void getInfo(){
        System.out.printf("Car Type: %s \nregNumber: %s \n", name, regNumber);
    }


}
