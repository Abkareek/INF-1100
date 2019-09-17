class Main {
    /** Man class to test the computer cluster processor
     * 
     * @param args 
     */
    public static void main(String[] args){

        Regneklynge abel = new Regneklynge(12);
        
        for (int i=0; i<650;i++){
         
            Node node = new Node(2,64,8,2.6*10E9);
            abel.settInnNode(node);
        }
        for (int i =0; i<16;i++){
            Node nynode = new Node(2,1024, 8, 2.3*10E9) ;
            abel.settInnNode(nynode);
        }
       
         
           //double totalresult = r+result;
        System.out.printf("flops is%.3e \n", abel.flops());
        System.out.println("antall Rack er " + abel.listeSize());
        System.out.println("32 is"+abel.numberOfNodesWithEnoughMemory(32));
        System.out.println("64 er: "+abel.numberOfNodesWithEnoughMemory(64));
        System.out.println("128 er: "+abel.numberOfNodesWithEnoughMemory(128));
        

         

    }
}







