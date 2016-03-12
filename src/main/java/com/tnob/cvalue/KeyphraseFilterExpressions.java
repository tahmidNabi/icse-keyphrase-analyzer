package com.tnob.cvalue;

/**
 * Created by tahmid on 12/25/15.
 */
public interface KeyphraseFilterExpressions {

    public static final String FILTER_1 = "([A-Za-z]+\\_(NN[P|S]?)\\s)+([A-Za-z]+\\_(NN[P|S]?))";
    public static final String FILTER_2 = "([A-Za-z]+\\_(JJ|(NN[P|S]?))\\s)+([A-Za-z]+\\_(NN[P|S]?))";
    public static final String FILTER_3 = "((([A-Za-z])+\\_(JJ|NN[P|S]?))\\s+|((([A-Za-z])+\\_(JJ|NN[P|S]?))\\s*(([A-Za-z])+\\_(IN))\\s?)(([A-Za-z])+\\_(JJ|NN[P|S]?))\\s*)(([A-Za-z])+\\_(NN[P|S]?))";

}
