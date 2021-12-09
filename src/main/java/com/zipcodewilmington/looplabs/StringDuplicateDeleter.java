package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.stream.Stream;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        if(maxNumberOfDuplications == 0){
            return new String[0];
        }
        String[] returnal = array;
        for(String str: returnal){
            long duplicates;
            if((duplicates = Arrays
                    .stream(returnal)
                    .filter(q->q.equals(str))
                    .count()) >= maxNumberOfDuplications){
                String[] temper = returnal;
                long lamdup = duplicates;
                returnal = Arrays
                        .stream(temper)
                        .filter(q->!q.equals(str))
                        .toArray(q-> Arrays.copyOf(temper, temper.length - (int) lamdup));
            }
        }
        return returnal;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        if(exactNumberOfDuplications == 0){
            return new String[0];
        }
        String[] returnal = array;
        for(String str: returnal){
            if(Arrays
                    .stream(returnal)
                    .filter(q->q.equals(str))
                    .count() == exactNumberOfDuplications){
                String[] temper = returnal;
                returnal = Arrays
                        .stream(temper)
                        .filter(q->!q.equals(str))
                        .toArray(q-> Arrays.copyOf(temper, temper.length - exactNumberOfDuplications));
            }
        }
        return returnal;
    }
}
