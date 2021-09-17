package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Velkommen til Caezers cipher, vælg en kode");
        System.out.println("Tast '1' for Number cipher");
        System.out.println("tast '2' for Caesar cipher");
        System.out.println("tast '3' for Vigènere cipher");
        System.out.println("tast '0' for Exit");
        String whichCode = userInput.nextLine();
        System.out.println("Tast 'e' for at encode, eller 'd' for at decode: ");
        String codeType = userInput.nextLine();

        while (whichCode != "0")
            if ("0".equals(whichCode)) {
                System.exit(0);
                // Encoding
                // numberCipher
            } else if ("1".equals(whichCode) && "e".equals(codeType)) {
                System.out.println("Indtast teksten du ønkser at kryptere.");
                String text = userInput.nextLine().toUpperCase();
                encodeNumberCipher(text);
                // caesarCipher
            } else if ("2".equals(whichCode) && "e".equals(codeType)) {
                System.out.println("Indtast koden du ønsker at kryptere til romersk kode.");
                String text = userInput.nextLine().toUpperCase();
                System.out.println("Indtast positiv shift værdi");
                int shift = userInput.nextInt();
                String cipherText = encodeAndDecodeCaesarCipher(text, shift);
                System.out.println(cipherText);
                // vigènereCipher
            } else if ("3".equals(whichCode) && "e".equals(codeType)) {
                encodeVigenereCipher("C");
                System.out.println(encodeVigenereCipher("Under konstruktion kontakt programmør i hverdagene"));
                // Decoding
                // numberCipher
            } else if ("1".equals(whichCode) && "d".equals(codeType)) {
                System.out.println("Indtast den krypterede tekt af tal.");
                String commaSeparatedNumbers = userInput.nextLine().toUpperCase();
                int[] number = getIntArrayFromString(commaSeparatedNumbers);
                decodeNumberCipher(number);
                // caesarCipher
            } else if ("2".equals(whichCode) && "d".equals(codeType)) {
                System.out.println("Indtast den romerske kode");
                String text = userInput.nextLine();
                System.out.println("Indtast negativ shift værdi");
                int shift = userInput.nextInt();
                String cipherText = encodeAndDecodeCaesarCipher(text, shift);
                System.out.println(cipherText);
                // vigènereCipher
            } else if ("3".equals(whichCode) && "d".equals(codeType)) {
                System.out.println(encodeVigenereCipher("Under konstruktion kontakt programmør i hverdagene"));
                decodeVigenereCipher(3);
                System.out.println(decodeVigenereCipher(6));
            }
    }

    public static int[] encodeNumberCipher(String text) {

        String plaintext = text;
        int[] cipher = textToListOfNumbers(plaintext);
        System.out.println(Arrays.toString(cipher));

        return cipher;
    }

    public static String encodeAndDecodeCaesarCipher(String text, int shift) {

        String romanText = text;
        int[] plainNumbers = textToListOfNumbers(romanText);
        int[] cipherNumbers = shiftListOfNumbers(plainNumbers, shift);
        String cipherText = listOfNumbersToText(cipherNumbers);

        return cipherText;
    }

    public static int encodeVigenereCipher(String text) {
        int number = 3;
        return number;
    }

    public static String decodeNumberCipher(int[] number) {

        int[] cipher = number;
        String plaintext = listOfNumbersToText(cipher);
        System.out.println("Den decryptede tekst er: ");
        System.out.println(plaintext);

        return plaintext;
    }

    /*public static String numberToTextCaesarCipher (String, int ) {
        //beder brugeren om ciphertext
        // beder brugeren om shift-værdi
        // kalder caesarDecrypt med ciphertext og shift værdi
        // udskriver plaintext modtaget fra ovenstående
        String text = "caesarCipher";
        return text;
    }*/

    public static String decodeVigenereCipher(int number) {
        String text = "vigènereCipher";
        return text;
    }

    public static int letterToNumber(char letter) {

        String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        int num = alphabet.indexOf(letter);

        return num;
    }

    public static int[] textToListOfNumbers(String text) {

        int[] list = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            int number = letterToNumber(letter);
            list[i] = number;
        }

        return list;
    }

    public static String listOfNumbersToText(int[] numbers) {

        String text = "";

        for (int i = 0; i < numbers.length; i++) {

            int number = numbers[i];
            char letter = numberToLetter(number);
            text = text + letter;

        }

        return text;
    }

    public static char numberToLetter(int number) {

        String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        char letter = alphabet.charAt(number);

        return letter;
    }

    // Konverterer en String af tal til int array
    private static int[] getIntArrayFromString(String commaSeparatedNumbers) {

        String[] numberStrings = commaSeparatedNumbers.substring(1, commaSeparatedNumbers.length() - 1).split(",");
        int[] numbers = new int[numberStrings.length];

        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i].trim());
        }

        return numbers;
    }

    public static int[] shiftListOfNumbers(int[] numbers, int shift) {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int shiftedNumbers = shiftNumber(number, shift);
            numbers[i] = shiftedNumbers;
        }
        return numbers;
    }

    public static int shiftNumber(int number, int shift) {
        int maxNumberOfLetters = 29;
        int shiftnumber = number + shift;
        if (shiftnumber >= maxNumberOfLetters + 1) {
            shiftnumber = shiftnumber - maxNumberOfLetters;
        } else if (number == 0) {
            shiftnumber = 0;
        }
        return shiftnumber;
    }

}
