package module4;

import java.util.ArrayList;

import edu.duke.FileResource;

public class Module4 {
    public static void main(String[] args) {

        // quiz 1
        // 2
        // MarkovRunner mr = new MarkovRunner();
        // mr.runMarkovZero();

        // 3 4
        // FileResource fr = new FileResource("principles_of_software_design/src/module4/data/melville.txt");
        // FileResource fr = new FileResource("principles_of_software_design/src/module4/data/confucius.txt");
		// String st = fr.asString();
		// st = st.replace('\n', ' ');
		// MarkovOne markov = new MarkovOne();
		// markov.setTraining(st);
        // ArrayList<Character> answer = markov.getFollows("T");
        // System.out.println(answer.size());

        // 5
        // MarkovRunner mr = new MarkovRunner();
        // mr.runMarkovOne(5,615,200); 

        // quiz 2
        // MarkovRunner mr = new MarkovRunner();
        // mr.runMarkovWord(5, 844, 60);

        // 3
        // FileResource fr = new FileResource("principles_of_software_design/src/module4/data/confucius.txt");
		// String st = fr.asString();
        // String test = "this is a test yes this is really a test";
		// st = st.replace('\n', ' ');
        // st = st.trim();
		// MarkovWord markov = new MarkovWord(3);
		// markov.setTraining(st);
        // markov.setRandom(65);
        // markov.build_hashmap();
        // markov.print_hashmap();
        // markov.test_print_hashmap();

        // final
        // MarkovRunner mr = new MarkovRunner();
        // mr.runMarkovZero(); 

        // 3
        // FileResource fr = new FileResource("principles_of_software_design/src/module4/data/confucius.txt");
		// String st = fr.asString();
        // String test = "this is a test yes this is really a test";
		// st = st.replace('\n', ' ');
        // st = st.trim();
		// // MarkovWord markov = new MarkovWord(3);
        // MarkovOne markov = new MarkovOne(1);
		// markov.setTraining(st);
        // markov.setRandom(65);
        // ArrayList<Character> follow_1 = markov.getFollows("he");
        // System.out.println(follow_1.size());
        // markov.build_hashmap();
        // markov.print_hashmap();
        // markov.test_print_hashmap();


        // 5
        // MarkovRunner mr = new MarkovRunner();
        // mr.runMarkovOne(7,953,200); 

        // 9
        FileResource fr = new FileResource("principles_of_software_design/src/module4/data/confucius.txt");
		String st = fr.asString();
        String test = "this is a test yes this is really a test";
		st = st.replace('\n', ' ');
        st = st.trim();
		// MarkovWord markov = new MarkovWord(3);
        MarkovOne markov = new MarkovOne(5);
        markov.setRandom(531);
		markov.setTraining(st);
        // ArrayList<Character> follow_1 = markov.getFollows("he");
        // System.out.println(follow_1.size());
        // markov.build_hashmap();
        // markov.print_hashmap();
        // markov.test_print_hashmap();


    }
}
