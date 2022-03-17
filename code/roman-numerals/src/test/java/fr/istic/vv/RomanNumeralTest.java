package fr.istic.vv;
import net.jqwik.api.*;

public class RomanNumeralTest {

    @Property @Disabled
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        return Math.abs(anInteger) >= 0;
    }

    @Property
    boolean tousLesNombresRomainsOntUneLongueurPositive(@ForAll String string){
        if (RomanNumeraUtils.isValidRomanNumeral(string)){
            return string.length() > 0;
        } else {
            return !RomanNumeraUtils.isValidRomanNumeral(string);
        }
    }

    @Property
    boolean symbolesNombresRomains(@ForAll String string) {
        return string.matches("^[MDCLXVI]+$") ^ !RomanNumeraUtils.isValidRomanNumeral(string);
    }

    @Property
    boolean pasQuatreIConsecutifs(@ForAll String string){
        if (RomanNumeraUtils.isValidRomanNumeral(string)){
            return !string.contains("IIII");
        } else {
            return !RomanNumeraUtils.isValidRomanNumeral(string);
        }
    }

    @Property
    boolean pasQuatreXConsecutifs(@ForAll String string){
        if (RomanNumeraUtils.isValidRomanNumeral(string)){
            return !string.contains("XXXX");
        } else {
            return !RomanNumeraUtils.isValidRomanNumeral(string);
        }
    }

    @Property
    boolean pasQuatreCConsecutifs(@ForAll String string){
        if (RomanNumeraUtils.isValidRomanNumeral(string)){
            return !string.contains("CCCC");
        } else {
            return !RomanNumeraUtils.isValidRomanNumeral(string);
        }
    }

    @Property
    boolean pasQuatreMConsecutifs(@ForAll String string){
        if (RomanNumeraUtils.isValidRomanNumeral(string)){
            return !string.contains("MMMM");
        } else {
            return !RomanNumeraUtils.isValidRomanNumeral(string);
        }
    }

    @Property
    boolean pasDeuxDConsecutifs(@ForAll String string){
        if (RomanNumeraUtils.isValidRomanNumeral(string)){
            return !string.contains("DD");
        } else {
            return !RomanNumeraUtils.isValidRomanNumeral(string);
        }
    }

    @Property
    boolean pasDeuxLConsecutifs(@ForAll String string){
        if (RomanNumeraUtils.isValidRomanNumeral(string)){
            return !string.contains("LL");
        } else {
            return !RomanNumeraUtils.isValidRomanNumeral(string);
        }
    }

    @Property
    boolean pasDeuxVConsecutifs(@ForAll String string){
        if (RomanNumeraUtils.isValidRomanNumeral(string)){
            return !string.contains("VV");
        } else {
            return !RomanNumeraUtils.isValidRomanNumeral(string);
        }
    }

    @Property
    int romanToNumeral (@ForAll String roman) {
        if (RomanNumeraUtils.isValidRomanNumeral(roman)){
            return RomanNumeraUtils.parseRomanNumeral(roman);
        } else {
            return -1;
        }
    }

    @Property
    String numeralToRoman (@ForAll int numeral) {
        if (numeral >= 1 && numeral <= 3000){
            return RomanNumeraUtils.toRomanNumeral(numeral);
        } else {
            return "";
        }
    }
}
