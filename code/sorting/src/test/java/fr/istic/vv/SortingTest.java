package fr.istic.vv;
import net.jqwik.api.*;

public class SortingTest {
    @Property
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        return Math.abs(anInteger) >= 0;
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
