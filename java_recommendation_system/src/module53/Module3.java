
package module53;

import java.util.ArrayList;
import java.util.Arrays;



public class Module3 {

    
    public static void questions(){
        AllFilters all_filter = new AllFilters();

        // 4
        // all_filter.addFilter(new TrueFilter(35));

        // 5
        // all_filter.addFilter(new TrueFilter(20));
        // all_filter.addFilter(new YearAfterFilter(2000));

        // 6
        // all_filter.addFilter(new TrueFilter(20));
        // all_filter.addFilter((s)->{
        //     String[] genres = MovieDatabase.getGenres(s).split(",");
        //     ArrayList<String> genres_l = new ArrayList<>(Arrays.asList(genres));
        //     genres_l.replaceAll(g->g.trim());
        //     return genres_l.contains("Comedy");
        // });

        // 7
        // all_filter.addFilter(new TrueFilter(5));
        // all_filter.addFilter((movie)->{
        //     int minutes = MovieDatabase.getMinutes(movie);
        //     return minutes>=105 && minutes<=135;
        // });

        // 8
        // String[] directors =  "Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack".trim().split(",");

        // ArrayList<String> director_list = new ArrayList<>(Arrays.asList(directors));
        // all_filter.addFilter(new TrueFilter(4));
        // all_filter.addFilter((movie)->{
        //     String[] director_movie = MovieDatabase.getDirector(movie).trim().split(",");
        //     for (String d : director_movie) {
        //         if(director_list.contains(d.trim())){return true;}
        //     }
        //     return false;
        // });

        // 9 
        // all_filter.addFilter(new TrueFilter(8));
        // all_filter.addFilter(new YearAfterFilter(1990));
        // all_filter.addFilter((s)->{
        //     String[] genres_a = MovieDatabase.getGenres(s).trim().split(",");
        //     ArrayList<String> genres = new ArrayList<>(Arrays.asList(genres_a));
        //     genres.replaceAll(g->g.trim());
        //     return genres.contains("Drama");
        // });


        // 10
        // String[] directors =  "Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack".trim().split(",");
        // ArrayList<String> director_list = new ArrayList<>(Arrays.asList(directors));    
        // all_filter.addFilter(new TrueFilter(3));
        // all_filter.addFilter((movie)->{return MovieDatabase.getMinutes(movie)>=90;});
        // all_filter.addFilter((movie)->{return MovieDatabase.getMinutes(movie)<=180;});
        // all_filter.addFilter((movie)->{
        //     String[] director_movie = MovieDatabase.getDirector(movie).trim().split(",");
        //     for (String d : director_movie) {
        //         if(director_list.contains(d.trim())){return true;}
        //     }
        //     return false;
        // });

        
        ArrayList<String> movie_list = MovieDatabase.filterBy(all_filter);
        System.out.println("Filtered number of movies: "+movie_list.size());
    }
 
    public static void main(String[] args) {
        questions();
    }

}
