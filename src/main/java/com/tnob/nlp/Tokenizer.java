package com.tnob.nlp;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tahmid on 12/2/15.
 */
public class Tokenizer {

    private TokenizerModel model;
    private TokenizerME tokenizer;

    public Tokenizer(String modelPath) throws Exception{

        InputStream is = new FileInputStream(modelPath);
        model = new TokenizerModel(is);
        tokenizer = new TokenizerME(model);

    }

    public String [] getTokens(String sentence) {
        return tokenizer.tokenize(sentence);
    }

    public List<String []> getTokens (String [] sentences) {

        List<String[]> listOfTokens = new ArrayList<String[]>();

        for (String sentence : sentences) {
            String[] token = getTokens(sentence);
            listOfTokens.add(token);
        }
        return listOfTokens;
    }
}
