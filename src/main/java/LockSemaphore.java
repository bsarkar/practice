
// Hand coded Semaphore
public class LockSemaphore {

	/**
	 * Semaphore is a straightforward implementation of the well-known
	 * synchronization primitive. Its counter can be initialized to any
	 * nonnegative value -- by default, it is zero.
	 */

	    private int counter;
	    public LockSemaphore() {
	        this(0);
	    }
	    public LockSemaphore(int i) {
	        if (i < 0) throw new IllegalArgumentException(i + " < 0");
	        counter = i;
	    }
	    /**
	     * Increments internal counter, possibly awakening a thread
	     * wait()ing in acquire().
	     */
	    public synchronized void release() {
	        if (counter == 0) {
	            this.notifyAll();;
	        }
	        counter++;
	    }
	    /**
	     * Decrements internal counter, blocking if the counter is already
	     * zero.
	     *
	     * @exception InterruptedException passed from this.wait().
	     */
	    public synchronized void acquire() throws InterruptedException {
	        while (counter == 0) {
	            this.wait();
	        }
	        counter--;
	        this.notifyAll();
	    }
}

// Another Use Case 
// Bounded Semaphore where it can have a max number of acquires

class BoundedSemaphore {
	  private int signals = 0;
	  private int bound   = 0;

	  public BoundedSemaphore(int upperBound){
	    this.bound = upperBound;
	  }

	  public synchronized void take() throws InterruptedException{
	    while(this.signals == bound) wait();
	    this.signals++;
	    this.notifyAll();;
	  }

	  public synchronized void release() throws InterruptedException{
	    while(this.signals == 0) wait();
	    this.signals--;
	    this.notifyAll();;
	  }
	}
