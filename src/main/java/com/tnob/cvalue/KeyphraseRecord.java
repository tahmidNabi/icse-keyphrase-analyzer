package com.tnob.cvalue;

import java.util.ArrayList;
import java.util.List;

public class KeyphraseRecord<String,Integer> implements Comparable<KeyphraseRecord> {
	public String input;
	public int occurrences;
	public int length;
	public double cValue;
	public List<Integer> substringIndices = new ArrayList<Integer>();
	public int nestedOccurrenceFrequency;
	public int numberOfNestedOccurrence;
	public boolean isSubstring;

	public KeyphraseRecord(String input, int occurrences, int length) {
		super();
		this.input = input;
		this.occurrences = occurrences;
		this.length = length;
		this.isSubstring = false;
	}

	@Override
	public int compareTo(KeyphraseRecord arg0) {
		int compare = this.occurrences > arg0.occurrences ? -1 : this.occurrences < arg0.occurrences ? +1 : 0;
		//int compare = this.length > arg0.length ? -1 : this.length < arg0.length ? +1 : 0;
		return compare;
	}

	@Override
	public int hashCode() {
		final int x = 19;
		int result = 9;
		result = x * result + occurrences;
		result = x * result + ((input == null) ? 0 : input.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object compareObj) {
		if (this == compareObj)
			return true;
		if (compareObj == null)
			return false;
		if (getClass() != compareObj.getClass())
			return false;
		KeyphraseRecord other = (KeyphraseRecord) compareObj;
		if (occurrences != other.occurrences)
			return false;
		return true;
	}
	
	@Override
    public java.lang.String toString() {
        return "(" + input + ", " + occurrences + ")";
    }
}
