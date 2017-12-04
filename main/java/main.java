package main.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Box_Tools.Box;
import Box_Tools.BoxBuilder;
import General_Tools.*;


public class main {

    public static void main(String[] args) throws Exception {

        SentenceTokenizer sTokenizer = new SentenceTokenizer();
        WhiteSpaceTokenizer wsTokenizer = new WhiteSpaceTokenizer();
        WordFrequency wordFrequency = new WordFrequency();
        String filePath = "src/StringInput.txt";
        String newSentence = new String(Files.readAllBytes(Paths.get(filePath)));
        ArrayList<String> sentences;
        ArrayList<String> tokens = new ArrayList<>();
        Map freqMap = new HashMap<>();

        sTokenizer.tokenize(newSentence);
        sentences = sTokenizer.getTokens();

        for (Object s : sentences) {
            wsTokenizer.tokenize((String)s);
            wsTokenizer.removePunctuations();
            tokens.addAll(wsTokenizer.getTokens());
        }



        freqMap = wordFrequency.buildFrequencyMap(tokens);
        wordFrequency.printFrequencyMap();
        System.out.println("----------------------");

        for (Object s : sentences) {
            System.out.println(s);
        }

        //System.out.println(System.getProperty("user.dir"));

        System.out.println("----------------------");
        System.out.println("Testing Box Class Functionality");
        System.out.println("----------------------");

        // Instantiating ArrayList<Box> to hold our boxes
        //  Also instantiating a BoxBuilder that will create boxes.
        ArrayList<Box> boxes = new ArrayList<>();
        BoxBuilder boxBuilder = new BoxBuilder();

        // List of subjects, which will be heads
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Saturn");
        subjects.add("Mars");
        subjects.add("Venus");
        subjects.add("Jupiter");
        subjects.add("Uranus");

        // List of descriptions, which will be the body.
        ArrayList<String> descriptions = new ArrayList<>();
        descriptions.add("is a planet.");
        descriptions.add("is 3000 feet.");
        descriptions.add("is blue.");
        descriptions.add("is in the sky.");

        // For each subject, let's create a box and add the description
        for (String s : subjects) {

            Box box = boxBuilder.buildBox(s, descriptions);
            boxes.add(box);

        }

        // Print
        for (Box b : boxes) {
            b.printBoxContents();
        }





    }


}

