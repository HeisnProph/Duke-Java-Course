package module4;

import java.util.*;

public class MarkovWord implements IMarkovModel
{
    private String[] myText;
    private int myOrder;
    private Random myRandom;
    private HashMap<WordGram,ArrayList<String>> follow_words;

    public MarkovWord(int order)
    {
        myRandom = new Random();
        myOrder = order;
        follow_words = new HashMap<>();
    }

    public void setRandom(int seed)
    {
        myRandom = new Random(seed);
    }

    public void setTraining(String text)
    {
        if (text != null && ! text.isEmpty())
            myText = text.split("\\s+");
        build_hashmap();
        print_hashmap();
    }

    public String toString()
    {
        return "MarkovWord of order "+myOrder;
    }

    
    public void build_hashmap(){
		for(int i=0; i<myText.length-myOrder+1 ; i++){
            WordGram key = new WordGram(myText, i, myOrder);
			try {
				if(!follow_words.containsKey(key)){
					follow_words.put(key, new ArrayList<String>(Arrays.asList(myText[i+myOrder])));
				}else{
					follow_words.get(key).add(myText[i+myOrder]);
				}
			} catch (Exception e) {
                if(follow_words.containsKey(key)){
                    break;
                } else{
				    follow_words.put(key,new ArrayList<>());
                }
			}
	
		}
	}

	public void print_hashmap(){
		System.out.println("Text length: "+myText.length+", key size: "+follow_words.size());
		int max = 0;
		for(ArrayList<String> f_words : follow_words.values()){
			max = (f_words.size()>max)? f_words.size() : max;
		}
		System.out.println("max key size:: "+max);
	}

    public void test_print_hashmap(){
        for(WordGram item : follow_words.keySet()){
            System.err.println("("+item+") :"+follow_words.get(item).toString());
        }
    }

    public String getRandomText(int numWords)
    {
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);
        // int index = myRandom.nextInt(myText.length);
        // String[] initialKeys = new String[myOrder]; 
        // for (int k=0; k < myOrder; k++)
        // {
        //     initialKeys[k] = myText[index+k];
        //     sb.append(initialKeys[k]).append(" ");
        // }
        WordGram key = new WordGram(myText, index, myOrder);
        sb.append(key.toString()).append(" ");

        for(int k=0; k < numWords-myOrder; k++)
        {
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0)
            {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = key.shiftAdd(next);
        }
        return sb.toString().trim();
    }

    private int indexOf (String[] words, WordGram target, int start)
    {
        for (int k = start; k <= words.length-target.length(); k++)
        {
            WordGram wg = new WordGram(words, k, target.length());
            if (wg.equals(target))
            {
                return k;
            }
        }
        return -1;
    }

    public void testIndexOf()
    {
        String[] words = "this is just a test yes this is a simple test".split("\\s+");
        WordGram t1 = new WordGram("this is".split("\\s+"), 0, 2);
        System.out.println("should be 0: "+indexOf(words, t1, 0));
        System.out.println("should be 6: "+indexOf(words, t1, 3));
        WordGram frog = new WordGram("frog".split("\\s+"), 0, 1);
        System.out.println("should be -1: "+indexOf(words, frog, 0));
        System.out.println("should be -1: "+indexOf(words, frog, 5));
        WordGram simple = new WordGram("simple test".split("\\s+"), 0, 2);
        System.out.println("should be 9: "+indexOf(words, simple, 2));
        WordGram test = new WordGram("test".split("\\s+"), 0, 1);
        System.out.println("should be 10: "+indexOf(words, test, 5));
    }

    private ArrayList<String> getFollows(WordGram kGram) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        int kGramLength = kGram.length();
        while (pos < myText.length - kGramLength)
        {
            int start = indexOf(myText, kGram, pos);
            if (start == -1)
            {
                break;
            }
            if (start + kGramLength >= myText.length)
            {
                break;
            }
            follows.add(myText[start+kGramLength]);
            pos = start+kGramLength;
        }
        return follows;
    }

    public void test_getFollows(String t){
        ArrayList<String> temp = new ArrayList<>();
        String[] temps = {t};
        WordGram tempGram = new WordGram(temps, 0, 1);
        temp = getFollows(tempGram);
        System.out.println(temp.size());
    }
}