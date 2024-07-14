

package module53;

import java.util.*;
import org.apache.commons.csv.*;
import module51.Movie;
import module51.Module1;


public class MovieDatabase {
    private static HashMap<String, Movie> ourMovies;
    private static HashMap<String, String> movies_id;
    private static Efficent_ratings ratings;

    public static void initialize(String moviefile) {
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            loadMovies("java_recommendation_system/src/module54/data/" + moviefile);
        }
    }
    
    private static void initialize() {
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            // loadMovies("java_recommendation_system/src/module4/data/ratedmoviesfull.csv");
            loadMovies("java_recommendation_system/src/module54/data/ratedmoviesfull.csv");
        }
    }	

    private static void loadMovies(String filename) {
        movies_id = new HashMap<>();
        CSVParser movies_csv = Module1.load_csv(filename);
        for(CSVRecord movie: movies_csv){
            Movie a_movie = new Movie(movie.get("id"),
                                      movie.get("title"),
                                      movie.get("year"),
                                      movie.get("genre"),
                                      movie.get("director"),
                                      movie.get("country"),
                                      movie.get("poster"),
                                      Integer.valueOf(movie.get("minutes")));
            ourMovies.put(a_movie.getID(),a_movie);
            movies_id.put(a_movie.getTitle(), a_movie.getID());
        }
        ratings = new Efficent_ratings();
    }


    public static String get_id(String movie){
        initialize();
        return movies_id.get(movie);
    }

    public static boolean containsID(String id) {
        initialize();
        return ourMovies.containsKey(id);
    }

    
    /**
     * 
     * @param id movie_id 
     * @return average rating
     */
    public static double get_rating(String id){
        initialize();
        return ratings.getRating(id);
    }

    public static int get_rating_number(String id){
        initialize();
        return ratings.numRatings(id);
    }


    public static int getYear(String id) {
        initialize();
        return ourMovies.get(id).getYear();
    }

    public static String getGenres(String id) {
        initialize();
        return ourMovies.get(id).getGenres();
    }

    public static String getTitle(String id) {
        initialize();
        return ourMovies.get(id).getTitle();
    }

    public static Movie getMovie(String id) {
        initialize();
        return ourMovies.get(id);
    }

    public static String getPoster(String id) {
        initialize();
        return ourMovies.get(id).getPoster();
    }

    public static int getMinutes(String id) {
        initialize();
        return ourMovies.get(id).getMinutes();
    }

    public static String getCountry(String id) {
        initialize();
        return ourMovies.get(id).getCountry();
    }

    public static String getDirector(String id) {
        initialize();
        return ourMovies.get(id).getDirector();
    }

    public static int size() {
        return ourMovies.size();
    }

    public static ArrayList<String> filterBy(Filter f) {
        initialize();
        ArrayList<String> list = new ArrayList<String>();
        for(String id : ourMovies.keySet()) {
            if (f.satisfies(id)) {
                list.add(id);
            }
        }
        
        return list;
    }

}
