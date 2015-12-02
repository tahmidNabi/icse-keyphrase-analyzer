package com.tnob;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("models/en-sent.bin");
        SentenceModel model = new SentenceModel(is);
        SentenceDetectorME sdetector = new SentenceDetectorME(model);

        String text = "Demo for sentence detector. Let's see if this is detected correctly. I will be annoyed if not.";

        String[] sentences = sdetector.sentDetect(text);

        for (String sentence : sentences) {
            System.out.println(sentence);
        }

        String pdfContent = getPDFContent("p1-murphyhill.pdf");

        System.out.println(pdfContent);


    }

    public static String getPDFContent(String fileName) throws IOException {
        PdfReader reader = new PdfReader(fileName);

        int numPages = reader.getNumberOfPages();

        StringBuilder pdfContentBuilder = new StringBuilder();

        for (int page = 1; page <= numPages; page++) {
            pdfContentBuilder.append(PdfTextExtractor.getTextFromPage(reader, page));
        }

        return pdfContentBuilder.toString();
    }
}
