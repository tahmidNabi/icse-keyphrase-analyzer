package com.tnob.nlp;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by tahmid on 12/2/15.
 */
public class SentenceParser {

    private SentenceModel model;
    private SentenceDetectorME detector;

    public SentenceParser(String modelPath) throws Exception {
        InputStream is = new FileInputStream("models/en-sent.bin");
        this.model = new SentenceModel(is);
        this.detector = new SentenceDetectorME(model);
    }

    public String[] detectSentences(String text) {
        return detector.sentDetect(text);
    }


}
