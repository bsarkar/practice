package home.generictests;

public class CompletableFuture {

	public String getResult() {

	    // Create Stream of tasks:
	    Stream<Supplier<List<String>>> tasks = Stream.of(
	            () -> getServerListFromDB(),
	            () -> getAppListFromDB(),
	            () -> getUserFromDB());

	    List<List<String>> lists = tasks
	         // Supply all the tasks for execution and collect CompletableFutures
	         .map(CompletableFuture::supplyAsync).collect(Collectors.toList())
	         // Join all the CompletableFutures to gather the results
	         .stream()
	         .map(CompletableFuture::join).collect(Collectors.toList());

	    // Use the results. They are guaranteed to be ordered in the same way as the tasks
	    return getResult(lists.get(0), lists.get(1), lists.get(2));
	}
	
	
}


http://www.deadcoderising.com/java8-writing-asynchronous-code-with-completablefuture/
http://www.nurkiewicz.com/2013/05/java-8-definitive-guide-to.html