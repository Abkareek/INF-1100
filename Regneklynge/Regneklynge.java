import java.util.ArrayList;

class Regneklynge{

	private ArrayList <Rack> racks;
	private int counter = 0;
	private int numberofNodesInRack;

    Regneklynge(int numberofNodesInRack){
    	 this.numberofNodesInRack = numberofNodesInRack;
    	 racks = new ArrayList<>();
		 this.numberofNodesInRack = numberofNodesInRack;
    }





    public void settInnNode(Node node){
        if (racks.isEmpty()){
            Rack rack = new Rack(numberofNodesInRack);
            racks.add(rack);
            rack.insertNodeInRack(node);
            counter++;

        }else{ 
            for (Rack rack:racks){
                if(rack.checkIfRackIsFull()){
                    Rack newRack = new Rack(numberofNodesInRack);
                    racks.add(newRack);
                    counter++;
                    newRack.insertNodeInRack(node);
                    return;                                      
                }else{
                    rack.insertNodeInRack(node);
                    
                    
                }
            }
        }
        
        
    }
    public double flops(){
        double flops = 0.0;
        for (Rack r : racks){
            flops += r.flops();
        }
        return flops;
    }




public int listeSize(){
  return counter;
}
public int numberOfNodesWithEnoughMemory(int memoryValue){
    int tracker = 0;
    for (Rack c: racks){
        tracker += c.checkIfThereIsEnoughMemory(memoryValue);




    }
    return tracker;
}

}
