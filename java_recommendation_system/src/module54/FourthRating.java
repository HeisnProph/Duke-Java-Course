/**
 * @Description: 
 * @Aurthor: heisnproph
 * @Date: Jul 13, 2024
 */ 

package module54;

import java.util.ArrayList;
import java.util.Collections;

import module51.Rating;
import module53.Filter;
import module53.MovieDatabase;

/**
 * @description:
 * @author: heisnproph
 */
public class FourthRating {

    /**
     * @param me your rater object
     * @param other other rater object
     * @return dot production of these two rater-objects' rated movie
     */
    private double dot_product(Rater me, Rater other){
        double dot_production = 0;
        for(String id : me.getItemsRated()){
            if(other.getItemsRated().contains(id)){
                dot_production += (me.getRating(id)-5.0)*(other.getRating(id)-5.0);
            }
        }
        return dot_production;
    }


    /**
     * @param id rater id
     * @return 
     */
    private ArrayList<Rating> get_similarities(String id){
        Rater me = RaterDatabase.getRater(id);
        ArrayList<Rating> similarity_list = new ArrayList<>();
        for(Rater other : RaterDatabase.getRaters()){
            if(!other.getID().equals(id)){
                double dp = dot_product(me, other);
                if(dp>0){
                    similarity_list.add(new Rating(other.getID(), dp));
                }
            }
        }
        Collections.sort(similarity_list,Collections.reverseOrder());
        return similarity_list;
    }

    /**
     * @param id
     * @param num_raters
     * @param minimal_rater
     * @return
     */
    public ArrayList<Rating> get_similar_ratings(String id, int num_raters, int minimal_rater){
        ArrayList<Rating> similarity = get_similarities(id);
        ArrayList<Rating> similar_list = new ArrayList<>();
        for(String movie_id : MovieDatabase.filterBy(s->true)){
            double weighted_rating = 0;
            double count = 0;
            for(int i=0; i<num_raters;i++){
                Rater rater = RaterDatabase.getRater(similarity.get(i).get_id());
                if(rater.hasRating(movie_id)){
                    double weight = similarity.get(i).get_value();
                    weighted_rating+=weight*rater.getRating(movie_id);
                    count += 1;
                };
            }
            if(count >= minimal_rater) similar_list.add(new Rating(movie_id,(weighted_rating/count)));
        }
        Collections.sort(similar_list, Collections.reverseOrder());
        
        return similar_list;
    }

    public ArrayList<Rating> get_similar_ratings_filtered(Filter filter,String id, int num_raters, int minimal_rater){
        ArrayList<String> filtered_movies = MovieDatabase.filterBy(filter);
        ArrayList<Rating> similar_rating_list = get_similar_ratings(id, num_raters, minimal_rater);
        ArrayList<Rating> result = new ArrayList<>();
        for(Rating r : similar_rating_list){
            if(filtered_movies.contains(r.get_id())){
                result.add(r);
            }
        }
        return result;
    }

}
