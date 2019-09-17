
/**
 * A class that represents Fossil Cars
 * @author hani
 */
public class Trucks extends FossilCar {
    private double netWeight;
    /*
    *
    */
    Trucks(String regNumber,String name, double utslipp, double netWeight){
        super(name, regNumber ,utslipp);
        this.netWeight = netWeight;

    }
    public double getNetWeight(){
        return netWeight;
    }
    public void getInfo(){
        super.getInfo();
       System.out.printf("netWeight: %8.2f \n", netWeight);
       System.out.println("----------------------");
    }

}
