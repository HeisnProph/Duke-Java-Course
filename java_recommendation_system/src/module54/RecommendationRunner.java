/**
 * @Description: 
 * @Aurthor: heisnproph
 * @Date: Jul 14, 2024
 */ 

package module54;

import java.util.ArrayList;
import java.util.Collections;

import module51.Rating;
import module53.MovieDatabase;

/**
 * @description:
 * @author: heisnproph
 */
public class RecommendationRunner implements Recommender{

    @Override
    public ArrayList<String> getItemsToRate() {
        ArrayList<String> result_list = new ArrayList<>();
        ArrayList<Rating> temp_list = new ArrayList<>();
        ArrayList<String> all_movies_id = MovieDatabase.filterBy(s->true);
        for(String movie_id : all_movies_id){
            double rating = MovieDatabase.get_rating(movie_id);
            temp_list.add(new Rating(movie_id, rating));
        }
        Collections.sort(temp_list,Collections.reverseOrder()); 
        for(int i=0; i<20 ; i++ ){
            String id = temp_list.get(i).get_id();
            String movie = MovieDatabase.getTitle(id);
            result_list.add(movie);
        }
        
        return result_list;
    }

    @Override
    public void printRecommendationsFor(String webRaterID) {
        FourthRating fr = new FourthRating();
        ArrayList<Rating> rating_list = fr.get_similar_ratings(webRaterID, 20, 5);
        if(rating_list.size() == 0){
            System.out.println("<h2>Sorry, there are no movie recommend for you based on your rating!</h2>");
        }else{
            ArrayList<String> movieToBeRate = getItemsToRate();
            ArrayList<Rating> outID = new ArrayList<>();
            int count = 0;
            for (int i = 0; outID.size() + count != rating_list.size() && outID.size() < 10; i++) {
                if (!movieToBeRate.contains(rating_list.get(i).get_id())) {
                    outID.add(rating_list.get(i));
                    //System.out.println("i = " + i + " id = " + ratingList.get(i).getItem());
                    
                } else {
                    count++;
                }
            }
            System.out.println("outid size = " + outID.size());
            
            
            System.out.println("<style>");
            System.out.println("h2,h3{");
            System.out.println("  text-align: center;");
            System.out.println("  height: 50px;");
            System.out.println("  line-height: 50px;");
            System.out.println("  font-family: Arial, Helvetica, sans- serif;");
            System.out.println("  background-color: black;");
            System.out.println("   color:  #ff6600 }");
            
            System.out.println(" table {");
            System.out.println("   border-collapse: collapse;");
            System.out.println("   margin: auto;}");
            System.out.println("table, th, td {");
            System.out.println("    border: 2px solid white;");
            System.out.println("    font-size: 15px;");
            
            System.out.println("    padding: 2px 6px 2px 6px; }");
            System.out.println(" td img{");
            System.out.println("    display: block;");
            System.out.println("    margin-left: auto;");
            System.out.println("    margin-right: auto; }");
            System.out.println("th {");
            System.out.println("    height: 40px;");
            System.out.println("    font-size: 18px;");
            
            System.out.println("  background-color: black;");
            System.out.println(" color: white;");
            System.out.println("text-align: center; }");
            
            System.out.println(" tr:nth-child(even) {");
            System.out.println("     background-color: #f2f2f2; }");
            System.out.println("  tr:nth-child(odd) {");
            System.out.println("background-color: #cccccc; }");
            System.out.println(" tr:hover {");
            System.out.println(" background-color: #666666; ");
            System.out.println("  color:white;}");
            
            System.out.println("table td:first-child {");
            System.out.println(" text-align: center; }");
            
            System.out.println(" tr {");
            System.out.println(" font-family: Arial, Helvetica, sans-serif; }");
            System.out.println(".rating{");
            System.out.println("    color:#ff6600;");
            System.out.println("    padding: 0px 10px;");
            System.out.println("   font-weight: bold; }");
            System.out.println("</style>");
            
            
            System.out.println("<h2>Wei Xu Brings Best Movies for You! Enjoy!^^</h2>");
            System.out.println("<table id = \"rater\">");
            System.out.println("<tr>");
            System.out.println("<th>Rank</th>");
            
            System.out.println("<th>Poster</th>");
            System.out.println("<th>Title & Rating</th>");
            System.out.println("<th>Genre</th>");
            System.out.println("<th>Country</th>");
            System.out.println("</tr>");
            
            //https://www.imdb.com/title/tt0780622/
            //make title chickable
            //<td><a href="https://developer.mozilla.org/en-US/docs/Web/CSS/Reference" >Hello World</a></td>
            //"<a href="https://www.imdb.com/title/tt"+movie.id+"\">"+ movie.title+"</a></td>
            int rank = 1;
            for (Rating i : outID) {
                System.out.println("<tr><td>" + rank + "</td>" +
                        
                        "<td><img src = \"" + MovieDatabase.getPoster(i.get_id()) + "\" width=\"50\" height=\"70\"></td> " +
                        "<td>" + MovieDatabase.getYear(i.get_id()) + "&ensp;&ensp; <a href=\"https://www.imdb.com/title/tt" +
                        i.get_id() + "\">" + MovieDatabase.getTitle(i.get_id()) + "</a><br><div class = \"rating\">&starf; &ensp;&ensp;&ensp;"
                        + String.format("%.1f", i.get_value()) + "/10</td>" +
                        "<td>" + MovieDatabase.getGenres(i.get_id()) + "</td>" +
                        "<td>" + MovieDatabase.getCountry(i.get_id()) + "</td>" +
                        "</tr> ");
                rank++;
            }
        }
        System.out.println("</table>");
        System.out.println("<h3>*The rank of movies is based on other raters who have the most similar rating to yours. Enjoy!^^</h3>");
    
    }

    public static void main(String[] args) {
        RecommendationRunner a = new RecommendationRunner();
        a.printRecommendationsFor("50");

    }
    
    

}
