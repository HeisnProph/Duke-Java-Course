package module51;

import java.util.ArrayList;

public class Module2 {

    public static void main(String[] args) {
        SecondRatings rating_runner = new SecondRatings();
        // double[] rating = rating_runner.get_movie_rating("Vacation");
        // System.out.println(rating[0]+" , "+rating[1]);

        // 8 9
        ArrayList<Movie> movie_list = rating_runner.get_movies_byRating(35);
        // double min = 10;
        // for(Movie m : movie_list){
        //     double[] rating = rating_runner.get_movie_rating(m.getID());
        //     if(rating[0]<min){
        //         min = rating[0];
        //         System.out.println(m.getTitle());
        //     }     
        // }
        System.out.println(movie_list.size());


    }
    
}
