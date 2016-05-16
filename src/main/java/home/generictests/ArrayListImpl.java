package home.generictests;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayListImpl {

	private int size ;
	private Object [] store ;
	private final int DEF_SIZE = 10 ;
	
	int current = 0;
	
	public void ArrayListImpl() {
		store = new Object[DEF_SIZE] ;
		size = DEF_SIZE ;
		}
	
	public Object remove(int index){
		if ( index < size) {
			Object o = store[index] ;
			store[index] = null ;
			int tmp = index ;
			while( tmp < size) {
				store[tmp]= store[tmp+1];
				tmp++;
			}
			store[tmp] = null ;
			size--;
			return o ;
		}
		throw new ArrayIndexOutOfBoundsException() ;
	}
	
	public void add(Object o) {
		if( (store.length - size) <= size/2 )
			resize() ;
		store[current]	= o ;
		
	}
	
	public int size() {
		return size ;
	}
	
	private void resize() {
		int lsize = 2 * this.size();
		store = Arrays.copyOf(store, lsize) ;
		size = lsize ;
	}
	
	class ArrIterator implements Iterator {
		
		public Object next() {
			if ( hasNext())
				current++;
			return store[current] ;
		}

		public boolean hasNext() {
			if ( store[current+1] != null)
				return true ;
			else
				return false;
		}
		
		public Object get(int index) {
			if ( index < size)
				return store[index];
			else
				throw new ArrayIndexOutOfBoundsException();
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
