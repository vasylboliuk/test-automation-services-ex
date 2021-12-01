package org.automation.generators;

import java.util.Random;

public class Generator {

    private Generator() {
        // default private constructor
    }

    public static String randomString() {
        return randomString(10); // default string length
    }

    public static String randomString(int targetStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        return new Random().ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }

}
