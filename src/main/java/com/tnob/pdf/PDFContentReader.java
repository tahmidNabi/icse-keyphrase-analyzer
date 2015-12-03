package com.tnob.pdf;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;

/**
 * Created by tahmid on 12/2/15.
 */
public class PDFContentReader {

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
