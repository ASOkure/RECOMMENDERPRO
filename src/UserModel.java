import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.print.attribute.standard.PrinterLocation;

public class UserModel 
{
	//ArrayList
	
	// use the genres 010101010101010010 to calculate the cosine similarities;
	// create method to calculate cosine similarity
	
	public double CosineSimilarity(int[] ModelVector, int[] ItemVector) 
	{   
		double dotProduct = 0.0;
		double magnitude1 = 0.0;
		double magnitude2 = 0.0;
		double cosineSimilarity = 0.0;
		
		/* UitemsService items = new UitemsService();
	        items.readMovieInfoData();
	        
	        ModelVector = new ArrayList<Uitems>();
	        ModelVector  = items.selectedIdlist();
	        
	        for ( int i =0; i< ModelVector.size(); i++)
	        	
	        	System.out.println( ModelVector.get(i));
	        
	        ItemVector = new ArrayList<Uitems>();
	        ItemVector = items.getMoviesData();*/
	       
		
	
	
	
	
	for ( int i = 0; i < ModelVector.length; i ++ )
		dotProduct += ModelVector[i]  * ItemVector[i];
	
	for ( int i = 0; i < ModelVector.length; i ++ )
		magnitude1 += Math.pow(ModelVector[i], 2);
		
	 for ( int k = 0; k < ItemVector.length; k++)
		magnitude2 += Math.pow(ItemVector[k], 2);
	System.out.println(Arrays.toString(ModelVector)+" "+Arrays.toString(ItemVector)+" "+dotProduct+" "+magnitude1+" "+magnitude2);

	
	magnitude1 = Math.sqrt(magnitude1); //sqr(a^2)
	magnitude2 = Math.sqrt(magnitude2);
	
	if ( magnitude1 !=0.0 | magnitude2 !=0.0)
	{	
		cosineSimilarity = dotProduct/(magnitude1 * magnitude2);
		System.out.println(Arrays.toString(ModelVector)+" "+Arrays.toString(ItemVector)+" "+cosineSimilarity);
	
	}
	else
	{
		
		return 0.0;
	}
	
	return cosineSimilarity;
	
	}

}
