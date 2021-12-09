package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        if(maxNumberOfDuplications == 0){
            return new Integer[0];
        }
        Integer[] returnal = array;
        for(Integer str: returnal){
            long duplicates;
            if((duplicates = Arrays
                    .stream(returnal)
                    .filter(q->q.equals(str))
                    .count()) >= maxNumberOfDuplications){
                Integer[] temper = returnal;
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
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] returnal = array;
        for(Integer inta: returnal){
            if(Arrays.stream(returnal)
                    .filter(q->q.equals(inta))
                    .count() == exactNumberOfDuplications){
                Integer[] temper = returnal;
                returnal = Arrays
                        .stream(temper)
                        .filter(q->!q.equals(inta))
                        .toArray(q-> Arrays.copyOf(temper, temper.length - exactNumberOfDuplications));
            }
        }
        return returnal;
    }
}
