package General_Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PoSFrequency implements FreqBuilder {

    //Class Variables
    private ArrayList<String> tags;
    private HashMap<String, Integer> pOSFreqMap;
    private Tagger tagger;
    private int frequency;

    public PoSFrequency() throws Exception{
        this.pOSFreqMap = new HashMap<String, Integer>();
        this.tags = new ArrayList<String>();
        this.tagger = new Tagger();
    }

    //This takes in an ArrayList of tokens, tags them, and computes frequency of tags.
    @Override
    public HashMap<String, Integer> buildFrequencyMap(ArrayList<String> tokens) {

        //first tag the tokens
        //UNCOMMENT NEXT LINE WHEN TAGGER IS IMPLEMENTED!!!!
        //this.tags = this.tagger.tag(tokens);

        //Determine frequency from tags ArrayList
        for(int i=0; i < tags.size(); i++){
            if(!this.pOSFreqMap.containsKey(tags.get(i))){
                this.pOSFreqMap.put(tags.get(i), 1);
            }
            else{
                this.pOSFreqMap.put(tags.get(i), this.pOSFreqMap.get(tags.get(i) + 1));
            }
        }
        return this.pOSFreqMap;

    }
    //This prints all POSs and their frequencies
    @Override
    public void printFrequencyMap() {
        for(String POS : this.pOSFreqMap.keySet()){
            this.frequency = this.pOSFreqMap.get(POS);
        System.out.println("Frequency of "+ POS + "is: " + this.frequency);

    }
}
    //This prints the frequency of just one specified POS
    public void getFrequency(String POS) {
        if(this.pOSFreqMap.containsKey(POS)){
            this.frequency = this.pOSFreqMap.get(POS);
        }
        else{
            this.frequency = 0;
        }
        System.out.println(this.frequency);
    }
}
