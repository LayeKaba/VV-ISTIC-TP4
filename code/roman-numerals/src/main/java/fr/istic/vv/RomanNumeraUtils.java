package fr.istic.vv;

import java.util.HashMap;

public class RomanNumeraUtils {

	public static boolean isValidRomanNumeral(String value) {
		String regex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
		return value.length() > 0 && value.matches(regex);
	}

	public static int parseRomanNumeral(String numeral) {
		if (!isValidRomanNumeral(numeral)) {
			return -1;
		}

		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int taille = numeral.length();
		int resultat = map.get(numeral.charAt(taille - 1));
		for (int i = taille - 2; i >= 0; i--) {
			if (map.get(numeral.charAt(i)) >= map.get(numeral.charAt(i + 1)))
				resultat += map.get(numeral.charAt(i));
			else
				resultat -= map.get(numeral.charAt(i));
		}
		return resultat;
	}

	public static String toRomanNumeral(int number) {
		int[] valeursNumeriques = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] valeursRomaines = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

		String nombreRoman = "";

		for(int i=0;i<valeursNumeriques.length;i++) {
			while(number >= valeursNumeriques[i]) {
				number -= valeursNumeriques[i];
				nombreRoman = nombreRoman + (valeursRomaines[i]);
			}
		}
		return nombreRoman;
	}

	public static void main(String[] args) {
		System.out.println(toRomanNumeral(14) + " : 14 = XIV");
		System.out.println(toRomanNumeral(16) + " : 16 = XVI");
		System.out.println(toRomanNumeral(19) + " : 19 = XIX");
		System.out.println(toRomanNumeral(99) + " : 99 = XCIX");
		System.out.println(toRomanNumeral(105) + " : 105 = CV");
		System.out.println(toRomanNumeral(1001) + " : 1001 = MI");
		System.out.println(toRomanNumeral(2289) + " : 2289 = MMCCLXXXIX");
		System.out.println("---------");
		System.out.println(parseRomanNumeral("XIV") + " : XIV = 14");
		System.out.println(parseRomanNumeral("XVI") + " : XVI = 16");
		System.out.println(parseRomanNumeral("XIX") + " : XIX = 19");
		System.out.println(parseRomanNumeral("XCIX") + " : XCIX = 99");
		System.out.println(parseRomanNumeral("CV") + " : CV = 105");
		System.out.println(parseRomanNumeral("MI") + " : MI = 1001");
		System.out.println(parseRomanNumeral("MMCCLXXXIX") + " : MMCCLXXXIX = 2289");
	}

}
