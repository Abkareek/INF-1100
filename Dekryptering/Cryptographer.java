import krypto.*;

class Cryptographer   implements Runnable {

    LytteMonitor taking;
    //private final LytteMonitor lestining;
    //private final LytteMonitor decrypting ;
    public Cryptographer(LytteMonitor taking){
        this.taking = taking;

        //decrypting = new LytteMonitor( channel, threadId,  numberOfChannels);
    }
    @Override
    public void run (){


        while (!Thread.interrupted()) {
            taking.take();

        }
        //taking.take();

/**

        String decoded = decryptedMsg(taking.take());
        String [] splitter = decoded.split("\\|");
        int sequence = Integer.parseInt(splitter[0]);
        int channel
        //taking.display();
        //System.out.println(x);
*/

    }
    public String decryptedMsg(String msg){
        return Kryptografi.dekrypter(msg);
    }
    /**
    public void disp(){
        taking.display();
    }
    */
}
