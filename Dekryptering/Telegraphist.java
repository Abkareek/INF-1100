import krypto.*;

class Telegraphist implements Runnable{
    Kanal channel ;
    //public static int channelId;
    //private final int threadId;
    //private int antallTelegrafister;
    protected final LytteMonitor lestining;
    private int threadNumber = 0;
    private String check = null;
    private Boolean msgcheck = true;
    //Messages msg; //=new Messages(threadNumber,channel.hentId(), channel.lytt());

    public Telegraphist(Kanal channel, LytteMonitor lestining){
         //msg =new Messages(threadNumber,channel.hentId(), channel.lytt());

        this.channel = channel;
        this.lestining = lestining;
         //msg =new Messages(threadNumber,channel.hentId(), channel.lytt());
        //this.msg = new Messages(threadNumber,channel.hentId(), channel.lytt()) ;
    }
    @Override
    public void run(){
        Messages msg;
        //String check = getMsg();

/**
        try {
            //System.out.println(channel.hentId());
            Thread.sleep(100);
        }catch (Exception e) {}*/
        while (msgcheck || check != null) {
            msgcheck = false;
           check = channel.lytt();
           if (check == null) {
        	   Thread.interrupted();
        	   lestining.setThreatKiller();


               break;
           }else{
        //    lestining.give(msg);
        lestining.give(new Messages(threadNumber,channel.hentId(), check));
            threadNumber++;
        }



        }





    }



    public String getMsg(){
        return channel.lytt();
    }




}
