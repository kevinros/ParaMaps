package General_Tools;

import java.util.HashMap;
import java.util.List;

public class WordFrequency {

    private HashMap<String, Integer> frequencyMap;

    // Constructor
    public WordFrequency() {

        this.frequencyMap = new HashMap<String, Integer>();

    }

    // findFrequency() takes in a list of Strings and records the frequency of their occurance in
    //  a HashMap
    public void findFrequency(List<String> tokens) {

        this.frequencyMap.clear(); // Allows findFrequency to be reusable. Therefore, only one
        // object of WordFrequency needs to be instantiated.

        for (int i = 0; i < tokens.size(); i++) {
            if (!this.frequencyMap.containsKey(tokens.get(i).toLowerCase())) {
                this.frequencyMap.put(tokens.get(i).toLowerCase(), 1);
            } else {
                this.frequencyMap.put(tokens.get(i).toLowerCase(), this.frequencyMap.get(tokens.get(i).toLowerCase())+1);
            }
        }

    }
    // printFrequency() prints out the contents of frequencyMap in the form <String> : <frequency (int)>
    public void printFrequencyMap() {
        for (String token : this.frequencyMap.keySet()) {
            System.out.printf("%s : %d\n", token, this.frequencyMap.get(token));
        }
    }

}
