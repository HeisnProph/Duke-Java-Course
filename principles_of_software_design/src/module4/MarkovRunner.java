package module4;

import java.util.ArrayList;
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunner {

	public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runMarkovZero() {
		FileResource fr = new FileResource("principles_of_software_design/src/module4/data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		markov.setTraining(st);
		markov.setRandom(1024);
		for(int k=0; k < 1; k++){
			String text = markov.getRandomText(200);
			printOut(text);
		}
	}
	
	public void runMarkovWord(int markov_order, int seed,int numofWords) {
		FileResource fr = new FileResource("principles_of_software_design/src/module4/data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovWord markov = new MarkovWord(markov_order);
		markov.setTraining(st);
		markov.setRandom(seed);
		for(int k=0; k < 1; k++){
			String text = markov.getRandomText(numofWords);
			printOut(text);
		}
	}

	public void runMarkovWordOne(int markov_order, int seed,int numofWords) {
		FileResource fr = new FileResource("principles_of_software_design/src/module4/data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovWordOne markov = new MarkovWordOne();
		markov.setTraining(st);
		markov.setRandom(seed);
		for(int k=0; k < 1; k++){
			String text = markov.getRandomText(numofWords);
			printOut(text);
		}
	}

	public void runMarkovOne(int markov_order, int seed,int numofWords) {
		FileResource fr = new FileResource("principles_of_software_design/src/module4/data/romeo.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovOne markov = new MarkovOne(markov_order);
		markov.setTraining(st);
		markov.setRandom(seed);
		// markov.build_hashmap();
		// markov.print_hashmap();
		for(int k=0; k < 1; k++){
			String text = markov.getRandomText(numofWords);
			printOut(text);
		}
		
	}

	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
}
