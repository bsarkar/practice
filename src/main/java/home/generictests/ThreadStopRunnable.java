package home.generictests;

public class ThreadStopRunnable implements Runnable{
    volatile boolean stop ;
    int cntr = 0 ;
	public static void main(String[] args) throws InterruptedException {
		
		ThreadStopRunnable r1 = new ThreadStopRunnable() ;
		ThreadStopRunnable r2 = new ThreadStopRunnable() ;
		
		Thread tt1 = new Thread( r1 , "Thread1") ;
		Thread tt2 = new Thread( r2 , "Thread2") ;

		tt1.start();
		tt2.start();
		
		Thread.currentThread().sleep(3000);
		
		r2.reqStop();
	}

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
}
