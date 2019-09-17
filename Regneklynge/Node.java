
public class Node {
	/** A class represents a machine with Processors and Memory
         * @param minne which is the amount of Memory for each Node
         * @param Processor1 which is an object of the class Processor
         * @param Processor2 which is an object of the class Processor
         * @param numberOfProcessor
         * @author Hani Mohammed
	 */
	private  int  minne  ;
	public Processor processor1;
	public Processor processor2;
        private int numberOfProcessors;
        
        /**A constructor of the class Node takes 4 parameters and checks the 
         * number of Processors if it was 2 Processer so the constructor creates
         * 2 objects of class Processor each object takes 2 arguments(antallKJerner,klokkeHastigheten)
         * @param numberOfProcessors
         * @param minne
         * @param antallKjerner
         * @param klokkeHastigheten 
         */


	public Node(int numberOfProcessors,int minne, int antallKjerner, double klokkeHastigheten){

		this.minne = minne;
                this.numberOfProcessors= numberOfProcessors;
		processor1 = new Processor(antallKjerner,klokkeHastigheten);
                if (numberOfProcessors == 2){
                    processor2 = new Processor(antallKjerner,klokkeHastigheten);
                                        
                }
        }
		
        
        
	
        /** A method to pass Memory size of the Node
         * 
         * @return int minne
         */
        

	public int MemorySize() {
		// TODO Auto-generated constructor stub
		return minne;
	}
        /** a method that calculates the flops for the Node , and takes into consideration
         *  how many processor the Node has.
         * @return double flops
         */
        public double flops(){
            double flops1 =0;// give the sum of the flops for the processor1 an intital value of zero
            double flops2 = 0; //give the sum of the flops for processor1 an intital value of zero
            flops1 += processor1.flops() ;// calclate the sum and assigne it to flops1
            if (processor2 != null){
                // check if there is anothor processor
                flops2 += processor2.flops();// calculate the sum and assigne it to flops
                
            }return flops1+flops2;// add the summation of the flops for the two processors
        }


}
