package ocpjp;

class Chicks {
	synchronized void yack(long id) {
		for (int x = 1; x < 3; x++) {
			System.out.print(id + " ");
			Thread.yield();
		}
	}
}

public class ThreadInstanceVsStaticObjects implements Runnable {
	Chicks c;

	public static void main(String[] args) {
		new ThreadInstanceVsStaticObjects().go();
	}

	void go() {
		c = new Chicks();
		new Thread(new ThreadInstanceVsStaticObjects()).start();
		new Thread(new ThreadInstanceVsStaticObjects()).start();
	}

	public void run() {
		c.yack(Thread.currentThread().getId());
	}
}

/*
Exception in thread "Thread-0" Exception in thread "Thread-1" java.lang.NullPointerException
	at ocpjp.ThreadInstanceVsStaticObjects.run(ThreadInstanceVsStaticObjects.java:26)
	at java.lang.Thread.run(Thread.java:745)
	
When run() is invoked, it is with a new instance of ThreadInstanceVsStaticObjects and c has
not been assigned to an object. If c were static, then because yack is synchronized program would have worked.	
	
*/