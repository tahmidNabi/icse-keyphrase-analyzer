package com.tnob.cvalue;

import java.util.Collections;
import java.util.List;

/**
 * Created by tahmid on 3/12/16.
 */
public class CValueCalculator {
    public static void calculateCValue(Integer maxLength, List<KeyphraseRecord<String, Integer>> keyphraseRecords) {
        int count = 0;
        for (int i = 0; i < keyphraseRecords.size(); i++) {
            KeyphraseRecord<String, Integer> keyphraseRecord = keyphraseRecords.get(i);

            if (keyphraseRecord.getLength() == maxLength) {

                for (int j = 0; j < keyphraseRecords.size(); j++) {
                    KeyphraseRecord<String, Integer> subStringKeyphraseRecord = keyphraseRecords.get(j);

                    if (keyphraseRecord.getInput().contains(subStringKeyphraseRecord.getInput())) {
                        subStringKeyphraseRecord.setSubstring(true);
                        keyphraseRecord.getSubstringIndices().add(j);
                    }
                }
                double cValue = (Math.log(keyphraseRecord.getLength()) / Math.log(2)) * keyphraseRecord.getOccurrences();
                keyphraseRecord.setcValue(cValue);

                for (int index : keyphraseRecord.getSubstringIndices()) {
                    KeyphraseRecord<String, Integer> subStringKeyphraseRecord = keyphraseRecords.get(index);
                    subStringKeyphraseRecord.increaseNestedOccurrenceFrequency(keyphraseRecord.getOccurrences());
                    subStringKeyphraseRecord.incrementNumberOfNestedOccurrence();
                }
                ++count;
            }
        }

        for (int i = count; i < keyphraseRecords.size(); i++) {
            KeyphraseRecord<String, Integer> keyphraseRecord = keyphraseRecords.get(i);

            if (keyphraseRecord.isSubstring() == false) {
                double cValue = (Math.log(keyphraseRecord.getLength()) / Math.log(2)) * keyphraseRecord.getOccurrences();
                keyphraseRecord.setcValue(cValue);
            } else {

                for (int j = 0; j < keyphraseRecords.size(); j++) {
                    KeyphraseRecord<String, Integer> subStringKeyphraseRecord = keyphraseRecords.get(j);

                    if (keyphraseRecord.getInput().contains(subStringKeyphraseRecord.getInput())) {
                        subStringKeyphraseRecord.setSubstring(true);
                        keyphraseRecord.getSubstringIndices().add(j);
                    }
                }

                double cValue = (Math.log(keyphraseRecord.getLength()) / Math.log(2))
                        * (keyphraseRecord.getOccurrences() - (((double) keyphraseRecord.getNestedOccurrenceFrequency()) / keyphraseRecord.getNumberOfNestedOccurrence()));
                keyphraseRecord.setcValue(cValue);

                for (int index : keyphraseRecord.getSubstringIndices()) {
                    KeyphraseRecord<String, Integer> subStringKeyphraseRecord = keyphraseRecords.get(index);
                    subStringKeyphraseRecord.increaseNestedOccurrenceFrequency(keyphraseRecord.getOccurrences());
                    subStringKeyphraseRecord.incrementNumberOfNestedOccurrence();
                }

            }
        }

        Collections.sort(keyphraseRecords, new CValueComparator());
    }
}
