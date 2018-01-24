import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UitemsService {

	
	/*
	int movieId;
	String movieTitle;
	Date releaseDate;
	Date videoReleaseDate;
	String IMDbURL;
	int [] Genre 
	 */
	List<Uitems> moviesdata = new ArrayList<Uitems>();

	public void readMovieInfoData() {

		try {
			File f = new File("u.item");
			Scanner sc = new Scanner(f);

			

			String [] GenreVals = {"unknown", "Action", "Adventure", "Animation", "Children", "Comedy",
					"Crime","Documentary", "Drama", "Fantasy", "Film-Noir", "Horror",
					"Musical"," Mystery", "Romance", "Sci-Fi",  "Thriller",  "War",  "Western"};

			// String []movieIdgenre = new String [19];




			while(sc.hasNextLine()){

				String line = sc.nextLine();

				System.out.println(line);

				String[] moviedetails = line.split("\\|");

				//String [] movieIdgenre;


				//for( int i =0; i < datadetails.length; i++)
				//System.out.println(datadetails[i]);

				int movieId = Integer.parseInt(moviedetails[0]);
				String  movieTitle = moviedetails[1];
				String releaseDate  = moviedetails[2];
				String  videoReleaseDate = moviedetails[3];
				String IMDbURL = moviedetails[4];	
				String[] GenresRaw = Arrays.copyOfRange(moviedetails, 5, 24);
				int[] Genres = new int[GenresRaw.length];
				int i = 0;
				for( String x : GenresRaw) {

					Genres[i] = Integer.parseInt(x);
					i++;
				}

				Uitems data = new Uitems( movieId,  movieTitle,  releaseDate, 
						videoReleaseDate,  IMDbURL, Genres);

				moviesdata.add(data);
			}

			for(Uitems data: moviesdata)
				System.out.println(data.toString());
			
		Uitems movie = moviesdata.get(0);
		Uitems vector = moviesdata.get(moviesdata.size() -1);
		
		System.out.println("movieId  & vector:" +  movie + "vector" + vector) ;
		

				//from the list of movieinfo records, select the 19 category vector for all the itemids




		} catch (FileNotFoundException e) {         
			e.printStackTrace();
		}

	}

	public List<Uitems> getMoviesData() {
		// TODO Auto-generated method stub
		return moviesdata;
	}

	public List<Uitems> selectedIdlist() {
		// TODO Auto-generated method stub
		return null;
	}

	
}









	
	
	

