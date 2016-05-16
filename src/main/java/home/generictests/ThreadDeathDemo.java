package home.generictests;

/*
 * http://www.javaworld.com/article/2074481/java-concurrency/
 *           java-101--understanding-java-threads--part-4---thread-groups--volatility--and-threa.html?page=4
 
 ThreadDeathDemo's main thread executes main()'s byte-code instructions, which create a MyThreadGroup 
 object and a MyThread object that groups into MyThreadGroup. The main thread then starts a thread 
 associated with MyThread.

The MyThread thread enters its run() method, where it prints some text and calls the doSomething() 
method. That method subsequently calls doSomethingHelper(), which throws a MyThreadDeath object. 
(I subclass ThreadDeath so I can assign a reason for the death of a thread.) At some point, the thrown 
MyThreadDeath object results in a call to MyThreadGroup's uncaughtException(Thread t, Throwable e) 
method, which determines if a MyThreadDeath object was thrown. If so, calls are made to methods 
reportError(Thread t, Throwable e) and cleanup(), to print error information and perform cleanup 
operations, respectively. When run, ThreadDeathDemo produces the following output:
 
 */
//ThreadDeathDemo.java
class ThreadDeathDemo
{
	public static void main (String [] args)
	{
		MyThreadGroup mtg = new MyThreadGroup ("My Group");
		new MyThread (mtg, "My Thread").start ();
	}
}
class MyThread extends Thread
{
	MyThread (ThreadGroup tg, String name)
	{
		super (tg, name);
	}
	public void run ()
	{
		System.out.println ("About to do something.");
		doSomething ();
		System.out.println ("Something done.");
	}
	void doSomething ()
	{
		doSomethingHelper ();
	}
	void doSomethingHelper ()
	{
		throw new MyThreadDeath (MyThreadDeath.REASON2);
	}
}
class MyThreadDeath extends ThreadDeath
{
	final static int REASON1 = 1;
	final static int REASON2 = 2;
	final static int REASON3 = 3;
	int reason;
	MyThreadDeath (int reason)
	{
		this.reason = reason;
	}
}
class MyThreadGroup extends ThreadGroup
{
	MyThreadGroup (String name)
	{
		super (name);
	}
	public void uncaughtException (Thread t, Throwable e)
	{
		if (e instanceof MyThreadDeath)
		{
			reportError (t, e);
			cleanup ();
		}
		super.uncaughtException (t, e);
	}
	void reportError (Thread t, Throwable e)
	{
		System.out.print (t.getName () + " unable to do something. Reason: ");
		switch (((MyThreadDeath) e).reason)
		{
		case MyThreadDeath.REASON1:
			System.out.println ("First reason.");
			break;
		case MyThreadDeath.REASON2:
			System.out.println ("Second reason.");
			break;
		case MyThreadDeath.REASON3:
			System.out.println ("Third reason.");
		}
	}
	void cleanup ()
	{
		System.out.println ("Cleaning up");
	}
}
