package General_Tools;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WhiteSpaceTokenizer implements Tokenizer {

    private TokenizerME tokenizer;
    private List<String> tokens;

    public WhiteSpaceTokenizer() throws Exception {

        File file = new File("src/models/en-token.bin");
        InputStream inputStream = new FileInputStream(file);
        TokenizerModel tokenModel = new TokenizerModel(inputStream); // Loading the Tokenizer model
        this.tokenizer = new TokenizerME(tokenModel); // Instantiating the TokenizerME class
        this.tokens = new ArrayList<>();

    }

    public void tokenize(String sentence) {
        String[] tokenArray = this.tokenizer.tokenize(sentence);
        this.tokens = Arrays.asList(tokenArray);

    }

    public void removePunctuations() {
        for (int i = 0; i < this.tokens.size(); i++) {
            // Because we our set of tokens is of type List, we need to cast it for the Pattern.matches()
            //  method
            if (Pattern.matches("\\[!\"#$%&'*+,-./:;<=>?@[]^_`{|}~]", (String)this.tokens.get(i))) {
                this.tokens.remove(i);
            }

        }
    }

    public List getTokens() {
        return this.tokens;
    }

}

