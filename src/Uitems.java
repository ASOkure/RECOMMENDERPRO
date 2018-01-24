import java.util.Arrays;

/*
Information about the items (movies); this is a tab separated
              list of
              movie id | movie title | release date | video release date |
              IMDb URL | unknown | Action | Adventure | Animation |
              Children's | Comedy | Crime | Documentary | Drama | Fantasy |
              Film-Noir | Horror | Musical | Mystery | Romance | Sci-Fi |
              Thriller | War | Western |
              The last 19 fields are the genres, a 1 indicates the movie
              is of that genre, a 0 indicates it is not; movies can be in
              several genres at once.
              The movie ids are the ones used in the u.data data set.*/

public class Uitems {


	int movieId;
	String movieTitle;
	String releaseDate;
	String videoReleaseDate;
	String IMDbURL;
	int[] Genres;
	
	
	public Uitems(int movieId, String movieTitle, String releaseDate, String videoReleaseDate, String iMDbURL, int [] genres) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.releaseDate = releaseDate;
		this.videoReleaseDate = videoReleaseDate;
		IMDbURL = iMDbURL;
		Genres = genres;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getVideoReleaseDate() {
		return videoReleaseDate;
	}

	public void setVideoReleaseDate(String videoReleaseDate) {
		this.videoReleaseDate = videoReleaseDate;
	}

	public String getIMDbURL() {
		return IMDbURL;
	}

	public void setIMDbURL(String iMDbURL) {
		IMDbURL = iMDbURL;
	}

	


	public int[] getGenres() {
		return Genres;
	}

	public void setGenres(int[] genres) {
		Genres = genres;
	}

	@Override
	public String toString() {
		return "MoviesInfo [movieId=" + movieId + ", movieTitle=" + movieTitle + ", releaseDate=" + releaseDate
				+ ", videoReleaseDate=" + videoReleaseDate + ", IMDbURL=" + IMDbURL + ", Genres="
				+ Arrays.toString(Genres) + "]";
	}	
	
	
	

}






