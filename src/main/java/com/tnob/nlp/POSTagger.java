package com.tnob.nlp;

import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tahmid on 12/2/15.
 */
public class POSTagger {

    private POSModel model;
    private POSTaggerME tagger;

    public POSTagger(String modelPath) throws Exception {
        File modelFile = new File(modelPath);
        model = new POSModelLoader().load(modelFile);
        tagger = new POSTaggerME(model);
    }

    public String[] tag(String[] tokens) {
        return tagger.tag(tokens);
    }

    public List<String[]> tag(List<String[]> listOfTokens) {
        List<String[]> listOfTags = new ArrayList<String[]>();

        for (String[] tokens : listOfTokens) {
            String[] tags = tag(tokens);
            listOfTags.add(tags);
        }
        return listOfTags;
    }
}
