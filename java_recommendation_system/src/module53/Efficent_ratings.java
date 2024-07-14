/**
 * @Description: 
 * @Aurthor: heisnproph
 * @Date: Jul 12, 2024
 */ 

package module53;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import module51.Module1;


/**
 * @description:
 * @author: heisnproph
 */
public class Efficent_ratings implements Rater {

    private HashMap<String,ArrayList<Double>> movie_ratings;

    public Efficent_ratings(){
        this("java_recommendation_system/src/module54/data/ratings.csv");
        //this("java_recommendation_system/src/module54/data");
    }

    public Efficent_ratings(String file) {
        movie_ratings = new HashMap<>();
        CSVParser ratings_csv = Module1.load_csv(file);
        for(CSVRecord rater : ratings_csv){
            String movie_id = rater.get("movie_id");
            Double rating = Double.parseDouble(rater.get("rating"));
            addRating(movie_id, rating);
        }
    }

    public void addRating(String movie_id, double rating) {
        if(movie_ratings.putIfAbsent(movie_id, new ArrayList<>(Arrays.asList(rating))) != null){
            movie_ratings.get(movie_id).add(rating);
        }
    }

    public boolean hasRating(String movie) {
        String movie_id = (movie.matches("\\d+"))? movie : MovieDatabase.get_id(movie);
        return movie_ratings.containsKey(getID(movie_id));
    }

    // uncompleted
    public String getID(String movie) {
        return MovieDatabase.get_id(movie);
    }

    public double getRating(String movie) {
        String movie_id = (movie.matches("\\d+"))? movie : MovieDatabase.get_id(movie);
        double final_rating = 0;
        for(double rating : movie_ratings.get(movie_id)){
            final_rating += rating;
        }
        final_rating = final_rating/numRatings(movie);
        return final_rating;
    }

    public int numRatings(String movie) {
        String movie_id = (movie.matches("\\d+"))? movie : MovieDatabase.get_id(movie);
        return movie_ratings.get(movie_id).size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(String id : movie_ratings.keySet()){
            list.add(MovieDatabase.getTitle(id));
        }
        return list;
    }

}
