package  module54;
/**
 * Write a description of class Rater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Rater {
    private String id;
    private HashMap<String,Double> ratings;

    public Rater(String id) {
        this.id = id;
        ratings = new HashMap<>();
    }

    public void addRating(String item, double rating) {
        ratings.put(item, rating);
    }

    public boolean hasRating(String item) {
        return ratings.containsKey(item);
    }

    public String getID() {
        return id;
    }

    public double getRating(String movie_id) {
        return ratings.get(movie_id);
    }

    public int numRatings() {
        return ratings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>(ratings.keySet());    
        return list;
    }
}
