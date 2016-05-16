package home.generictests;

public class Deadlock {

		final String aStr1 = "Lock1";
		final String aStr2 = "Lock2" ;
		
		
		
		Thread t1 = new Thread("First Thread") {
			public void run() {
				while( true) {
					synchronized ( aStr1) {
						try {
					      sleep(1000);
						} catch ( Exception e) {
							System.out.println("Exception in thread1");
						}
						synchronized ( aStr2) {
							System.out.println("In first thread");
							
						}
					}
				}
			}
		};
		
		Thread t2 = new Thread("Second Thread"){
			public void run() {
				while(true)	{
					synchronized(aStr2) {
						try {
//							sleep(1000);
							} catch ( Exception e) {
								System.out.println("Exception in thread2");
							}
						synchronized(aStr1) {
							System.out.println("In Second Thread");
						}
					}
				}
			}
		};
		
	
	public static void main(String[] args) throws InterruptedException {
		Deadlock dl  = new Deadlock();
		Thread.currentThread().sleep(3000);
		dl.t1.start();
		dl.t2.start() ;
		System.out.println("MAIN");

	}

}
