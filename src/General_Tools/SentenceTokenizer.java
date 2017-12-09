package General_Tools;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class SentenceTokenizer implements Tokenizer {
    // The SentenceTokenizer's purpose is to tokenize a String input based on OpenNLP's
    //  sentence tokenizer model. (i.e. sentence; after sentence-ending punctuations)

    // Class Variables
    private SentenceDetectorME sentenceDetector;
    private ArrayList<String> sentences;

    // SentenceTokenizer() creates a sentenceDetector model and instantiates an ArrayList<String> to
    //  hold the tokenized sentences.
    public SentenceTokenizer() throws Exception {
        File file = new File("src/models/en-sent.bin");
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        SentenceModel model = new SentenceModel(inputStream);
        sentenceDetector = new SentenceDetectorME(model);
        sentences = new ArrayList<>();
    }

    // tokenize(String) takes in a String input and tokenizes it by sentences.
    public void tokenize(String text) {
        String sentenceArr[] = sentenceDetector.sentDetect(text);
        this.sentences = new ArrayList<>(Arrays.asList(sentenceArr));
    }

    // getTokens() returns the list of sentences.
    public ArrayList<String> getTokens() {
        return this.sentences;
    }
}
