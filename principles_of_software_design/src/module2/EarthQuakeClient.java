package module2;

import java.util.*;

import edu.duke.*;

public class EarthQuakeClient {

    public ArrayList<QuakeEntry> qlist;
    

    // Filter by Magnitude
    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        //TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }
        return answer;              
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin , double magMax) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        //TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude()>magMin && qe.getMagnitude()<magMax) {
                answer.add(qe);
            }
        }
        return answer;              
    }
    
    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {      
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        }
        return answer;
    }
    
    
    // Filter by depth
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> ls, double minDepth , double maxDepth) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO

        for(QuakeEntry item : ls){
            if(item.getDepth()>minDepth && item.getDepth()<maxDepth){
                answer.add(item);
            }
        }

        return answer;
    }

    // Filter by phrase
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> ls, String phrase, String position){
      
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        interface filterRule{
            Boolean rule(String str,String phrase);
        }
        filterRule filter;
        switch (position) {
            case "start": 
                filter = (str,ph) -> str.startsWith(ph);
                break;
            case "end":
                filter = (str,ph) -> str.endsWith(ph);
                break;
            case "any":
                filter = (str,ph) -> str.contains(ph);
                break;
            default:
                filter = null;
                break;
        }
     
        for(QuakeEntry item : ls){
            if(filter.rule(item.getInfo(), phrase)){
                answer.add(item);
            }
        }
        
        return answer;
    }
    

    public void findLargestQuakes(int index){
        ArrayList<Double> order = new ArrayList<>();
        for(QuakeEntry item : qlist){
            order.add(item.getMagnitude());
        }
        order.sort(null);
        for(int i=0 ; i<index ; i++){
            System.out.println(order.get(order.size()-i-1));
        }

    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
	
	public void bigQuakes() {
	    EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "Principples of Software Design/Modules/data/nov20quakedata.atom";
        qlist = parser.read(source);
        // System.out.println("read data for " + qlist.size() + " quakes");
        /*
        for (QuakeEntry qe : list) {
            if (qe.getMagnitude() > 5.0) {
                System.out.println(qe);
            }
        }
        */
        ArrayList<QuakeEntry> listBig = filterByMagnitude(qlist, 5.0);
        for (QuakeEntry qe : listBig) {
           System.out.println(qe); 
        }
	}
	
    public void createCSV(String source){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        this.qlist = parser.read(source);
        System.out.println("# quakes read: " + qlist.size());
    }
    
    public void closeToMe() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: " + list.size());
        
        //Durham, NC
        //Location city = new Location(35.988, -78.907);
        //Bridgeport, CA
        Location city = new Location(38.17, -118.82);
        ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000*1000, city);
        for (int k=0; k< close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }

    }
}
