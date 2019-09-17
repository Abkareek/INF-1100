
import krypto.*;

public class Oblig6{
    public static void main(String[] args) {
       int antallTelegrafister = 3;
       int decrypters =20;
         LytteMonitor  monitor = new LytteMonitor();


       Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
       Kanal[] kanaler = ops.hentKanalArray();
       int numberOfChannels = ops.hentAntallKanaler();
       //System.out.println(numberOfChannels);
       //for (int i=0; i<3 ; i++) {
           //Messages msg = new Messages(i,kanaler[i].hentId(), kanaler[i].lytt());

            //System.out.println(kanaler.length);

            Thread r1 = new Thread(new Telegraphist(kanaler[0], monitor));

           Thread r2 = new Thread(new Telegraphist(kanaler[1], monitor));

           Thread r3 = new Thread(new Telegraphist(kanaler[2], monitor));
           r1.start();

          r2.start();
         r3.start();
           //System.out.println(kanaler[i].hentId());

       //}
       for (int i=0; i< decrypters; i++) {
           //System.out.println(kanaler.length);
           Thread r = new Thread(new Cryptographer(monitor));
           r.start();

                  }
       OperationManager manger = new OperationManager(monitor);
       Thread om = new Thread(manger);
       om.start();

       //monitor.display();
        //int threadsNumber = kanaler.length();
        /**for (int i=0; i< threadsNumber ;i++ ) {
            Thread r = new Thread(new Telegraphist(kanaler[i], i, ops.hentKanalArray().length()));
            r.start();
        }*/

    }


}
