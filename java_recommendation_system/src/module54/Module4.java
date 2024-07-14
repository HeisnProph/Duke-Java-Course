/**
 * @Description: 
 * @Aurthor: heisnproph
 * @Date: Jul 13, 2024
 */ 

package module54;

import java.util.ArrayList;
import java.util.Arrays;


import module51.Rating;
import module53.AllFilters;
import module53.MovieDatabase;
import module53.TrueFilter;
import module53.YearAfterFilter;

/**
 * @description:
 * @author: heisnproph
 */
public class Module4 {


    
    public static void question6(){
        FourthRating fr = new FourthRating();
        for(Rating r : fr.get_similar_ratings("337", 10, 3)){
            System.out.println(MovieDatabase.getTitle(r.get_id())+" , "+r.get_value());
            break;
        } 
    }

    public static void question7(){
        FourthRating fr = new FourthRating();
        AllFilters all_filter = new AllFilters();
        all_filter.addFilter((s)->{
            String[] genres_a = MovieDatabase.getGenres(s).trim().split(",");
            ArrayList<String> genres = new ArrayList<>(Arrays.asList(genres_a));
            genres.replaceAll(g->g.trim());
            return genres.contains("Mystery");
        });
        for(Rating r : fr.get_similar_ratings_filtered(all_filter,"964", 20,5)){
            System.out.println(MovieDatabase.getTitle(r.get_id())+" , "+r.get_value());
            break;
        } 
    }

    public static void question8(){
        FourthRating fr = new FourthRating();
        for(Rating r : fr.get_similar_ratings("71", 20, 5)){
            System.out.println(MovieDatabase.getTitle(r.get_id())+" , "+r.get_value());
            break;
        } 
    }


    public static void question9(){
        FourthRating fr = new FourthRating();
        AllFilters all_filter = new AllFilters();

        String[] directors =  "Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh".trim().split(",");
        ArrayList<String> director_list = new ArrayList<>(Arrays.asList(directors));
        all_filter.addFilter(new TrueFilter(4));
        all_filter.addFilter((movie)->{
            String[] director_movie = MovieDatabase.getDirector(movie).trim().split(",");
            for (String d : director_movie) {
                if(director_list.contains(d.trim())){return true;}
            }
            return false;
        });
        
        for(Rating r : fr.get_similar_ratings_filtered(all_filter,"120", 10,2)){
            System.out.println(MovieDatabase.getTitle(r.get_id())+" , "+r.get_value());
            break;
        } 
    }

    public static void question10(){
        FourthRating fr = new FourthRating();
        AllFilters all_filter = new AllFilters();
        all_filter.addFilter((s)->{
            String[] genres_a = MovieDatabase.getGenres(s).trim().split(",");
            ArrayList<String> genres = new ArrayList<>(Arrays.asList(genres_a));
            genres.replaceAll(g->g.trim());
            return genres.contains("Drama");
        });
        all_filter.addFilter((movie)->{
            int minutes = MovieDatabase.getMinutes(movie);
            return minutes>=80 && minutes<=160;
        });
        
        for(Rating r : fr.get_similar_ratings_filtered(all_filter,"168", 10,3)){
            System.out.println(MovieDatabase.getTitle(r.get_id())+" , "+r.get_value());
            break;
        } 
    }

    public static void question11(){
        FourthRating fr = new FourthRating();
        AllFilters all_filter = new AllFilters();
        all_filter.addFilter((movie)->{
            int minutes = MovieDatabase.getMinutes(movie);
            return minutes>=70 && minutes<=200;
        });
        all_filter.addFilter(new YearAfterFilter(1975));
        for(Rating r : fr.get_similar_ratings_filtered(all_filter,"314", 10,5)){
            System.out.println(MovieDatabase.getTitle(r.get_id())+" , "+r.get_value());
            break;
        } 
    }


    public static void question(){
        FourthRating fr = new FourthRating();
        AllFilters all_filter = new AllFilters();
        all_filter.addFilter((s)->{
            String[] genres_a = MovieDatabase.getGenres(s).trim().split(",");
            ArrayList<String> genres = new ArrayList<>(Arrays.asList(genres_a));
            genres.replaceAll(g->g.trim());
            return genres.contains("Action");
        });
        // all_filter.addFilter((movie)->{
        //     int minutes = MovieDatabase.getMinutes(movie);
        //     return minutes>=80 && minutes<=160;
        // });
        
        for(Rating r : fr.get_similar_ratings_filtered(all_filter,"65", 20,5)){
            System.out.println(MovieDatabase.getTitle(r.get_id())+" , "+r.get_value());
            break;
        } 
        
    }

    
    public static void main(String[] args) {
        question11();
    }

}
