package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        return new String[0];
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] returnal = array;
        for(String str: array){
            if(Arrays.stream(array).filter(q->q.equals(str)).count() == exactNumberOfDuplications){
                returnal = Arrays.stream(returnal).filter(q->!q.equals(str)).toArray(q-> Arrays.copyOf(returnal, returnal.length - exactNumberOfDuplications));
            }
        }
    }
}
