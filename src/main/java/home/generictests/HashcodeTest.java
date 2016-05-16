package home.generictests;

import java.util.HashMap;
import java.util.Map;

public class HashcodeTest {
	
	public class MyItem {
		
		private int price;
		private String name ;
		
		public  MyItem(int pr , String nm){
			this.price = pr;
			this.name = nm ;
		}
		public int getPrice(){
			return price ;
		}
		public String getName()	{
			return name ;
		}
		public boolean equals( Object o) {
			MyItem tmp= null;
			if( o instanceof MyItem) {
				 tmp = (MyItem) o ;
			}
			if( (tmp.getName()).equals(this.getName()) && tmp.getPrice() == this.getPrice())
				return true ;
			else
				return false ;
		}
		
		public int hashCode() {		
			int hCode = (int) (this.getPrice() * 100) ;
			hCode += this.getName().hashCode() ;
			return hCode ;		
		}
		
		public String toString() {
			return "Price:" + this.getPrice() + " Name :" + this.getName() ;
		}
	}
	
	public static void main(String[] args) {
		
		Map<MyItem, String> mItem = new HashMap<>();
		mItem.put(new HashcodeTest().new MyItem(10,"Item1"), "Cart1") ;
		mItem.put(new HashcodeTest().new MyItem(12,"Item2"), "Cart2") ;
		mItem.put(new HashcodeTest().new MyItem(14,"Item3"), "Cart3") ;
		mItem.put(new HashcodeTest().new MyItem(16,"Item4"), "Cart4") ;
		
		MyItem it = new HashcodeTest().new MyItem(14,"Item3") ;
		System.out.println(mItem.get(it));

	}

}
