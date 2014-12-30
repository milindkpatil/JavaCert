package ocpjp;


public class ICABasics{
	public static void main(String[] args) {
		
		// Simple Anonymous class
		Thread anonymousThread = new Thread() {
			public void run() {
				System.out.println("Anonymous class thread speaking!");
			}
		}; // This semicolon is mandatory.
		
		runThread(anonymousThread);
		
		// Anonymous argument class.
		runThread(new Thread() {
			public void run() {
				System.out.println("Anonymous argument class thread talking!");
			}
		});
		
		// Anonymous interface implemented class. Only one interface can be extended at a time.
		runThread(new Runnable() {
			public void run() {
				System.out.println("Anonymous argument interface implemented class thread shouting!");
			}
		});
		
	}
	
	private static void runThread(Runnable r){
		Thread t = new Thread(r);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}