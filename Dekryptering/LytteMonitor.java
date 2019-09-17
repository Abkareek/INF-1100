import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.concurrent.locks.Condition;
import krypto.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LytteMonitor{
    private OrdnetLenkeliste<Messages> beholder = new <Messages>OrdnetLenkeliste();
    private OrdnetLenkeliste<Messages> done = new <Messages>OrdnetLenkeliste();
    //private final int capasity = 9;

    //private ArrayList<String> beholder = new  ArrayList<String>(capasity);
    //private ArrayList<String> done = new  ArrayList<String>(10*capasity);

    private int counter = 0;
    //private  final int numberOfChannels  ;
    private final Lock lock = new ReentrantLock();
    private final Condition isEmpty = lock.newCondition();
    private final Condition isFull = lock.newCondition();
    private final Condition erTom = lock.newCondition();
    private final Condition erFult = lock.newCondition();
    private String uncoded;
    private Boolean threatKiller = true;
    public LytteMonitor(){
        //this.numberOfChannels = telegraphTester;
    }
    public void setThreatKiller() {
    	this.threatKiller = false;
    }
    public Boolean threatKiller() {
    	return threatKiller;
    }


    public void give(Messages msg){
        //System.out.println("starting");

        lock.lock();

        try{
            /**
            while (beholder.storrelse()== capasity) {
            isFull.await();
            System.out.println("isFull and waiting for crypto to take an item");
        }*/
        //System.out.println("putting");
        //msg = counter+"|"+ msg;
        beholder.settInn(msg);
        //System.out.println(msg.message());
        //counter++;
        if(!beholder.erTom())
        isEmpty.signalAll();
    }/**catch (InterruptedException e) {

    }*/




    finally{
        lock.unlock();
    }

}
/**
public void ordring(){
for (String s  : beholder ) {
if () {

}
}
}*/

public void take(){
    lock.lock();
    try {
        while (beholder.erTom()) {
            //    System.out.println("waiting for msg");
            isEmpty.await();

        }
        //String codeed = beholder.fern();
        //System.out.println("taking a msg");
        Messages almost = beholder.fjern();
        String uncoded = Kryptografi.dekrypter(almost.message());
       // System.out.println("\t"+ uncoded);
        almost.setMessage(uncoded);
        //uncoded = counter+"| "+ uncoded;
        //counter++;

        //System.out.println(uncoded);
        done.settInn(almost);
        erTom.signal();
        //counter++;
        //beholder.remove(0);
        //System.out.println(counter+""+uncoded);
        //isFull.signalAll();
    }


    catch (InterruptedException e) {

    }


    finally{
        lock.unlock();
    }
    //return codeed;
}

public void writeToFile() throws InterruptedException{
    lock.lock();
    try{
        while (done.erTom()) {
            erTom.await();
        }
        Messages copy = done.fjern();
        System.out.println(copy.channelId());
        if(copy.channelId() == 1) {
        	String fileName = "1.txt";
        	printTofile(fileName, copy.message());
        }else if(copy.channelId()== 2 ) {
        	String fileName = "2.txt";
        	printTofile(fileName, copy.message());
        }else {
        	String fileName = "3.txt";
        	printTofile(fileName, copy.message());
        }
        erFult.signalAll();
    }
    finally{
        lock.unlock();
    }

}


public void printTofile(String fileName , String message){
	BufferedWriter bw = null;

    try {
       // APPEND MODE SET HERE
       bw = new BufferedWriter(new FileWriter(fileName, true));
	 bw.write(message);
	 bw.newLine();
	 bw.flush();
    } catch (IOException ioe) {
	 ioe.printStackTrace();
    } finally {                       // always close the file
	 if (bw != null) try {
	    bw.close();
	 } catch (IOException ioe2) {
	    // just ignore it
	 }
    } // end try/catch/finally

 }
}
