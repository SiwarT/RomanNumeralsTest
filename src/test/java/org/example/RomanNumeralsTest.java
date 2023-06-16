package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralsTest {

    @Test
    public void should_return_I_when_arabic_number_is_1 () {
        NumbersConverter numbersConverter = new NumbersConverter();

        String romanNumber = numbersConverter.convertNumberToRomanNumeral(1);

        Assertions.assertEquals("I", romanNumber);
    }

    @Test
    public void should_return_II_when_arabic_number_is_2 () {
        NumbersConverter numbersConverter = new NumbersConverter();

        String romanNumber = numbersConverter.convertNumberToRomanNumeral(2);

        Assertions.assertEquals("II", romanNumber);
    }

    @Test
    public void should_return_III_when_arabic_number_is_3 () {
        NumbersConverter numbersConverter = new NumbersConverter();

        String romanNumber = numbersConverter.convertNumberToRomanNumeral(3);

        Assertions.assertEquals("III", romanNumber);
    }

    @Test
    public void should_return_IV_when_arabic_number_is_4 () {
        NumbersConverter numbersConverter = new NumbersConverter();

        String romanNumber = numbersConverter.convertNumberToRomanNumeral(4);

        Assertions.assertEquals("IV", romanNumber);
    }

    @Test
    public void should_return_VII_when_arabic_number_is_7 () {
        NumbersConverter numbersConverter = new NumbersConverter();

        String romanNumber = numbersConverter.convertNumberToRomanNumeral(7);

        Assertions.assertEquals("VII", romanNumber);
    }

    @Test
    public void should_return_CD_when_arabic_number_is_400 () {
        NumbersConverter numbersConverter = new NumbersConverter();

        String romanNumber = numbersConverter.convertNumberToRomanNumeral(400);

        Assertions.assertEquals("CD", romanNumber);
    }

    @Test
    public void should_return_message_when_arabic_number_is_out_of_interval () {
        NumbersConverter numbersConverter = new NumbersConverter();

        String romanNumber = numbersConverter.convertNumberToRomanNumeral(4444);

        Assertions.assertEquals("Number out of interval", romanNumber);
    }

/*    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    @Test
    public void should_test () {

    }*/

}