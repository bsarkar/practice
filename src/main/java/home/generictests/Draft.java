package home.generictests;

import home.generictests.BoaSample.PosInd;
import home.generictests.BoaSample.Trade;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Draft {
public void solution() {
	/* ONE WAY
	
				int i = 0 ;
				Collections.sort(trdList,new Comparator<Trade>() {
					public int compare(Trade a , Trade b) {
						return a.getcParty().compareTo(b.getcParty()) ;
					}
				}) ;
				
				boolean check = false ;
				long cptpos = 0 ;
				
				String pCp= null ;
				Map<Long,PosInd> cptposMap = new TreeMap<>() ;
				for ( Trade trd : trdList) {
					String cp = trd.getcParty() ;
					
					if( !cp.equals(pCp) && check) {	
						PosInd pid = new PosInd();
						if ( cptpos < 0) {
							pid.setInd(-1);
						}
						else {
							pid.setInd(1);
						}
						pid.setTkt(trd.getcParty());
						cptpos= 0 ;
						cptposMap.put(cptpos,pid) ;
					}
					else {			
						Double p = prcMap.get(trd.getTicker()) ;
						cptpos += trd.getQty() * p ;
						
					}
					check = true;
					pCp = cp ;
				}
				
				i = 0 ;
				for ( Map.Entry ent : cptposMap.entrySet()) {
					if ( i == 4) // first 3
						break ;
					PosInd p = (PosInd)ent.getValue() ;
					System.out.println( "" + ((int)ent.getKey() * p.getInd())+ "  :  " + ent.getValue() + "\n");
					i++ ;
				}
				*/

}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
