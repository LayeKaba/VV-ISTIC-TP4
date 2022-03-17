package fr.istic.vv;
import net.jqwik.api.*;

public class SortingTest {
    @Property
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        return Math.abs(anInteger) >= 0;
    }
    
    @Property
    boolean arrayIsSorted(@ForAll Integer[] anArray) {

        Integer[] bubbleCopy,quickCopy,mergeCopy;
        triBulle = anArray.clone();
        triRapide = anArray.clone();
        triFusion = anArray.clone();
        Arrays.sort(anArray);

        Sorting.bubblesort(triBulle, Integer::compareTo);
        boolean triBulleResultat = Arrays.equals(triBulle, anArray);

        Sorting.quicksort(triRapide, Integer::compareTo);
        boolean triRapideResultat = Arrays.equals(triRapide, anArray);

        Sorting.mergesort(triFusion, Integer::compareTo);
        boolean triFusionResultat = Arrays.equals(triFusion, anArray);

        return triBulleResultat && triRapideResultat && triFusionResultat;
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
