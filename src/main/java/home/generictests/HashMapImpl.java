package home.generictests;

public class HashMapImpl {
	private final static int initialSize = 1 << 16 ;
	private Entry [] store = new Entry[initialSize] ;
	
	class Entry {
		Topic key;
		String	value ;
		Entry next=null ;
		
		Entry( Topic k , String v) {
			key = k ;
			value = v ;
		}
		
		Topic getKey() {
			return key;
		}
		
		String getValue() {
			return value ;
		}
		
		void setValue( String v) {
			this.value = v ;
		}
		
	}
	
	void put(Topic k , String v) {
		
		int hCode = k.hashCode() ;
		hCode = getRefinedCode(hCode) ;
		int bIndex = getBucketIndex(hCode) ;
		
		Entry ent = store[bIndex] ;
		while( ent != null ) {
			if ( ent.equals(k))
				ent.value = v ;
			ent = ent.next ;
		}
		
		Entry nEnt = new Entry(k , v) ;
		nEnt.next = store[bIndex] ;  // Adding in the head of the linked list
		store[bIndex] = nEnt ;
	}
	
	String get(Topic k) {
		int hCode = k.hashCode() ;
		hCode = getRefinedCode(hCode) ;
		int bIndex = getBucketIndex(hCode) ;
		
		Entry ent = store[bIndex] ;
		while( ent != null ) {
			if(ent.getKey().equals(k))
				return ent.getValue() ;
		}
		return null ;
	}
	
	int getRefinedCode(int code) {
		return code^8 ;
	}
	int getBucketIndex(int code) {
		return code % initialSize ;
	}

	public static void main(String[] args) {
		HashMapImpl hImpl = new HashMapImpl();
		hImpl.put(new Topic(1,"IBM"), "Topic1") ;
		hImpl.put(new Topic(2,"Yahoo"), "Topic2") ;
		hImpl.put(new Topic(3,"Google"), "Topic3") ;
		hImpl.put(new Topic(4,"FaceBook"), "Topic4") ;
		
		Topic tp = new Topic(10, "Apple") ;
		
		String ent = hImpl.get(tp) ;
		
		if ( ent == null) {
			System.out.println("No entry for :"+ tp.toString() +" \n") ;
		}
		
		tp = new Topic(2, "Yahoo") ;
		
		ent = hImpl.get(tp) ;
		
		if ( ent == null) {
			System.out.println("No entry for :"+ tp.toString() +" \n") ;
		}
		else {
			System.out.println("Key : " + tp.toString() + " Value:" + ent);
		}
		
		// Adding duplicate
		hImpl.put(new Topic(2,"Yahoo"), "Topic2Mod") ;
		tp = new Topic(2,"Yahoo") ;
		ent = hImpl.get(tp) ;
		System.out.println("new value for yahoo :" + ent);

	}

}

class Topic {
	private int id ;
	private String name ;
	
	Topic( int id , String nm){
		this.id = id ;
		this.name = nm ;
	}
	@Override
	public int hashCode() {
		return id % 2 + name.hashCode() ;
	}
	
	boolean equals( Topic t2) {
		if ( (this.id == t2.id) && name.equals(t2.name)) 
			return true ;
		else
			return false ;
	}
	
	@Override
	public String toString() {
		return this.id +  ":" + this.name ;
	}
	
}
