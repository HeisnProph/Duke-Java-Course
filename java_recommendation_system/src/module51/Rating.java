package  module51;
// An immutable passive data object (PDO) to represent the rating data
public class Rating implements Comparable<Rating> {
    private String id;
    private double value;

    /**
     * @param id
     * @param value
     */
    public Rating (String id, double value) {
        this.id = id;
        this.value = value;
    }

    // Returns item being rated
    public String get_id () {
        return id;
    }

    // Returns the value of this rating (as a number so it can be used in calculations)
    public double get_value () {
        return value;
    }

    // Returns a string of all the rating information
    public String toString () {
        return "[" + get_id() + ", " + get_value() + "]";
    }

    public int compareTo(Rating other) {
        if (value < other.value) return -1;
        if (value > other.value) return 1;
        
        return 0;
    }
}
