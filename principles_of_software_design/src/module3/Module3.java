package module3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Module3{

    public static void main(String[] args) {
        QuakeSortInPlace qsi = new QuakeSortInPlace();
        String source = "principles_of_software_design/data/earthQuakeDataWeekDec6sample2.atom";
        ArrayList<QuakeEntry> eql = qsi.createCSV(source);
    
        // quiz 1
        // 1
        // qsi.sortByDepth(eql);
        // System.err.println(eql.get(49));

        // 2
        // qsi.sortByMagnitudeWithCheck(eql);
        
        // quize 2 
        // 1
        // Comparator<QuakeEntry> compare = (item1,item2)->{
        //     int r = Double.compare(item1.getMagnitude(),item2.getMagnitude());
        //     int result = (r!=0)? r : Double.compare(item1.getDepth(),item2.getDepth());
        //     return result;
        // };

        // 2
        // Comparator<QuakeEntry> compare = (item1,item2)->{
        //     int r = item1.getInfo().compareTo(item2.getInfo());
        //     int result = (r!=0)? r : -(Double.compare(item1.getDepth(),item2.getDepth()));
        //     return result;
        // };

        // 3
        // Comparator<QuakeEntry> compare = (item1,item2)->{
        //     String[] word_item1 = item1.getInfo().split(" ");
        //     String last_item1 = word_item1[word_item1.length-1];
        //     String[] word_item2 = item2.getInfo().split(" ");
        //     String last_item2 = word_item2[word_item2.length-1];
        //     int r = last_item1.compareTo(last_item2);
        //     int result = (r!=0)? r : Double.compare(item1.getMagnitude(),item2.getMagnitude());
        //     return result;
        // };

        // Collections.sort(eql,compare);
        // System.out.println(eql.get(0));
        // System.out.println(eql.get(48));
        // System.out.println(eql.get(50));
        // System.out.println("number is : "+eql.size());

        // last quiz
        // 1
        // qsi.sortByDepth(eql);
        // System.out.println(eql.getLast());
        
        //2
        // qsi.sortByMagnitudeWithCheck(eql);
        
        //3
        // qsi.sort_by_magnitude_bubble_sort_with_check(eql);

        //6
        // Comparator<QuakeEntry> compare = (item1,item2)->{
        //     int r = Double.compare(item1.getMagnitude(),item2.getMagnitude());
        //     int result = (r!=0)? r : Double.compare(item1.getDepth(),item2.getDepth());
        //     return result;
        // };

        // 7
        // Comparator<QuakeEntry> compare = (item1,item2)->{
        //     int r = item1.getInfo().compareTo(item2.getInfo());
        //     int result = (r!=0)? r : -(Double.compare(item1.getDepth(),item2.getDepth()));
        //     return result;
        // };

        // 8
        Comparator<QuakeEntry> compare = (item1,item2)->{
            String[] word_item1 = item1.getInfo().split(" ");
            String last_item1 = word_item1[word_item1.length-1];
            String[] word_item2 = item2.getInfo().split(" ");
            String last_item2 = word_item2[word_item2.length-1];
            int r = last_item1.compareTo(last_item2);
            int result = (r!=0)? r : Double.compare(item1.getMagnitude(),item2.getMagnitude());
            return result;
        };        


        Collections.sort(eql,compare);
        System.out.println(eql.get(0));
        System.out.println(eql.get(300));
        System.out.println(eql.get(500));
        // System.out.println("number is : "+eql.size());

    }
}