package module51;

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class Module1 {

    public static CSVParser load_csv(String file){
        FileResource data = new FileResource(file);
        return data.getCSVParser();
    }

    public static ArrayList<Movie> load_movies(String file){
        CSVParser movies_csv = Module1.load_csv(file);
        ArrayList<Movie> movie_list = new ArrayList<>();
        for(CSVRecord movie: movies_csv){
            Movie a_movie = new Movie(movie.get("id"),
                                      movie.get("title"),
                                      movie.get("year"),
                                      movie.get("genre"),
                                      movie.get("director"),
                                      movie.get("country"),
                                      movie.get("poster"),
                                      Integer.valueOf(movie.get("minutes")));
            movie_list.add(a_movie);
        }
        return movie_list;
    }

    public static ArrayList<Rater> load_raters(String file){
        CSVParser raters_csv = Module1.load_csv(file);
        ArrayList<Rater> raters_list = new ArrayList<>();
        String temp_id = "";
        for(CSVRecord rater: raters_csv){
            if(!temp_id.equals(rater.get("rater_id"))){
                temp_id = rater.get("rater_id");
                Rater a_rater = new Rater(rater.get("rater_id"));
                a_rater.addRating(rater.get("movie_id"), Double.valueOf(rater.get("rating")));
                raters_list.add(a_rater);
            }else{
                raters_list.getLast().addRating(rater.get("movie_id"), Double.valueOf(rater.get("rating")));
            }
        }

        return raters_list;
    }

    // public static HashMap<String,Rating> load_ratings(String file){
    //     CSVParser raters_csv = Module1.load_csv(file);
    //     HashMap<String,Rating> movie_ratings = new HashMap<>();
    //     return null;
    // }



    public static void quiz1(){
        // FileResource movie_data = new FileResource("java_recommendation_system/data/ratedmoviesfull.csv");
        // CSVParser movie_csv = movie_data.getCSVParser();

        // 3
        // ArrayList<Integer> movie_length = new ArrayList<>();
        // for(CSVRecord movie : movie_csv){
        //     movie_length.add(Integer.valueOf(movie.get("minutes")));
        // }
        // int i = 0;
        // for(int l : movie_length){
        //     i += (l > 150)? 1 : 0;
        // }
        // System.out.println(i);

        // 4 5
        // HashMap<String,Integer> director = new HashMap<>();
        // for(CSVRecord movie : movie_csv){
        //     if(!director.containsKey(movie.get("director"))){
        //         director.put(movie.get("director"), 1);
        //     }else{
        //         director.replace(movie.get("director"), director.get(movie.get("director"))+1);
        //     }
        // }
        // int max = 0;
        // for(int i : director.values()){
        //     max = (i>max)? i : max;
        // }
        // System.out.println(max);
        // for(String name : director.keySet()){
        //     if(director.get(name)==23){
        //         System.out.println(name);
        //     }
        // }

        // 7
        // CSVParser ratings = load_csv("java_recommendation_system/data/ratings.csv");
        // HashMap<String,Integer> rating_map = new HashMap<>();
        // for(CSVRecord rate : ratings){
        //     String rater = rate.get("rater_id");
        //     if(rating_map.putIfAbsent(rater, 1) != null){
        //         rating_map.replace(rater, rating_map.get(rater)+1);
        //     }
        // }
        // int max = 0;
        // for(int rates:rating_map.values()){
        //     max = (rates>max)? rates : max;
        // }
        // System.out.println(max);
        // rating_map.forEach((s,i)->{if(i==max){System.out.println(s);}});

        // 10

        CSVParser ratings = load_csv("java_recommendation_system/data/ratings.csv");
        HashMap<String,Integer> rating_map = new HashMap<>();
        for(CSVRecord rate : ratings){
            String movie_id = rate.get("movie_id");
            if(rating_map.putIfAbsent(movie_id, 1) != null){
                rating_map.replace(movie_id, rating_map.get(movie_id)+1);
            }
        }
        System.out.printf("movie numbers: %d",rating_map.keySet().size());


    }

    public static void main(String[] args) {
        quiz1();
        
    }

}
