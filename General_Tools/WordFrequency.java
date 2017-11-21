package General_Tools;

import java.util.HashMap;
import java.util.List;

public class WordFrequency {

    private HashMap<String, Integer> frequencyMap;

    public WordFrequency() {

        this.frequencyMap = new HashMap<String, Integer>();

    }

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

    public void printFrequencyMap() {
        for (String token : this.frequencyMap.keySet()) {
            System.out.printf("%s : %d\n", token, this.frequencyMap.get(token));
        }
    }

}
