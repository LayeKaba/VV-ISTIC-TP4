package fr.istic.vv;
import java.util.Arrays;

import net.jqwik.api.*;

public class SortingTest {
    @Property
    @Disabled
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        return Math.abs(anInteger) >= 0;
    }
    
    @Property
    boolean bulleSorted(@ForAll Integer[] anArray) {
    	Integer[] triBulle;
        triBulle = anArray.clone();
        Arrays.sort(anArray);
        
        Sorting.bubblesort(triBulle, Integer::compareTo);
        boolean triBulleResultat = Arrays.equals(triBulle, anArray);

        
        return triBulleResultat;
    }
    
    @Property
    boolean rapideSorted(@ForAll Integer[] anArray) {
    	Integer[] triRapide;
        triRapide = anArray.clone();
        
        Arrays.sort(anArray);
        
        
        Sorting.quicksort(triRapide, Integer::compareTo);
        boolean triRapideResultat = Arrays.equals(triRapide, anArray);

       
        return triRapideResultat ;
    }
    @Property
    boolean fusionSorted(@ForAll Integer[] anArray) {

        Integer[] triFusion;
         triFusion = anArray.clone();
        Arrays.sort(anArray);

        
        Sorting.mergesort(triFusion, Integer::compareTo);
        boolean triFusionResultat = Arrays.equals(triFusion, anArray);

        return triFusionResultat;
    }
     @Provide
    Arbitrary<Integer[]> ArrProvider() {
        Arbitrary<Integer> integerArbitrary = Arbitraries.integers().between(1, 100);
        return integerArbitrary
                .array(Integer[].class).ofMinSize(0).ofMaxSize(30)
                .map(anArray -> {
                    return anArray;
                });
    }
}
