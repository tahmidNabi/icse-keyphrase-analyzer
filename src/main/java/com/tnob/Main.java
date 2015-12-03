package com.tnob;

import com.tnob.nlp.SentenceParser;
import com.tnob.pdf.PDFContentReader;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws Exception {
        SentenceParser sentenceParser = new SentenceParser("models/en-sent.bin");

        String text = "Demo for sentence detector. Let's see if this is detected correctly. I will be annoyed if not.";

        String[] sentences = sentenceParser.detectSentences(text);

        for (String sentence : sentences) {
            System.out.println(sentence);
        }

        String pdfContent = PDFContentReader.getPDFContent("p1-murphyhill.pdf");

        System.out.println(pdfContent);


    }

}
