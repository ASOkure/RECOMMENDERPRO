import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ValueComparator 
{


	//Method for sorting the TreeMap based on values
	  public static <K, V extends Comparable<V>> Map<K, V> 
	    sortByValues(final Map<K, V> map) {
	    Comparator<K> valueComparator = 
	             new Comparator<K>() {
	      public int compare(K k1, K k2) {
	        int compare = 
	              map.get(k1).compareTo(map.get(k2));
	        if (compare == 0) 
	          return 1;
	        else 
	          return compare;
	      }
	    };
	    
	    Map<K, V> sortedByValues = 
	    	      new TreeMap<K, V>(valueComparator);
	    	    sortedByValues.putAll(map);
	    	    return sortedByValues;
	    	  }
	
	
	
	
	
}


	
	
	
	
	
	
	
/*
private Map<Integer, Double> map;

public ValueComparator(Map<Integer, Double> map) {
	
	   this.map = map;//new TreeMap<Integer,Double>();
	  // this.map.putAll(map);
}
	
		public int compare(Double a, Double b) 
		{
		
			if( map.get(a) >= map.get(b)) {
				
				return -1;
			}
			else {
				return 1;
			}
			
			 
			  return map.get(a).compareTo(map.get(b));
			 
		
		
		
		}
*/
	

