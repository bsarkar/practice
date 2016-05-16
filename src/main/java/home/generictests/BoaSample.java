package home.generictests;

import home.generictests.BoaSample.PosInd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BoaSample {
	List<String> fileNames = new ArrayList<>();
	List<Trade> trdList = new ArrayList<>() ;
	Map<String,Double> prcMap ;
	
	class PosInd {
		String tkt ;
		int ind ;
		public String getTkt() {
			return tkt;
		}
		public void setTkt(String tkt) {
			this.tkt = tkt;
		}
		public int getInd() {
			return ind;
		}
		public void setInd(int ind) {
			this.ind = ind;
		}

	}
	
	class Trade {
		Date tdate ;
		String cParty ;
		String busySell ;
		String ticker ;
		int	qty ;
		Double price ;
		public Date getTdate() {
			return tdate;
		}
		public void setTdate(Date tdate) {
			this.tdate = tdate;
		}
		public String getcParty() {
			return cParty;
		}
		public void setcParty(String cParty) {
			this.cParty = cParty;
		}
		public String getBusySell() {
			return busySell;
		}
		public void setBusySell(String busySell) {
			this.busySell = busySell;
		}
		public String getTicker() {
			return ticker;
		}
		public void setTicker(String ticker) {
			this.ticker = ticker;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		
		public Trade (String line) {
			StringTokenizer st = new StringTokenizer(line," ");
			String sDate = st.nextToken() ;
			
			this.setcParty(st.nextToken());
			this.setBusySell(st.nextToken());
			this.setTicker(st.nextToken());
			this.setQty(Integer.parseInt(st.nextToken()));
			this.setPrice(Double.parseDouble(st.nextToken()));
		}

	 }
	 
		public List<String> getTradeFiles(String directory) {
	        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
	            for (Path path : directoryStream) {
	            	if ( path.toString().contains("pr"))
	            		continue ;
	                fileNames.add(path.toString());
	            }
	        } catch (IOException ex) {}
	        return fileNames;
	    }
		
		public void process(String dir, Map<String, Double> pr) {
			fileNames = this.getTradeFiles(dir) ;
			this.prcMap = pr ;
			
			for ( String file : fileNames) {
				
				try { 
					String line = null ;
					BufferedReader brdr = new BufferedReader(new FileReader(file)) ;
					while(( line = brdr.readLine()) != null) {
						Trade trd = new Trade(line);
						trdList.add(trd) ;
					}
				} catch ( IOException e) {
					System.out.println("Exception during opening file" + e.getMessage());
				}
				
			}
			
			TreeMap<String,TreeMap< String , List<Trade>>> cpartyMap = new TreeMap<>();
			TreeMap<String, List<Trade>> tTkMap = null ;
			
			TreeMap<String,TreeMap< String , List<Trade>>> tTkMap2 = new TreeMap<>();
			TreeMap<String, List<Trade>> cpartyMap2 = null ;
			
			for ( Trade trade : trdList) {
				String cp = trade.getcParty() ;
				String tkr = trade.getTicker();
				if(cpartyMap.get(cp) == null) {
					tTkMap = new TreeMap<>() ;
					cpartyMap.put(cp, tTkMap) ;
				}
				TreeMap<String,List<Trade>> cp1 = cpartyMap.get(cp);
				if ( cp1.get(tkr) == null) {
					List<Trade> tr1 = new ArrayList<>() ;
					cp1.put(tkr, tr1) ;
				}
				cp1.get(tkr).add(trade) ;
				
				// Second Tree (Based on Ticker,Cpty- trying to reduce one more iteration but costing space
				if(tTkMap2.get(tkr) == null) {
					cpartyMap2 = new TreeMap<>() ;
					tTkMap2.put(tkr, cpartyMap2) ;
				}
				TreeMap<String,List<Trade>> tk1 = tTkMap2.get(tkr);
				if ( tk1.get(cp) == null) {
					List<Trade> tr2 = new ArrayList<>() ;
					tk1.put(cp, tr2) ;
				}
				tk1.get(cp).add(trade) ;

			}

			
			int i = 0 ;
			/* Debug
			System.out.println("Checking order - Counter Party Wise Begin\n");
			for( Map.Entry<String,TreeMap<String,List<Trade>>> entry1 : cpartyMap.entrySet()){
				String s1 = (String)entry1.getKey() ;
				TreeMap< String , List<Trade>> c1 = cpartyMap.get(s1) ;
				for ( Map.Entry<String,List<Trade>> entry2 : c1.entrySet()) {
					String s2 = (String)entry2.getKey() ;
					List<Trade> ll = c1.get(s2) ;
					for ( Trade tr : ll) {
						i++ ;
						System.out.println("Trade : " + "[" + i + "]"+ tr.getcParty() + "-" + tr.getTicker() + 
							"-" + tr.getQty() + "-" + tr.getPrice());
					}
				}
				
			}
			System.out.println("Counter Party Wise End\n");
			
			i = 0 ;
			System.out.println("Checking order - Ticker Position Wise Begin\n");
			for( Map.Entry<String,TreeMap<String,List<Trade>>> entry1 : tTkMap2.entrySet()){
				String s1 = (String)entry1.getKey() ;
				TreeMap< String , List<Trade>> c1 = tTkMap2.get(s1) ;
				for ( Map.Entry<String,List<Trade>> entry2 : c1.entrySet()) {
					String s2 = (String)entry2.getKey() ;
					List<Trade> ll = c1.get(s2) ;
					for ( Trade tr : ll) {
						i++ ;
						System.out.println("Trade : " + "[" + i + "]"+ tr.getcParty() + "-" + tr.getTicker() + 
							"-" + tr.getQty() + "-" + tr.getPrice());
					}
				}
				
			}
			System.out.println("Ticker Position Wise End\n");
			*/ // Debug end
			
			i = 0 ;
			
			Map<Long,PosInd> cptposMap = new TreeMap<>() ;
			cptposMap = new TreeMap<>() ;
			for( Map.Entry<String,TreeMap<String,List<Trade>>> entry1 : cpartyMap.entrySet()){
				String s1 = (String)entry1.getKey() ;
				TreeMap< String , List<Trade>> c1 = cpartyMap.get(s1) ;
				long cptpos = 0 ;
				PosInd pid = new PosInd();
				
				for ( Map.Entry<String,List<Trade>> entry2 : c1.entrySet()) {
					String s2 = (String)entry2.getKey() ;
					List<Trade> ll = c1.get(s2) ;
					for ( Trade tr : ll) {
						i++ ;
						Double p = prcMap.get(tr.getTicker()) ;
						if( tr.getBusySell().equals("B"))
							cptpos += tr.getQty() * p;
						else
							cptpos -= tr.getQty() * p ;
						if ( cptpos < 0) {
							pid.setInd(-1);
						}
						else {
							pid.setInd(1);
						}
						pid.setTkt(tr.getcParty());
											
					}
				}
				
				cptposMap.put(Math.abs(cptpos), pid) ;
				
			}
			
			// Sort it in reverse for maximum exposures first
			
			/* Debug
			System.out.println("Before Sort\n");
			i = 0 ;
			for ( Map.Entry ent : cptposMap.entrySet()) {
				if ( i == 4) // first 3
					break ;
				PosInd p = (PosInd)ent.getValue() ;
				System.out.println( "" + ((long)ent.getKey() * p.getInd())+ "  :  " + ent.getValue() + "\n");
			}
			*/ // Debug End
			
			Set<Entry<Long,PosInd>> inpset = cptposMap.entrySet() ;
			ArrayList<Entry<Long,PosInd>> input = new ArrayList<Entry<Long, PosInd>>(inpset) ;
			
			Collections.sort(input, 
						new Comparator<Map.Entry<Long , PosInd>>() {
				@Override
				public int compare(Map.Entry<Long, PosInd> o1, Map.Entry<Long, PosInd> o2) {
					if ( o1.getKey() < o2.getKey()) {
						return 1 ;
					}
					else if (o1.getKey() > o2.getKey()) {
						return -1;
					}
					else {
						return 0;
					}
				}

			});
			
			// System.out.println("After Sort\n");
			i = 0 ;
			for ( Map.Entry ent : input) {
				if ( i == 4) //  Output only first 3
					break ;
				PosInd p = (PosInd)ent.getValue() ;
				System.out.println( "" + ((long)ent.getKey() * p.getInd())+ "  :  " + ent.getValue() + "\n");
			}
			
			
			/*
			System.out.println("Using Keyset\n");
				i = 0 ;
				Set<String> st = cpartyMap.keySet() ;
				for ( String a : st) {
					TreeMap< String , List<Trade>> ptktMap =  cpartyMap.get(a);
					Set<String> st2 = ptktMap.keySet() ;
					for ( String b : st2) {
						List<Trade> tlist = ptktMap.get(b) ;
						for(Trade tr : tlist) {
							i++ ;
							System.out.println("Trade : " + "[" + i + "]"+ tr.getcParty() + "-" + tr.getTicker() + 
								"-" + tr.getQty() + "-" + tr.getPrice());
						}
					}
				}
				*/
			
		}
		
		public Map<String , Double> getPriceEod(String flnm) {
			Map<String, Double> prMap = new HashMap<>();
			try { 
				String line = null ;
				BufferedReader brdr = new BufferedReader(new FileReader(flnm)) ;
				while(( line = brdr.readLine()) != null) {
					StringTokenizer st = new StringTokenizer(line," ") ;
					String tkr = st.nextToken() ;
					Double pr = Double.parseDouble(st.nextToken()) ;
					prMap.put(tkr, pr) ;
					
				}
			} catch ( IOException e) {
				System.out.println("Exception during opening file" + e.getMessage());
			}
			for ( Entry<String, Double> tok : prMap.entrySet()) {
				System.out.println("" + tok.getKey() + " : " + tok.getValue());
			}
			return prMap ;
		}
		
	public static void main(String[] args) {
		BoaSample boa = new BoaSample() ;
		Map<String, Double> prEod = boa.getPriceEod(args[1]) ;
		boa.process(args[0], prEod) ;

	}

}
