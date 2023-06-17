package org.example;

import java.util.HashMap;
import java.util.Map;

public class NumbersConverter {


    private final Map<Integer, String> particularCases = new HashMap<>();

    public NumbersConverter() {
        inializeParticularCasesMap();
    }

    private void inializeParticularCasesMap() {
        particularCases.put(4, "IV");
        particularCases.put(5, "V");
        particularCases.put(9, "IX");
        particularCases.put(10, "X");
        particularCases.put(40, "XL");
        particularCases.put(50, "L");
        particularCases.put(90, "XC");
        particularCases.put(100, "C");
        particularCases.put(400, "CD");
        particularCases.put(500, "D");
        particularCases.put(900, "CM");
        particularCases.put(1000, "M");
    }

    public String convertNumberToRomanNumeral(Integer number) {
        if (isWithinInterval(number, 0, 4000)) {

            StringBuilder romanNumber = new StringBuilder();

            if (particularCases.containsKey(number)) {
                return particularCases.get(number);
            }

            if (isWithinInterval(number, 0, 10)) {
                return convertOneDigitNumber(number, romanNumber);
            }

            if (isWithinInterval(number, 10, 100)) {
                return convertTwoDigitsNumber(number, romanNumber);
            }

            if (isWithinInterval(number, 100, 1000)) {
                return convertThreeDigitsNumber(number, romanNumber);
            }

            if (number > 1000) {
                for (int i = 0; i < (number / 1000); i++) {
                    romanNumber.append("M");
                }
                return convertThreeDigitsNumber(number % 1000, romanNumber);
            }
        }

        return "Number out of interval";
    }


    private String convertOneDigitNumber(Integer number, StringBuilder romanNumber) {

        if (particularCases.containsKey(number)) {
            return romanNumber.append(particularCases.get(number)).toString();
        }
        if (number < 4) {
            return addI(number, romanNumber);
        }
        if (number > 5 && number < 9) {
            romanNumber.append("V");
            return addI(number % 5, romanNumber);
        }
        return null;
    }

    private String convertTwoDigitsNumber(Integer number, StringBuilder romanNumber) {
        if (number < 50) {
            getTensLessThan50OrHundredsLessThan500((number / 10) % 10, romanNumber, "XL", "X");
        } else {
            getTensGreaterThan50((number / 10) % 10, romanNumber);
        }
        return convertOneDigitNumber(number % 10, romanNumber);
    }


    private String convertThreeDigitsNumber(Integer number, StringBuilder romanNumber) {
        if (number < 500) {
            getTensLessThan50OrHundredsLessThan500((number / 100) % 10, romanNumber, "CD", "C");
        }
        if (number > 500) {
            getHundredsGreaterThan500((number / 100) % 10, romanNumber);
        }
        return convertTwoDigitsNumber((number % 100), romanNumber);
    }


    private void getHundredsGreaterThan500(Integer number, StringBuilder romanNumber) {

        if (number == 5) {
            romanNumber.append("D");
        } else {

            if (number == 9) {
                romanNumber.append("CM");
            } else {
                romanNumber.append("D");
                for (int i = 0; i < number - 5; i++) {
                    romanNumber.append("C");
                }
            }
        }
    }

    public boolean isWithinInterval(Integer number, int min, int max) {
        return number > min && number < max;
    }

    private String addI(Integer number, StringBuilder romanNumber) {
        for (int i = 0; i < number; i++) {
            romanNumber.append("I");
        }
        return romanNumber.toString();
    }

    private void getTensLessThan50OrHundredsLessThan500(Integer number, StringBuilder romanNumber,
          String lessThan, String greaterThan) {
        if (number == 4) {
            romanNumber.append(lessThan);
        } else {
            for (int i = 0; i < number; i++) {
                romanNumber.append(greaterThan);
            }
        }
    }

    private void getTensGreaterThan50(Integer number, StringBuilder romanNumber) {

        if (number == 9) {
            romanNumber.append("XC");
        } else {
            romanNumber.append("L");
            for (int i = 0; i < number - 5; i++) {
                romanNumber.append("X");
            }
        }
    }

}
