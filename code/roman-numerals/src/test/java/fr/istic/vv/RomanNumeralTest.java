package fr.istic.vv;
import net.jqwik.api.*;

public class RomanNumeralTest {
    
    @Property
    @Disabled
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        return Math.abs(anInteger) >= 0;
    }

    @Property
    boolean tousLesNombresRomainsOntUneLongueurPositive(@ForAll String string){
        if (RomanNumeraUtils.isValidRomanNumeral(string)){
            return string.length() > 0;
        }else{
            return !RomanNumeraUtils.isValidRomanNumeral(string);
        }
    }

    @Property
    boolean symbolesNombresRomains(@ForAll String string) {
        return string.matches("^[MDCLXVI]+$") ^ !RomanNumeraUtils.isValidRomanNumeral(string);
    }
}
