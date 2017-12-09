package General_Tools;
import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
//The following is based on OpenNLP online tutorial
// for tagging parts of speech


public class Tagger {
    //class variables
    private POSTaggerME tagger;
    private POSModel model;

    public Tagger() throws Exception {
        InputStream inputStream = new
                FileInputStream("src/models/en-pos-maxent.bin");
        this.model = new POSModel(inputStream);
        this.tagger = new POSTaggerME(model);
    }
    //Returned a tagged array from a given sentence
    public String[] tagSentence (String sentence) {
        //Tokenizing the sentence using WhitespaceTokenizer class
        WhitespaceTokenizer whitespaceTokenizer = WhitespaceTokenizer.INSTANCE;
        String[] tokens = whitespaceTokenizer.tokenize(sentence);

        //Generating tags
        String[] tags = tagger.tag(tokens);
        return tags;
    }




    }
