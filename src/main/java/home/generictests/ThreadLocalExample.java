package home.generictests;

public class ThreadLocalExample extends Object implements Runnable {
	  private ThreadID var;

	  public ThreadLocalExample(ThreadLocal var) {
	    this.var = (ThreadID) var ;
	  }

	  public void run() {
	    try {
	      System.out.println("var getThreadID =" + Thread.currentThread().getName() + " " +
	    		  Thread.currentThread().getThreadGroup().getName().toString() + " " + var.getThreadID());
	      var.incrementCtr();
	      Thread.sleep(2000);
	      System.out.println("var getThreadID =" + Thread.currentThread().getName() +  " " +
	    		  Thread.currentThread().getThreadGroup().getName().toString() + " " + var.getThreadID());
	      var.incrementCtr();
	      Thread.sleep(2000);
	      System.out.println("var getThreadID =" + Thread.currentThread().getName() +  " " +
	    		  Thread.currentThread().getThreadGroup().getName().toString() + " " +  var.getThreadID());
	    } catch (InterruptedException x) {
	    }
	  }

	  public static void main(String[] args) {
	    ThreadID tid = new ThreadID();
	    ThreadLocalExample shared = new ThreadLocalExample(tid);

	    try {
	      ThreadGroup tg = new ThreadGroup("Group1");
	      Thread threadA = new Thread(tg , shared, "threadA");
	     
	      threadA.start();

	      Thread.sleep(500);

	      Thread threadB = new Thread(tg,shared, "threadB");
	      threadB.start();

	      Thread.sleep(500);
	      ThreadGroup tg2 = new ThreadGroup("Group2");
	      Thread threadC = new Thread(tg2, shared, "threadC");
	      threadC.start();
	    } catch (InterruptedException x) {
	    }
	  }
	}

class ThreadID extends ThreadLocal {
	  private static int nextID;

	  public ThreadID() {
	    nextID = 10001;
	  }

	  private synchronized Integer getNewID() {
	    Integer id = new Integer(nextID);
	    nextID += 10000;
	    return id;
	  }

	  protected Object initialValue() {
	    System.out.println("in initialValue() " + Thread.currentThread().getName());
	   return getNewID();
	  }

	  public int getThreadID() {
	    Integer id = (Integer) get();
	    return id.intValue();
	  }

	  protected void incrementCtr() {
		  Integer id = (Integer) get();
		  id++ ;
		  this.set(id);
	  }
	  private static void print(String msg) {
	    String name = Thread.currentThread().getName();
	    System.out.println(name + ": " + msg);
	  }
	}
