package kurs;

import java.util.Arrays;
import java.util.Random;

public class ArraysMethods {
    private final int size = 400;
    private final String[] baseArray;
    private final Random random;

    public ArraysMethods() {
        random = new Random();
        baseArray = new String[size];
        fillBaseArray();
    }

    public String[] getCopyOfBaseArray() {
        return Arrays.copyOf(baseArray, size);
    }

    private void fillBaseArray() {
        String consonants = "qwrtpsdfghklzxcvbnmjy";
        String vowels = "euioa";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < baseArray.length; i++) {
            int length = random.nextInt(6) + 5;
            for (int j = 0; j < length; j++) {
                stringBuilder.append(getRandomChar(j % 2 == 0 ? consonants : vowels));
            }
            baseArray[i] = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    private char getRandomChar(String s) {
        return s.charAt(random.nextInt(s.length()));
    }

}
