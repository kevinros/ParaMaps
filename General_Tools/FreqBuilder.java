package General_Tools;

import java.util.ArrayList;
import java.util.HashMap;

public interface FreqBuilder {

    public HashMap<String, Integer> buildFrequencyMap(ArrayList<String> tokens);
    public void printFrequencyMap();
}


