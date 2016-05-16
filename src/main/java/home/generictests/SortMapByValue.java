package home.generictests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapByValue {

	public List solution() {
		Map<String, Integer> input = new HashMap<>() ;
		input.put("A", 1);
		input.put("C", 1);
		input.put("D", 3);
		input.put("B", 1);
		input.put("B", 2);
		

		Set<Entry<String , Integer>> inpEntrySet = input.entrySet() ;
		List<Entry<String , Integer>> inpList = new ArrayList<>(inpEntrySet) ;
			
		
		Collections.sort(inpList , new Comparator<Map.Entry<String , Integer>>(){
			public int compare(Map.Entry<String , Integer> o1 , 
					Map.Entry<String, Integer> o2 ) {
						return  o2.getValue().compareTo(o1.getValue()) ;
					}
				});
		for ( Map.Entry<String , Integer> entry : inpList)	{
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		
		return inpList;
	}
	public static void main(String[] args) {
		System.out.println(new SortMapByValue().solution());

	}

}
