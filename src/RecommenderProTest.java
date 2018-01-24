import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class RecommenderProTest {

	public static void main(String[] args) {
		// Step1: Set uid
		int randudata = 193;
		// int totalItems =0;
		System.out.println("The Selected " + randudata);

		// Step2: Read u.data
		UdataService udataserv = new UdataService();
		udataserv.readUserData();
		List<Udata> udata = new ArrayList<Udata>();
		udata = udataserv.getUdata();

		// Step3: Select 5* ratings for the set uid
		ArrayList<Integer> selectedIdlist = new ArrayList<Integer>();

		for (int i = 0; i < udata.size(); i++) {
			if (randudata == udata.get(i).getUserId() && (udata.get(i).getRating() == 5))
				selectedIdlist.add(udata.get(i).getItemId());
		}

		UitemsService items = new UitemsService();
		items.readMovieInfoData();
		List<Uitems> moviesdata = new ArrayList<Uitems>();
		moviesdata = items.getMoviesData();

		for (int j = 0; j < selectedIdlist.size(); j++) {
			for (int i = 0; i < moviesdata.size(); i++) {
				if (selectedIdlist.get(j) == moviesdata.get(i).getMovieId()) {
					System.out.println(moviesdata.get(i).movieTitle + Arrays.toString(moviesdata.get(i).getGenres()));
				}
			}
			// can uncomment later System.out.println("All records for the selected userId
			// in u.data:" + selectedIdlist.get(j));
		}

		// Step 4: Set the user model
		UserModel usermodel = new UserModel();

		// Step 5: Collect the genre vectors for the selectedIdList

		ArrayList<int[]> selectList = new ArrayList<int[]>();
		for (int j = 0; j < selectedIdlist.size(); j++) {
			for (int i = 0; i < moviesdata.size(); i++) {
				if (selectedIdlist.get(j) == moviesdata.get(i).getMovieId())
					selectList.add(moviesdata.get(i).getGenres());
			}
			System.out.println("All records for the selected userId in u.data:" + Arrays.toString(selectList.get(j)));
		}

		// Step6: Compute total cosine similarity for each movie (changed From HashMap
		// to TreeMap)
		Map<Integer, Double> mapmoviesandcosimsum = new TreeMap<Integer, Double>();
		for (int i = 0; i < moviesdata.size(); i++) {
			double simSum = 0.0;
			for (int j = 0; j < selectList.size(); j++) {
				simSum += usermodel.CosineSimilarity(selectList.get(j), moviesdata.get(i).getGenres());
			}
			mapmoviesandcosimsum.put(moviesdata.get(i).getMovieId(), simSum);
		}
		Iterator it = mapmoviesandcosimsum.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if ((Double) pair.getValue() > 0.1)
				System.out.println("Unsorted Item:" + pair.getKey() + " = " + pair.getValue());
		}

		ValueComparator vc = new ValueComparator();

		// Calling the method sortByvalues
		Map sortedMap = vc.sortByValues(mapmoviesandcosimsum);

		// Get a set of the entries on the sorted map
		Set set = sortedMap.entrySet();

		// Get an iterator
		Iterator i = set.iterator();

		// Display elements
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			if(selectedIdlist.contains(me)) {
				sortedMap.get(me);
			}
			else {
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
			}
		}
//Step 7 Construct the map for computing average
		//start with the list of all movies/items
		Map<Integer, Double> ratingForMovie = new TreeMap<Integer, Double>();
		
		for(Uitems movie:moviesdata) {
			int id1 = movie.getMovieId();
			Map<Integer, Double> userRatingForMovie = new TreeMap<Integer, Double>();
			for(Udata rating:udata) {
				int id2 = rating.getItemId();
				if(id1==id2) {
					userRatingForMovie.put(new Integer(rating.getUserId()), new Double(rating.getRating()));
				}
			}
			UdataService uds = new UdataService();
			ratingForMovie.put(new Integer(id1), new Double(uds.getAverage(userRatingForMovie)));
		}
	
		//ValueComparator vc = new ValueComparator();

		// Calling the method sortByvalues
		Map sortedAvgMap = vc.sortByValues(ratingForMovie);

		// Get a set of the entries on the sorted map
		Set avgSet = sortedAvgMap.entrySet();
		
		// Get an iterator
				Iterator i1 = avgSet.iterator();

				// Display elements
				while (i1.hasNext()) {
					Map.Entry me = (Map.Entry) i1.next();
					if(selectedIdlist.contains(me)) {
						sortedAvgMap.get(me);
					}
					else {
					System.out.print(me.getKey() + ": ");
					System.out.println(me.getValue());
					}
				}
		  //step 8 Creating the combined listing for fisheye recommendation
		Map<Integer, Double> fisheyeRatingForMovie = new TreeMap<Integer, Double>();
		for(Uitems movie:moviesdata) {
			Integer mId = new Integer(movie.getMovieId());
			fisheyeRatingForMovie.put(mId, mapmoviesandcosimsum.get(mId)+ratingForMovie.get(mId));
		}
		//please sort the fisheyeRatingForMovie
		// Calling the method sortByvalues
				Map sortedFisheyeMap = vc.sortByValues(fisheyeRatingForMovie);

				// Get a set of the entries on the sorted map
				Set fisheyeSet = sortedFisheyeMap.entrySet();
				
				// Get an iterator
						Iterator i2 = fisheyeSet.iterator();

						// Display elements
						while (i2.hasNext()) {
							Map.Entry me = (Map.Entry) i2.next();
							if(selectedIdlist.contains(me)) {
								sortedFisheyeMap.get(me);
							}
							else {
							System.out.print(me.getKey() + ": ");
							System.out.println(me.getValue());
							}
						}
	}


	
	
}




     
	/*
	private double getAverage(Map<Integer, Integer> uRatings) {

		double uAverage = 0;
		Entry<Integer, Integer> entry;
		Iterator<Entry<Integer, Integer>> entriesIterator = uRatings.entrySet().iterator();
		while (entriesIterator.hasNext()) {

			entry = entriesIterator.next();
			uAverage += (int) entry.getValue();
		}

		return uAverage / uRatings.size();

	}

}
*/

