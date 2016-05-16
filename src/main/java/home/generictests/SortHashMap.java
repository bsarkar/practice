package home.generictests;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.*;

import com.google.common.util.concurrent.Futures;  
import com.google.common.util.concurrent.ListenableFuture;  
import com.google.common.util.concurrent.ListeningExecutorService;  
import com.google.common.util.concurrent.MoreExecutors; 

import org.apache.commons.io.IOUtils;

public class SortHashMap {
	
	public void solution() {
		
		Map<String , Integer> mp = new HashMap();
		mp.put("Data1", 5) ;
		mp.put("Data2", 4) ;
		mp.put("Data3", 8) ;
		mp.put("Data4", 9) ;
		mp.put("Data5", 1) ;
		
		Set<Entry<String, Integer>> st = mp.entrySet() ;
		
		ArrayList<Entry<String, Integer>> ll = new ArrayList(st) ;
		for ( Entry<String, Integer> e : ll) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}
		Collections.sort(ll , new Comparator<Entry<String , Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1 , Map.Entry<String, Integer> o2 ) {
					if ( o1.getValue() > o2.getValue())
						return -1;
					else if (o1.getValue() < o2.getValue() )
						return 1;
					else
						return 0;
			}
		}) ;
		
		for ( Entry<String, Integer> e : ll) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}
	}
	
		// Test 2 : Executor
		
		private final static int NUMBER_OF_THREADS = 5;
		ExecutorService executor = null ;
		
	    // One Way
		/*
		public void futureExample() throws MalformedURLException {
		    ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS) ;
		    
		    final URL url = new URL("http://www.example.com") ;

		    Callable<String> asyncTask = new Callable<String>() {
		        @Override
		        public String call() throws Exception {
		        	 try (InputStream input = url.openStream()) {
			                //return IOUtils.toString(input, StandardCharsets.UTF_8);
			                return IOUtils.toString(input);
			            }
		        }
		    };

		    Future<String> future = executor.submit(asyncTask);

		    doSomethingElse(" Calling doSomethingElse again");

		    try {
		    	
		    	String result = future.get();

		    	useResult(result);
		    } catch (ExecutionException | InterruptedException e) {
		    	e.printStackTrace();
		    } 

		    executor.shutdown();
		}
		*/  // End of One way
		
		// Second way
		   

		public String futureExample() throws MalformedURLException, IOException {
			ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS) ;
			final Future<String> contentsFuture = startDownloading(new URL("http://www.example.com"));
			while (!contentsFuture.isDone()) {
				askUserToWait();
				doSomethingElse("While waiting to finish the job and return the Future");
			}

			System.out.println("In compute Thread");
			return "In compute Thread";
		}
		// Next line will not block in this case as we already checking isDone in the thread and asking user input if not done
		public void useResult(String rslt) {

			System.out.println("In UseResult Thread");
		}

		public void doSomethingElse(String msg) {

			System.out.println(msg);

		}

		public Future<String> startDownloading(final URL url) throws IOException {
			return executor.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					try (InputStream input = url.openStream()) {
						//return IOUtils.toString(input, StandardCharsets.UTF_8);
						return IOUtils.toString(input);
					}
				}
			});
		}

		public void askUserToWait(){
			System.out.println("Infor User");
		}
		
		/*
		public void listenableFutureWithCallbackExample() {
		    ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(NUMBER_OF_THREADS));

		    Callable<String> asyncTask = new Callable<String>() {
		        @Override
		        public String call() throws Exception {
		            return computeResult();
		        }
		    };

		    ListenableFuture<String> listenableFuture = executor.submit(asyncTask);

		    Futures.addCallback(listenableFuture, new FutureCallback<String>() {
		        public void onSuccess(String result) {
		            doMoreWithTheResultImmediately(result);
		        }

		        public void onFailure(Throwable thrown) {
		            handleFailure(thrown);
		        }
		    });

		    doSomethingElse();

		    try {
		        String result = listenableFuture.get();
		        useResult(result);
		    } catch (ExecutionException e) {
		        log.error("Task failed", e);
		    } catch (InterruptedException e) {
		        log.warn("Task interrupted", e);
		    }

		    executor.shutdown();
		}
		*/
		
		public void solution3() {
			double values[] = {-2.3, -1.0, 0.25, 4};
	        int cnt = 0;
	        for (int x=0; x < values.length; x++) 
	        {
	        	System.out.println("Before results [" + x + "]" + Math.round(values[x] + .5) + " : " + Math.ceil(values[x]) + "\n");
	            if (Math.round(values[x] + .5) == Math.ceil(values[x])) 
	            {
	            	System.out.println("Inside results [" + x + "]" + Math.round(values[x] + .5) + " : " + Math.ceil(values[x]) + "\n");
	                ++cnt;
	            }
	        }
	        System.out.println("same results " + cnt + " time(s)");
		}
		
		public void solution4() {
			try 
			{ 
			    int x = 0; 
			    int y = 5 / x; 
			} 
			catch (Exception e) 
			{
			    System.out.println("Exception"); 
			} 
			catch (ArithmeticException ae) 
			{
			    System.out.println(" Arithmetic Exception"); 
			} 
			System.out.println("finished");
		}

		public void solution6() {
			int x= 0;
	        int y= 0;
	        for (int z = 0; z < 5; z++) 
	        {
	            if (( ++x > 2 ) || (++y > 2)) 
	            {
	                x++;
	            }
	        }
	    System.out.println(x + " " + y);
		}
		
		public void solution7() {
			String a = "newspaper";
			a = a.substring(5,7);
			char b = a.charAt(1);
			a = a + b;
			System.out.println(a);
		}
	
	public static void main(String[] args) {
		new SortHashMap().solution();
		try {
			new SortHashMap().futureExample();
		} catch(Exception e) { }

		//new SortHashMap().solution3();
		//
		Test1 p = new Test1();
        p.start();
        
        new SortHashMap().solution6();
        new SortHashMap().solution7();
	}

}

class Test1
{

    void start() 
    {
        boolean b1 = false;
        boolean b2 = fix(b1);
        System.out.println(b1 + " " + b2);
    }

    boolean fix(boolean b1) 
    {
        b1 = true;
        return b1;
    }
}
