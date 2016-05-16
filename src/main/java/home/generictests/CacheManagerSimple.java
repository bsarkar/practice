package home.generictests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class CacheManagerSimple < K , T> {
	
	private long timeToLive;
	private HashMap<K,CacheObject> cacheMap ;
	
	protected class CacheObject {
		public long lastAccessed = System.currentTimeMillis() ;
		public T value ;
		protected CacheObject(T value){
			this.value = value ;
		}
	}
	
	public CacheManagerSimple ( long timeToLive , final long timeInterval , int maxItems){
		this.timeToLive = timeToLive * 1000 ;
		cacheMap = new HashMap<K , CacheObject>(maxItems) ;
		
		if ( timeToLive > 0 && timeInterval > 0){
			// Start a thread which will periocally clean the cache
			
			Thread t = new Thread( new Runnable() {
				public void run() {
					while(true) {
						try {
							Thread.sleep(timeInterval * 1000);
						} catch ( InterruptedException ex) {
							System.out.println("Thread interrupted");
						}
						// clean the expired objects from the cache
						cleanUp() ;
					}
				}
			}) ;
			t.setDaemon(true);
			t.start() ;
		}
	}
	
	private void cleanUp() {
		long now = System.currentTimeMillis() ;
		ArrayList<K> deleteItems = new ArrayList<>(this.size()/2 + 1);
		synchronized (cacheMap) {
			for ( K key : cacheMap.keySet()) {
				System.out.println("Key :" + key);
//				CacheObject co = (CacheManagerSimple<K, T>.CacheObject) getCache(key) ;
				CacheObject co = (CacheObject)getCache(key) ;
				
//				if ( co != null && now > ( timeToLive + co.lastAccessed)) {
				if ( co != null && now > ( timeToLive )) {
					deleteItems.add(key) ;
				}
			}
		}
		System.out.println(deleteItems);
		
		for ( K key : deleteItems) {
			synchronized ( cacheMap) {
				this.removeCache(key);
			}
			Thread.yield();
		}
		
	}
	
	public CacheObject getCache(K key) {
		synchronized ( cacheMap) {
			CacheObject co = (CacheObject)cacheMap.get(key) ;
			if ( co == null)
				return null ;
			else {
				co.lastAccessed = System.currentTimeMillis() ;
				return co;
			}	
		}
	}
	
	public void removeCache( K key){
		synchronized ( cacheMap) {
			cacheMap.remove(key) ;
		}
	}
	
	public int size() {
		synchronized (cacheMap) {
			return cacheMap.size() ;
		}
	}
	
	public void putCache(K key , T value){
		synchronized ( cacheMap) {
			cacheMap.put(key, new CacheObject(value) );
		}
	}

	public static void main(String[] args) {
		
		// One test at a time ;
		
		// Test 1 : Creation and Deletion of Objects in cache
//		CacheManagerSimple<String , String> cm = 
//				new CacheManagerSimple<String, String>(200 , 500 , 6) ;
//		
//		
//		cm.putCache("eBay", "eBayObject") ;
//		cm.putCache("google", "GoogleObject") ;
//		cm.putCache("yahoo", "yahooObject") ;
//		cm.putCache("ibm", "ibmObject") ;
//		cm.putCache("oracle", "oracleObject") ;
//		
//		System.out.println("Total objects created :" + cm.size());
//		cm.removeCache("ibm");
//		System.out.println("Total objects after delete ibm :" + cm.size());
//		cm.putCache("twitter", "TwitterObject") ;
//		cm.putCache("apple", "appleObject") ;
//		System.out.println("Total objects after more creaton :" + cm.size());
		
		// test 2 : Expiration of Objects
		
		CacheManagerSimple<String , String> cm = 
						new CacheManagerSimple<String, String>(1 , 1 , 6) ;
		cm.putCache("eBay", "eBayObject") ;
		cm.putCache("google", "GoogleObject") ;
		cm.putCache("yahoo", "yahooObject") ;
		cm.putCache("ibm", "ibmObject") ;
		System.out.println("Total objects created :" + cm.size());
		try {
			Thread.sleep(5000);
		} catch ( Exception e) {
			
		}
		System.out.println("Total objects after expiration wait time :" + cm.size());
		
	}

}
