package module2;
import java.util.ArrayList;


public class Module2 {
    public static void main(String[] args) {
        EarthQuakeClient eqc = new EarthQuakeClient();
        eqc.createCSV("Principles_of_Software_Design/Modules/data/nov20quakedata.atom");
        // Quiz 1
        // ArrayList<QuakeEntry> ans = eqc.filterByDepth();
        // System.err.println(ans.size());
        // ArrayList<QuakeEntry> ans = eqc.filterByPhrase();
        // System.err.println(ans.size());
        //eqc.findLargestQuakes();

        //Quiz 2
        // Location tokyo = new Location(35.42,139.43);
        // eqc.qlist = eqc.filterByDistanceFrom(eqc.qlist, 10000000, tokyo);
        // ArrayList<QuakeEntry> ans = eqc.filterByPhrase();
        // System.err.println(ans.size());

        
        // ArrayList<QuakeEntry> ans = eqc.filterByMagnitude(eqc.qlist , 0.0 , 2.0);
        // ans = eqc.filterByDepth(ans, -100000, -10000);
        // ans = eqc.filterByPhrase(ans, "a", "any");
        // System.err.println(ans.size());

        // ArrayList<QuakeEntry> ans = eqc.filterByMagnitude(eqc.qlist , 0.0 , 3.0);
        // Location Oklahoma = new Location(36.1314, -95.9372);
        // ans = eqc.filterByDistanceFrom(ans, 10000000, Oklahoma);
        // ans = eqc.filterByPhrase(ans, "Ca", "any");
        // System.err.println(ans.size());

        // Final Quize
        // ArrayList<QuakeEntry> ans = eqc.filterByDepth(eqc.qlist , -4000 , -2000);
        // System.err.println(ans.size());

        // ArrayList<QuakeEntry> ans = eqc.filterByPhrase(eqc.qlist, "Quarry Blast", "start");
        // System.err.println(ans.size());

        // eqc.findLargestQuakes(50);

        ArrayList<QuakeEntry> ans = eqc.filterByPhrase(eqc.qlist, "a", "end");;
        Location Oklahoma = new Location(39.7392, -104.9903);
        ans = eqc.filterByDistanceFrom(ans, 1000000, Oklahoma);
        System.err.println(ans.size());

        // ArrayList<QuakeEntry> ans = eqc.filterByMagnitude(eqc.qlist , 0.0-0.1 ,5.0+0.1);
        // // ans = eqc.filterByDepth(ans, -180000-1, -30000+1);
        // Location Oklahoma = new Location(55.7308, 9.1153);
        // ans = eqc.filterByDistanceFrom(ans, 3000000, Oklahoma);
        // ans = eqc.filterByPhrase(ans, "e", "any");
        // System.err.println(ans.size());
    }

}
