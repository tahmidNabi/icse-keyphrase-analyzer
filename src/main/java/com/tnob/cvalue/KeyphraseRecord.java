package com.tnob.cvalue;

import java.util.ArrayList;
import java.util.List;

public class KeyphraseRecord<String,Integer> implements Comparable<KeyphraseRecord> {
	private String input;
	private int occurrences;
	private int length;
	private double cValue;
	private List<Integer> substringIndices;
	private int nestedOccurrenceFrequency;
	private int numberOfNestedOccurrence;
	private boolean substring;

	public KeyphraseRecord(String input, int occurrences, int length) {
		super();
		this.input = input;
		this.occurrences = occurrences;
		this.length = length;
		this.substring = false;
        this.substringIndices = new ArrayList<Integer>();
    }

	public String getInput() {
		return input;
	}

	public int getOccurrences() {
		return occurrences;
	}

	public int getLength() {
		return length;
	}

    public void setcValue(double cValue) {
        this.cValue = cValue;
    }

    public void setSubstringIndices(List<Integer> substringIndices) {
        this.substringIndices = substringIndices;
    }

    public void setNestedOccurrenceFrequency(int nestedOccurrenceFrequency) {
        this.nestedOccurrenceFrequency = nestedOccurrenceFrequency;
    }

    public void setNumberOfNestedOccurrence(int numberOfNestedOccurrence) {
        this.numberOfNestedOccurrence = numberOfNestedOccurrence;
    }

    public void setSubstring(boolean substring) {
        this.substring = substring;
    }

    public double getcValue() {
        return cValue;
    }

    public List<Integer> getSubstringIndices() {
        return substringIndices;
    }

    public int getNestedOccurrenceFrequency() {
        return nestedOccurrenceFrequency;
    }

    public int getNumberOfNestedOccurrence() {
        return numberOfNestedOccurrence;
    }

    public boolean isSubstring() {
        return substring;
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
