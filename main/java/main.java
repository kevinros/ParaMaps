package main.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import General_Tools.*;


public class main {

    public static void main(String[] args) throws Exception {

        WhiteSpaceTokenizer tokenizer = new WhiteSpaceTokenizer();
        WordFrequency wordFrequency = new WordFrequency();
        String filePath = "src/StringInput.txt";
        String newSentence = new String(Files.readAllBytes(Paths.get(filePath)));
        ArrayList<String> tokens;

        tokenizer.tokenize(newSentence);
        tokenizer.removePunctuations();
        tokens = tokenizer.getTokens();

        wordFrequency.findFrequency(tokens);
        wordFrequency.printFrequencyMap();

        //System.out.println(System.getProperty("user.dir"));



    }


}

