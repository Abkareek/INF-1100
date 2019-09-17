
public class OperationManager implements Runnable {
	 LytteMonitor m ;
	public OperationManager(LytteMonitor m) {
		this.m = m;
	}
	@Override
	public void run() {
		while(true) {
			try {
				m.writeToFile();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
