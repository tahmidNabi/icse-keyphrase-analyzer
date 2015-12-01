package com.tnob;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws Exception
    {
        InputStream is = new FileInputStream("models/en-sent.bin");
        SentenceModel model = new SentenceModel(is);
        SentenceDetectorME sdetector = new SentenceDetectorME(model);

        String text = "Demo for sentence detector. Let's see if this is detected correctly. I will be annoyed if not.";

        String[] sentences = sdetector.sentDetect(text);

        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
