package module51;

/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("java_recommendation_system/data/ratedmoviesfull.csv", "java_recommendation_system/data/ratings.csv");
    }

    public SecondRatings(String movies, String rating){
        myMovies = Module1.load_movies(movies);
        myRaters = Module1.load_raters(rating);
    }


    public double[] get_movie_rating(String movie){
        double rating = 0;
        String movie_id = "";
        if(movie.matches("\\d+")){
            movie_id = movie;
        }else{
            movie_id = get_movie_id(movie);
        }

        int n_ratings = 0;
        for(Rater rater: myRaters){
            if(rater.hasRating(movie_id)){
                rating += rater.getRating(movie_id);
                n_ratings += 1;
            }
        }
        return new double[]{rating/n_ratings,n_ratings};
    }

    public ArrayList<Movie> get_movies_byRating(int n_ratings){
        ArrayList<Movie> movie_list = new ArrayList<>();
        for(Movie m : myMovies){
            double[] m_rating = get_movie_rating(m.getID());
            if(m_rating[1]>=n_ratings){
                movie_list.add(m);
            }
        }
        return movie_list;
    }


    public String get_movie_id(String movie){
        String movie_id = "";
        for(Movie m : myMovies){
            if (m.getTitle().equals(movie)){
                movie_id = m.getID();
            }
        }
        return movie_id;
    }
    
}
