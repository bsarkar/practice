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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FindMinExecutors implements Callable<Integer>{

	private int[] numbers;
	private int startIndex;
	private int endIndex;
	private ExecutorService executorService;

	public FindMinExecutors(ExecutorService executorService, int[] numbers, int startIndex, int endIndex) {
		this.executorService = executorService;
		this.numbers = numbers;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	public Integer call() throws Exception {
		int sliceLength = (endIndex - startIndex) + 1;
		if (sliceLength > 2) {
			FindMinExecutors lowerFindMin = new FindMinExecutors(executorService, numbers
					, startIndex, startIndex + (sliceLength / 2) - 1);
			Future<Integer> futureLowerFindMin = executorService.submit(lowerFindMin);
			FindMinExecutors upperFindMin = new FindMinExecutors(executorService, numbers
					, startIndex + (sliceLength / 2), endIndex);
			Future<Integer> futureUpperFindMin = executorService.submit(upperFindMin);
			return Math.min(futureLowerFindMin.get(), futureUpperFindMin.get()) ;
		}
		else {
			return Math.min(numbers[startIndex], numbers[endIndex]);
		}
	}
	
	public static void main(String[] args) throws InterruptedException,ExecutionException {
				int[] numbers = new int[100];
				Random random = new Random(System.currentTimeMillis());
				for (int i = 0; i < numbers.length; i++) {
					numbers[i] = random.nextInt(100);
				}
				System.out.println(System.currentTimeMillis());
				ExecutorService executorService = Executors.newFixedThreadPool(64); 
				Future<Integer> futureResult = executorService.submit(new FindMinExecutors( 
						executorService, numbers, 0, numbers.length-1));
				System.out.println(futureResult.get());
				System.out.println(System.currentTimeMillis());
				executorService.shutdown();
				
			}
        }