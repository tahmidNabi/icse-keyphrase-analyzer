package com.tnob.cvalue;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tahmid on 12/25/15.
 */
public class KeyphraseFilter {

    public static final String[] stopWordList = {};

    public List<KeyphraseRecord<String, Integer>> applyFilters(String text, Integer[] maxLength) {

        Pattern pattern = Pattern.compile(KeyphraseFilterExpressions.FILTER_1);
        Matcher matcher = pattern.matcher(text);

        Map<String, Integer> pattern2count = new HashMap<String, Integer>();

        // Iterate through all matched substrings and print their positions.
        // Keep in mind that character indices start with 0.
        System.out.println("substring [start_position, end_position]");
        while (matcher.find()) {
            String substring = matcher.group().toLowerCase().trim();
            //System.out.println(substring + "\t[" + matcher.start() + " , " + matcher.end() + "]");
            if (pattern2count.containsKey(substring)) {
                pattern2count.put(substring, pattern2count.get(substring) + 1);
            } else {
                pattern2count.put(substring, 1);
            }
        }

        pattern = Pattern.compile(KeyphraseFilterExpressions.FILTER_2);

        matcher = pattern.matcher(text);

        while (matcher.find()) {
            String substring = matcher.group().toLowerCase().trim();
            //System.out.println(substring + "\t[" + matcher.start() + " , " + matcher.end() + "]");
            if (pattern2count.containsKey(substring)) {
                pattern2count.put(substring, pattern2count.get(substring) + 1);
            } else {
                pattern2count.put(substring, 1);
            }
        }


        pattern = Pattern.compile(KeyphraseFilterExpressions.FILTER_3);

        matcher = pattern.matcher(text);

        while (matcher.find()) {
            String substring = matcher.group().toLowerCase().trim();
            if (pattern2count.containsKey(substring)) {
                pattern2count.put(substring, pattern2count.get(substring) + 1);
            } else {
                pattern2count.put(substring.toLowerCase(), 1);
            }
        }

        // sort them in descending order

        List<KeyphraseRecord<String, Integer>> keyphraseRecords = new ArrayList<KeyphraseRecord<String, Integer>>();
        for (Map.Entry<String, Integer> entry : pattern2count.entrySet()) {
            //String string = entry.getKey().replaceAll("\\_(JJ|(NN[P|S]?)|IN)", "");
            String string = entry.getKey().replaceAll("\\_(jj|(nn[p|s]?)|in)", "");
            int length = string.split("\\s").length;
            maxLength[0] = Math.max(maxLength[0], length);
            boolean containsStopWord = false;

            for (String stopword : stopWordList) {
                if (string.toLowerCase().contains(stopword.toLowerCase())) {
                    containsStopWord = true;
                }
            }

            Integer occurrences = entry.getValue();
            keyphraseRecords.add(new KeyphraseRecord<String, Integer>(string, occurrences, length));
            /*if (!containsStopWord && occurrences >= 50) {
                keyphraseRecords.add(new KeyphraseRecord<String, Integer>(string, occurrences, length));
            }*/
        }

        Collections.sort(keyphraseRecords);
        System.out.println();

        System.out.println("No. of strings: " + keyphraseRecords.size());

        return keyphraseRecords;
    }
}
