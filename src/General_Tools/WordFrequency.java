package General_Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordFrequency implements FreqBuilder{
    // The WordFrequency's purpose is to map how many times each token occurs in a String input.

    // Class Variables
    private HashMap<String, Integer> frequencyMap;

    // WordFrequency() instantiates an empty HashMap<String, Integer> which will hold the frequency
    //  for each String token.
    public WordFrequency() {

        this.frequencyMap = new HashMap<String, Integer>();

    }

    // findFrequency(List<String>) takes in a list of Strings and records the frequency of their occurrence in
    //  a HashMap
    @Override
    public HashMap<String, Integer> buildFrequencyMap(ArrayList<String> tokens) {

        this.frequencyMap.clear(); // Allows findFrequency to be reusable. Therefore, only one
        // object of WordFrequency needs to be instantiated.

        for (int i = 0; i < tokens.size(); i++) {
            if (!this.frequencyMap.containsKey(tokens.get(i).toLowerCase())) {
                this.frequencyMap.put(tokens.get(i).toLowerCase(), 1);
            } else {
                this.frequencyMap.put(tokens.get(i).toLowerCase(), this.frequencyMap.get(tokens.get(i).toLowerCase())+1);
            }
        }

        return this.frequencyMap;

    }

    // printFrequency() prints out the contents of frequencyMap in the form <String> : <frequency (int)>
    @Override
    public void printFrequencyMap() {
        for (String token : this.frequencyMap.keySet()) {
            System.out.printf("%s : %d\n", token, this.frequencyMap.get(token));
        }
    }

}