/*
 * // Step 7 compute average rating for the movie data( uitems) create map and
 * stores sum of cosineSimilarity // and average rating
 * 
 * 
 * Map<Double, Integer> mapavgratingandsumcossim = new TreeMap<Double,
 * Integer>(); int AverageRating = 0; int counter = 0; int rating = 0; double
 * simSum = 0.0;
 * 
 * for ( int i =0; i < moviesdata.size(); i++) { for (int j = 0; j <
 * selectList.size(); j++) {
 * 
 * 
 * rating = rating + udata.get(i).getRating(); counter++; AverageRating =
 * rating/counter;
 * 
 * simSum += usermodel.CosineSimilarity(selectList.get(j),
 * moviesdata.get(i).getGenres());
 * 
 * mapavgratingandsumcossim.put(simSum, AverageRating);
 * 
 * 
 * Iterator it2 = mapavgratingandsumcossim.entrySet().iterator(); while
 * (it2.hasNext()) { Map.Entry pair = (Map.Entry)it2.next(); if((double)
 * ((Integer) pair.getValue()) >0.1) System.out.println(pair.getKey() + " = " +
 * pair.getValue());
 * 
 * 
 * 
 * }
 * 
 * }
 */
/*
 * // Step 8 create method to sort the map by values; call sort method in class
 * ValuComparator ValueComparator valuecomparator = new ValueComparator(
 * mapavgratingandsumcossim);
 * 
 * Map<Double, Integer> sortedeachmoviebyvalue = new TreeMap<Double,
 * Integer>(valuecomparator);
 * 
 * Iterator it3 = sortedeachmoviebyvalue.entrySet().iterator(); while
 * (it3.hasNext()) { Map.Entry pair = (Map.Entry)it3.next(); if((double)
 * ((Integer) pair.getValue()) >0.1) System.out.println(pair.getKey() + " = " +
 * pair.getValue());
 * 
 * 
 * } }
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * // Step 9 Recommendations
 * 
 * public Map<Integer, Double> getRecommendations(Map<Integer, Integer>
 * uRatings, Map<Integer, Double> cosineSimilarity, Map<Integer, Integer>
 * uItems) {
 * 
 * Map<Integer, Double> predictedRatings = new HashMap<>();
 * 
 * int movie; double userAverage = getAverage(uRatings);
 * 
 * double predictedRating;
 * 
 * 
 * for (int i = 0; i < uItems.size(); i++) {
 * 
 * if ( ! uItems.get(i).equals(null))
 * 
 * movie = uItems.get(i); //for (Movies m : movies) { //if (m != null) {
 * 
 * //movie = m.getId();
 * 
 * 
 * for( int j= 0; j < uRatings.size(); j++ ) {
 * 
 * 
 * 
 * if (!uRatings.containsKey(movie)) {
 * 
 * } } predictedRating = 0; if (denominator > 0) { predictedRating = userAverage
 * + numerator / denominator; if (predictedRating > 5) { predictedRating = 5; }
 * } predictedRatings.put(movie, predictedRating); } } }
 * 
 * return predictedRatings;
 * 
 * 
 * }
 * 
 * }
 * 
 * 
 * private double getAverage(Map<Integer, Integer> uRatings) { // TODO
 * Auto-generated method stub return 0;
 * 
 * 
 * }
 * 
 */
