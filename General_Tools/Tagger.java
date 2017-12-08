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

    InputStream inputStream = new
            FileInputStream("C:/OpenNLP_models/en-pos-maxent.bin");
    POSModel model = new POSModel(inputStream);
    POSTaggerME tag = new POSTaggerME(model);

    //Returned a tagged array from a given sentence
    public String[] tag (String sentence) {
        //Tokenizing the sentence using WhitespaceTokenizer class
        WhitespaceTokenizer whitespaceTokenizer = WhitespaceTokenizer.INSTANCE;
        String[] tokens = whitespaceTokenizer.tokenize(sentence);

        //Generating tags
        String[] tags = tagger.tag(tokens);
        return tags;
    }
    





    }
