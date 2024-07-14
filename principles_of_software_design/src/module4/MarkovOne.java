package module4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Write a description of class MarkovZero here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import java.util.Random;

import edu.duke.FileResource;

public class MarkovOne {
    private String myText;
	private Random myRandom;
	private int markov_order;
	private HashMap<String,ArrayList<Character>> follow_words;
	
	public MarkovOne(int markov_order) {
		myRandom = new Random();
		this.markov_order = markov_order;
		follow_words = new HashMap<>();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
		build_hashmap();
		print_hashmap();
	}

	public void build_hashmap(){
		for(int i=0; i<myText.length()-markov_order+1 ; i++){
			try {
				String key = myText.substring(i, i+markov_order);
				if(!follow_words.containsKey(key)){
					follow_words.put(key, new ArrayList<Character>(Arrays.asList(myText.charAt(i+markov_order))));
				}else{
					follow_words.get(key).add(myText.charAt(i+markov_order));
				}
			} catch (Exception e) {
				follow_words.put(myText.substring(i),new ArrayList<>());
			}
	
		}
	}

	public void print_hashmap(){
		System.out.println("key size: "+follow_words.size());
		int max = 0;
		for(ArrayList<Character> f_words : follow_words.values()){
			max = (f_words.size()>max)? f_words.size() : max;
		}
		System.out.println("max key size:: "+max);
	}
	
	public ArrayList<Character> getFollows(String key){
			ArrayList<Character> cls = new ArrayList<>();
			int i = 0;
			while(true){
					i = myText.indexOf(key, i) + markov_order;
					if(i==-1+markov_order || i >= myText.length()){break;}
					cls.add(myText.charAt(i));
			}
		return cls;
	}

	
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length()-markov_order);
		sb.append(myText.substring(index, index+markov_order));
		for(int k=0; k < numChars-markov_order; k++){
			String key = sb.substring(sb.length()-markov_order);
		    ArrayList<Character> follows = getFollows(key);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			char next = follows.get(index);
			sb.append(next);
		}
		return sb.toString();
	}


}
