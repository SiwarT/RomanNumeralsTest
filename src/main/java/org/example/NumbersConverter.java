package org.example;

import java.util.HashMap;
import java.util.Map;

public class NumbersConverter {

    private Map<Integer, String> numbers = new HashMap<Integer, String>(){{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};



    public String convertNumberToRomanNumeral(Integer number){
        if(number > 0 && number < 4000 ){
            if(numbers.containsKey(number)){
                return numbers.get(number);
            }
            StringBuilder romanNumeral = new StringBuilder();
            if(number < 4){
                return addI(number, romanNumeral);
            }

            if(number > 5 && number < 9){
                romanNumeral.append("V");
                return addI(number % 5, romanNumeral);
            }
        }

        return "Number out of interval";
    }

    private String addI(Integer number, StringBuilder romanNumeral) {
        for (int i = 0; i < number; i++){
            romanNumeral.append("I");
        }
        return romanNumeral.toString();
    }

}
