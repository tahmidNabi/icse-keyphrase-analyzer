package com.tnob.cvalue;

import java.util.Comparator;

/**
 * Created by tahmid on 3/12/16.
 */
public class CValueComparator implements Comparator<KeyphraseRecord<String, Integer>> {

    @Override
    public int compare(KeyphraseRecord<String, Integer> record1, KeyphraseRecord<String, Integer> record2) {
        int compare = record1.getcValue() > record2.getcValue() ? -1 : record1.getcValue() < record2.getcValue() ? 1 : 0;
        return compare;
    }

}
