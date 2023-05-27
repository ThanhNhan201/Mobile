package com.example.myapplication;

import java.util.Random;

public class EmailUtils {
    private static final String[] DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com", "example.com", "test.com"};

    public static String generateRandomEmail() {
        String randomString = generateRandomString(10); // Độ dài của phần tên ngẫu nhiên
        String domain = getRandomDomain();
        return randomString + "@" + domain;
    }

    private static String generateRandomString(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    private static String getRandomDomain() {
        Random random = new Random();
        int randomIndex = random.nextInt(DOMAINS.length);
        return DOMAINS[randomIndex];
    }
}
