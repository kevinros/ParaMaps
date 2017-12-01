package General_Tools;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceTokenizer implements Tokenizer {

    private SentenceDetectorME sentenceDetector;
    private List<String> sentences;

    public SentenceTokenizer() throws Exception {
        File file = new File("src/models/en-sent.bin");
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        SentenceModel model = new SentenceModel(inputStream);
        sentenceDetector = new SentenceDetectorME(model);
        sentences = new ArrayList<>();
    }

    public void tokenize(String text) {
        String sentenceArr[] = sentenceDetector.sentDetect(text);
        this.sentences = Arrays.asList(sentenceArr);
    }

    public List getTokens() {
        return this.sentences;
    }
}
