package com.tnob;

import com.tnob.cvalue.KeyphraseFilter;
import com.tnob.cvalue.KeyphraseRecord;
import com.tnob.nlp.POSTagger;
import com.tnob.nlp.SentenceParser;
import com.tnob.nlp.Tokenizer;
import com.tnob.pdf.PDFContentReader;

import java.util.List;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws Exception {
        SentenceParser sentenceParser = new SentenceParser("models/en-sent.bin");
        Tokenizer tokenizer = new Tokenizer("models/en-token.bin");
        POSTagger posTagger = new POSTagger("models/en-pos-maxent.bin");



        String pdfContent = PDFContentReader.getPDFFirstPageContent("p1-murphyhill.pdf");



        int abstractBeginIndex = pdfContent.indexOf("ABSTRACT") + "ABSTRACT".length();
        System.out.println(abstractBeginIndex);
        int abstractEndIndex = pdfContent.indexOf("Categories and Subject Descriptors") - 1;
        System.out.println(abstractEndIndex);

        String abstractText = pdfContent.substring(abstractBeginIndex, abstractEndIndex);

        //System.out.println(abstractText);

        String[] sentences = sentenceParser.detectSentences(abstractText);
        List<String[]> tokens = tokenizer.getTokens(sentences);
        List<String[]> tags = posTagger.tag(tokens);

        StringBuilder taggedAbstractBuilder = new StringBuilder();


        for (int k = 0; k < tokens.size(); k++) {
            String[] token = tokens.get(k);
            String[] POSTag = tags.get(k);
            //String[] tokenPOS = new String[token.length];
            for (int j = 0; j < token.length; j++) {
                String tokenPOS = token[j] + "_" + POSTag[j];
                taggedAbstractBuilder.append(tokenPOS);
                //System.out.print(tokenPOS);
                //System.out.print(" ");
                taggedAbstractBuilder.append(" ");
            }

        }

        String taggedAbstract = taggedAbstractBuilder.toString();

        Integer[] maxLength = new Integer[1];
        maxLength[0] = Integer.MIN_VALUE;
        KeyphraseFilter keyphraseFilter = new KeyphraseFilter();

        List<KeyphraseRecord<String, Integer>> keyphraseRecords = keyphraseFilter.applyFilters(taggedAbstract, maxLength);

        for (KeyphraseRecord<String, Integer> keyphraseRecord : keyphraseRecords) {
            System.out.println(keyphraseRecord.input + "," + keyphraseRecord.occurrences);
        }


    }

}
