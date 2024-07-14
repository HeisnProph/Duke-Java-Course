package module3;

/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;


public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    // Chech if sorted by magnitude
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> ls){
        for(int i=0; i<ls.size()-1;i++){
            if(ls.get(i).getMagnitude()>ls.get(i+1).getMagnitude()){
                return false;
            }
        }
        return true;
    }
    // Sort by depth
    public int getLargetDepth(ArrayList<QuakeEntry> quakes, int from) {
        int maxIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getDepth() > quakes.get(maxIdx).getDepth()) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    public void sortByDepth(ArrayList<QuakeEntry> in) {
       
        for (int i=0; i<70; i++) {
             int maxIdx = getLargetDepth(in,i);
             QuakeEntry qi = in.get(i);
             QuakeEntry qmax = in.get(maxIdx);
             in.set(i,qmax);
             in.set(maxIdx,qi);
         }
         
     }
     


    
    
    // Sort by magnitude
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }

    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
        for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            if(checkInSortedOrder(in)){
                System.out.println("times: "+(i+1));
                break;
            }
        }
    }

    public void sort_by_magnitude_bubble_sort_with_check(ArrayList<QuakeEntry> in){
        int n = in.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (in.get(j).getMagnitude() > in.get(j + 1).getMagnitude()) {
                    // Swap elements
                    QuakeEntry temp = in.get(j);
                    in.set(j, in.get(j + 1));
                    in.set(j + 1, temp);
                }   
            }
            if(checkInSortedOrder(in)){
                System.out.println("times: "+(i+1));
                break;
            }
        }
    }


    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        sortByMagnitude(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
    
    public ArrayList<QuakeEntry> createCSV(String source) {
        EarthQuakeParser parser = new EarthQuakeParser();
        // String source = "data/nov20quakedata.atom";
        // String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        // dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        return list;
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
}
