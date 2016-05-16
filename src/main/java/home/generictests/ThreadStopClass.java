package home.generictests;

public class ThreadStopClass extends Thread {

	int cntr = 0 ;
	volatile boolean stop = false ;
	
	ThreadStopClass(String msg) {
		super(msg) ;
	}
	@Override
	public void run() {
		while(!stop && cntr < 1000000) {
			cntr++ ;
			System.out.println(Thread.currentThread().getName() + " : " + cntr);
		}
		if(stop)
			System.out.println("Finishing...." + Thread.currentThread().getName() + "\n");
	}
	
	public void reqStop() {
		stop = true ;
	}
	public static void main(String[] args) throws InterruptedException {
		
		ThreadStopClass tt1 = new ThreadStopClass("Thread1") ;
		tt1.start() ;
		
		ThreadStopClass tt2 = new ThreadStopClass("Thread2") ;
		tt2.start() ;

		Thread.currentThread().sleep(3000);
		
		tt1.reqStop();
	}

}
