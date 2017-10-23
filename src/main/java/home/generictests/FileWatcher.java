package home.generictests;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileWatcher {

		 
	    public static void main(String[] args) throws InterruptedException {
	        WatchService watchService= null;
			try {
				watchService = FileSystems.getDefault().newWatchService();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	        Path path = Paths.get(System.getProperty("user.home"));
	 
	        try {
				path.register(
				  watchService, 
				    StandardWatchEventKinds.ENTRY_CREATE, 
				      StandardWatchEventKinds.ENTRY_DELETE, 
				        StandardWatchEventKinds.ENTRY_MODIFY);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	        WatchKey key;
	        while ((key = watchService.take()) != null) {
	            for (WatchEvent<?> event : key.pollEvents()) {
	                System.out.println(
	                  "Event kind:" + event.kind() 
	                    + ". File affected: " + event.context() + ".");
	            }
	            key.reset();
	        }
	    }
	}
