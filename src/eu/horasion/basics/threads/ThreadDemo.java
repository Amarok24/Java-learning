package eu.horasion.basics.threads;

/**
 * ThreadDemo
 */
public class ThreadDemo {

	public static void main(String[] args) {
		Demo1 d1 = new Demo1();
		new Demo2();
		Thread myThread = new Thread(d1);
		myThread.start(); // d1's `run` method will be called in separate thread.
		System.out.println("ThreadDemo end of constructor (outside of a thread).");
	}
}

class Demo1 implements Runnable {

	@Override
	public void run() {
		// Methods that override instance methods must have the same visibility.
		// In this case it's public (Runnable.run)
		System.out.println("Demo1 run method, so it's running in a thread.");
	}
}

// Another possibility: to extend Thread instead of implementing Runnable.
// In such a case Demo1 would need to call the `start` method of the Thread,
// so the class would itself be independently asynchronous.
class Demo2 extends Thread {

	protected int counter = 0;

	public Demo2() {
		this.start();
		System.out.println("Demo2 constructor started.");
		System.out.format("counter = %d\n", this.counter);
		this.counter++;
		System.out.format("counter = %d\n", this.counter);
	}

	@Override
	public void run() {
		this.counter++;
		System.out.format("Demo2 run method, so it's running in a thread. counter = %d\n", this.counter);
	}
}

/*

Demo2 constructor started.
counter = 1
counter = 2
Demo2 run method, so it's running in a thread. counter = 1
ThreadDemo end of constructor (outside of a thread).
Demo1 run method, so it's running in a thread.

*/
