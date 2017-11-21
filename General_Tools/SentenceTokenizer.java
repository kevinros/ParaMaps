package General_Tools;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class SentenceTokenizer implements Tokenizer {

    private TokenizerME tokenizer;
    private ArrayList<String> tokens;

    public SentenceTokenizer() throws Exception {

        File file = new File("src/models/en-token.bin");
        InputStream inputStream = new FileInputStream(file);
        TokenizerModel tokenModel = new TokenizerModel(inputStream); // Loading the Tokenizer model
        this.tokenizer = new TokenizerME(tokenModel); // Instantiating the TokenizerME class

    }

    public void tokenize(String sentence) {
        String[] tokenArray = this.tokenizer.tokenize(sentence);
        this.tokens = new ArrayList<String>(Arrays.asList(tokenArray));
    }

    public void removePunctuations() {
        for (int i = 0; i < this.tokens.size(); i++) {
            if (Pattern.matches("\\p{Punct}", this.tokens.get(i))) {
                this.tokens.remove(i);
            }

        }
    }

    public ArrayList<String> getTokens() {
        return this.tokens;
    }

}

