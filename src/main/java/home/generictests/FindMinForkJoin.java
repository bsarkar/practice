package home.generictests;

/*
 
 The code looks very similar, expect the fact that we submit() our tasks to the ExecutorService and then use the 
 returned instance of Future to wait() for the result. The main difference between both implementations can be 
 found at the point where the thread pool is constructed. In the example above, we create a fixed thread pool with 
 64(!) threads. Why did I choose such a big number? The reason here is, that calling get() for each returned Future 
 block the current thread until the result is available. If we would only provide as many threads to the pool as we 
 have CPUs available, the program would run out of resources and hang indefinitely.
 
 The ForkJoinPool implements the already mentioned work-stealing strategy, i.e. every time a running thread has to
  wait for some result; the thread removes the current task from the work queue and executes some other task ready 
  to run. This way the current thread is not blocked and can be used to execute other tasks. Once the result for the
  originally suspended task has been computed the task gets executed again and the join() method returns the result.
  This is an important difference to the normal ExecutorService where you would have to block the current thread while 
  waiting for a result.
  
 */

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FindMinForkJoin extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	private int[] numbers;
	private int startIndex;
	private int endIndex;
	public FindMinForkJoin(int[] numbers, int startIndex, int endIndex) {
		this.numbers = numbers;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	@Override
	protected Integer compute() {
		int sliceLength = (endIndex - startIndex) + 1;
		if (sliceLength > 2) {
			FindMinForkJoin lowerFindMin = new FindMinForkJoin(numbers, startIndex, 
										startIndex + (sliceLength / 2) - 1);
		
			lowerFindMin.fork();
			FindMinForkJoin upperFindMin = new FindMinForkJoin(numbers, startIndex + 
												(sliceLength / 2), endIndex);
			upperFindMin.fork();
			return Math.min(lowerFindMin.join(), upperFindMin.join());
		}
		else {
			return Math.min(numbers[startIndex], numbers[endIndex]);
		}
	}
	public static void main(String[] args) {
		int[] numbers = new int[100];
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(100);
		}
		System.out.println(System.currentTimeMillis());
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		Integer min = pool.invoke(new FindMinForkJoin(numbers, 0, numbers.length - 1));
		System.out.println(System.currentTimeMillis());
		System.out.println(min);
	}
}
