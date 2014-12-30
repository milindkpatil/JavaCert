package ocpjp;

public class ThreadSynch {
	public static void main(String[] args) throws InterruptedException {
		ThreadB b = new ThreadB();
		b.start();

		// All should be called within synchronized block if not it will throw exception as  ***frequently emmeded in questions.
		// Exception in thread "main" java.lang.IllegalMonitorStateException
		//b.wait();
		//b.notify();
		//b.notifyAll();
		//b.join();
		
		synchronized (b) {
			try {
				System.out.println("Waiting for b to complete...");
				// wait() always on object
				b.wait(10);
			} catch (InterruptedException e) {
			}
			System.out.println("Total is: " + b.total);
		}
	}
}

class ThreadB extends Thread {
	int total;

	public void run() {
		synchronized (this) {
			for (double i = 0; i < 1000000000.0; i++) {
				total += i;
			}
			// notify() always on object (this in following case).
			notify();
			// Following line will complete before lock is released on this object.
			// When wait() or wait(..) had called on current (this) object from other thread.
			System.out.println("I always gets printed, before releasing lock :)");
		}
	}
}