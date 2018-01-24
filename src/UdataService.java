import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

public class UdataService {

	List<Udata> udata = new ArrayList<Udata>();
	
	private Map<Integer, Map<Integer, Integer>>userMovieRating  = new HashMap<>();
	
	private Users[] userAvgRating = new Users[944];
	
	
	
	public void readUserData() {
		
		 try {
	         File f = new File("u.data");
	         Scanner sc = new Scanner(f);

	         

	         while(sc.hasNextLine()){
	             String line = sc.nextLine();
	             //System.out.println(line);
	            
	             String[] datadetails = line.split("\\t");
	             
	             //for( int i =0; i < datadetails.length; i++)
	             //System.out.println(datadetails[i]);
	         
	             	int userId = Integer.parseInt(datadetails[0]);
	                 int itemId = Integer.parseInt(datadetails[1]);
	             	int rating = Integer.parseInt(datadetails[2]);
	             	int timestamp = Integer.parseInt(datadetails[3]);
	             
	             

					if (userMovieRating.containsKey(userId)) {
						userMovieRating.get(userId).put(itemId, rating);
						userAvgRating[userId] = new Users(userId, userAvgRating[userId].getAverageRating() + rating);
					} else {
						Map<Integer, Integer> movieRating = new HashMap<>();
						movieRating.put(itemId, rating);
						userMovieRating.put(userId, movieRating);
						userAvgRating[userId] = new Users(userId, (double)  rating);
					}
	             	
	             for( Users ra: userAvgRating) {
	            	  if ( ra !=null)
	            		  userAvgRating[ra.getIdUser()].setAverageRating(ra.getAverageRating()/
	            				  (double)userMovieRating.get(ra.getIdUser()).size());
	             }
	             	
	             Udata data = new Udata(userId, itemId, rating, timestamp);
	            
	             udata.add(data);
	         }
	         
	             
	    	 
	 } catch (FileNotFoundException e) {         
	         e.printStackTrace();
	     }
	 
		}

	
 	public double getAverage( Map<Integer, Double> uRatings) 
 	{
 		
    double uAverage = 0;
    Entry<Integer, Double> entry;
    Iterator<Entry<Integer, Double>> entriesIterator  = uRatings.entrySet().iterator();
    while(entriesIterator.hasNext()) {
 	   
 	   entry = entriesIterator.next();
 	   uAverage += ((Double)entry.getValue()).doubleValue();
    }
 	
    return uAverage /uRatings.size();
 		
 	}
	
	
	public List<Udata> getUdata() {
		return udata;
	}

	public void setUdata(List<Udata> udata) {
		this.udata = udata;
	}
		 
	    
	
	
	
	
	
	
	
	
		}



		
		
		


	
	
	

