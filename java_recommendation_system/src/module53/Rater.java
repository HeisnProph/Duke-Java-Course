package module53;

import java.util.ArrayList;

public interface Rater {

    public boolean hasRating(String movie);

    public String getID(String movie);

    public double getRating(String movie);

    public int numRatings(String movie);

    public ArrayList<String> getItemsRated();


}
