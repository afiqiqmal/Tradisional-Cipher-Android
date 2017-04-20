package com.cipher.tradisional.library;

/**
 * @author : hafiq on 20/04/2017.
 */

public class CaesarCipher {

    public static String leftEncode(String enc, int offset) {
        return rightEncode(enc, 26-offset);
    }

    public static String rightEncode(String enc, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();

        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

    public static String leftDecode(String enc,int offset){
        return rightDecode(enc, 26-offset);
    }

    public static String rightDecode(String enc, int offset){
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();

        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }
}
