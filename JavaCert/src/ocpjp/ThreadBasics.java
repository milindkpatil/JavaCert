package ocpjp;

public class ThreadBasics {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread("thread");
		thread.start(); // Nothing will happen.
		thread.run();   // Nothing will happen.
		
		Runnable run = new Run1();
		run.run(); // Simply calls method.
		
		Thread thread2 = new Thread(run, "thread2");  // you can have same name 'thread' as well because ID will be different.
		System.out.println("1. Thread State:" + thread2.getState());
		
		thread2.setPriority(Thread.MAX_PRIORITY);
		// Exception java.lang.IllegualArgumentException, if try to set priority other than 1-10
		// thread2.setPriority(100);
		thread2.start(); // Call run() method in separate thread.
		
		System.out.println("2. Thread State:" + thread2.getState());
		// calling start() on alread started thread will cause, even if thread finished execution, because it is in 'Dead' state.
		// Exception in thread "main" java.lang.IllegalThreadStateException
		// thread2.start();
		
		// Waits for thread2 to die.
		thread2.join();

		
		/* Nothing will happen. Simply calls method but not in separate thread. (that means main).
		 * However there is catch, if thread2 is finished then this method will print anything, it just gets return.
		 * Mostly checking thread state. internally.
		 */
		thread2.run(); 

		System.out.println("3. Thread State:" + thread2.getState());

	}
}

class Run1 implements Runnable {
	
	public void run() {

		System.out.println("This is simple method. Called by thread:" + Thread.currentThread().getName());
		System.out.println("Priority of this thread:" + Thread.currentThread().getPriority());
	}
}

/*
Output as follow:

This is simple method. Called by thread:main
Priority of this thread:5
1. Thread State:NEW
2. Thread State:RUNNABLE
This is simple method. Called by thread:thread2
Priority of this thread:10
3. Thread State:TERMINATED

*/