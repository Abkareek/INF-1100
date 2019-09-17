
public class Rack {
    /** The class Rack ad Nodes into an Array to pass it further to Regneklynge
     *  it has 3 methods and a constructor it has also 4
     *
     * @param Node node
     * @param numberofNodesInRack
     * @param Node [] nodeArray
     * @param  int count
     * @author Hani Mohammed
     */


    private Node node;
    private int numberofNodesInRack ;
    private Node [] nodeArray = new Node[numberofNodesInRack];
    private int count = 0;
    /** Aclass constructor that takes  numberofNodesInRack as an argument
     * it creates a new Node nodeArray[numberofNodesInRack]
     *
     * @param numberofNodesInRack
     */

     Rack(int numberofNodesInRack) {

	this.numberofNodesInRack = numberofNodesInRack;
	nodeArray = new Node [numberofNodesInRack];
    }
     /** A  public void method InsertNodeInRack that return nothing
      * inside the method the function check if the Rack is full then return false
      * if there is a vacent slot in the Rack so it will fill it with new node
      * inside the nodeArray
      * @param node
      */
	public void insertNodeInRack(Node node){
            // check if the Rack array is full

            


                // assigne the node in the empty slot inside the nodeArray
                nodeArray[count++] = node;
                //count++;

             





        }
        
        /** A method that calclates the flops of all the nodes inside the Rack
         *
         * @return flops for each node inside the rack array
         */

            public double flops(){
                double flops = 0;
                for (int i =0; i< count; i++ ){
                    flops += nodeArray[i].flops();
                    }
                return flops;
            }


	public boolean checkIfRackIsFull(){
        return ((count == (nodeArray.length-1)));
        }
        /** A public method that checks if the Memory is enough
         *
         * @param MemoryValue
         * @return tracker which is the counter of how may nodes available with
         * at least the given MemoryValue
         */
        public int checkIfThereIsEnoughMemory(int MemoryValue){

            int tracker = 0;
            for(int i=0; i<count; i++){
                if(nodeArray[i].MemorySize()>= MemoryValue){
                    tracker++;}
            }

            return tracker;
        }/**
        public int antallNoderPerRack(){
        
            return count;

        }*/
}
