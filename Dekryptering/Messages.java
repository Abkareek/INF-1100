public class Messages implements Comparable<Messages> {
    private final int id;
    private String msg;
    private final int channelId;
    public Messages(int id, int channelId,String msg){
        this.id = id;
        this.msg = msg;
        this.channelId = channelId;
    }
    public int msgId(){
        return id;
    }
    public int channelId(){
        return channelId;
    }
    public void setMessage(String ny){
        this.msg = ny;
    }
    public String message(){
        return msg;
    }
    @Override
    public int compareTo(Messages b ){
        if((this.id >b.id)){
            return 1;
        }
        else if (this.id<b.id) {
            return -1;
        }else {
            return 0;
        }

        }
    }
