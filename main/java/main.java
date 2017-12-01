package main.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import General_Tools.*;


public class main {

    public static void main(String[] args) throws Exception {

        SentenceTokenizer sTokenizer = new SentenceTokenizer();
        WhiteSpaceTokenizer wsTokenizer = new WhiteSpaceTokenizer();
        WordFrequency wordFrequency = new WordFrequency();
        String filePath = "src/StringInput.txt";
        String newSentence = new String(Files.readAllBytes(Paths.get(filePath)));
        List sentences;
        List tokens = new ArrayList<>();

        sTokenizer.tokenize(newSentence);
        sentences = sTokenizer.getTokens();

        for (Object s : sentences) {
            wsTokenizer.tokenize((String)s);
            wsTokenizer.removePunctuations();
            tokens.addAll(wsTokenizer.getTokens());
        }



        wordFrequency.findFrequency(tokens);
        wordFrequency.printFrequencyMap();
        System.out.println("----------------------");

        for (Object s : sentences) {
            System.out.println(s);
        }

        //System.out.println(System.getProperty("user.dir"));



    }


}

