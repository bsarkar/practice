package home.generictests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest2 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}

class WorkerThread implements Runnable {
	  
    private String command;
    
    public WorkerThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}

//ExecutorService executorService1 = Executors.newSingleThreadExecutor();
//ExecutorService executorService2 = Executors.newFixedThreadPool(10);
//ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
//ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
//ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
		/* ScheduledFuture scheduledFuture =
						scheduledExecutorService.schedule(new Callable() {
							public Object call() throws Exception {
								System.out.println("Executed!");
								return "Called!";
							}
						},
						5,
						TimeUnit.SECONDS);
		*/
		// schedule (Callable task, long delay, TimeUnit timeunit)
		// schedule (Runnable task, long delay, TimeUnit timeunit)
		// scheduleAtFixedRate (Runnable, long initialDelay, long period, TimeUnit timeunit)
		// scheduleWithFixedDelay (Runnable, long initialDelay, long period, TimeUnit timeunit)


