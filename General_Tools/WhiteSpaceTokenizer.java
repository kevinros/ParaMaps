package General_Tools;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class WhiteSpaceTokenizer implements Tokenizer {
    // The WhiteSpaceTokenizer's purpose is to tokenize a String input based on OpenNLP's
    //  whitespace tokenizer model. (i.e. every word)

    // Class Variables
    private TokenizerME tokenizer;
    private ArrayList<String> tokens;

    // WhiteSpaceTokenizer() creates a tokenizer model and instantiates an ArrayList<String> to
    //  hold the tokenized tokens.
    public WhiteSpaceTokenizer() throws Exception {

        File file = new File("src/models/en-token.bin");
        InputStream inputStream = new FileInputStream(file);
        TokenizerModel tokenModel = new TokenizerModel(inputStream); // Loading the Tokenizer model
        this.tokenizer = new TokenizerME(tokenModel); // Instantiating the TokenizerME class
        this.tokens = new ArrayList<>();

    }

    // tokenize(String) takes in a String, in this case a sentence, and splits it by whitespace using
    //  the tokenizer.
    public void tokenize(String sentence) {
        String[] tokenArray = this.tokenizer.tokenize(sentence);
        this.tokens = new ArrayList<>(Arrays.asList(tokenArray));

    }

    // removePunctuation() removes any punctuation found in the token list.
    public void removePunctuations() {
        for (int i = 0; i < this.tokens.size(); i++) {
            // If our token is a punctuation mark, we want to remove it.
            if (Pattern.matches("\\p{Punct}", this.tokens.get(i))) {
                this.tokens.remove(i);
            }

        }
    }

    // getTokens() returns the list of tokens
    public ArrayList<String> getTokens() {
        return this.tokens;
    }

}

