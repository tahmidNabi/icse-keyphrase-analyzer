package com.tnob.cvalue;

import java.util.Comparator;

/**
 * Created by tahmid on 3/12/16.
 */
public class LengthComparator implements Comparator<KeyphraseRecord<String, Integer>> {
    @Override
    public int compare(KeyphraseRecord<String, Integer> record1, KeyphraseRecord<String, Integer> record2) {
        return record1.length > record2.length ? -1 : record1.length < record2.length ? +1 : 0;
    }
}
