package com.cipher.tradisional.library;

/**
 * @author : hafiq on 20/04/2017.
 */

public class AffineCipher {

    private static char whiteSpaceReplacement = 'X';

    public static  void setWhiteSpaceReplacement(char whiteSpaceReplacement) {
        AffineCipher.whiteSpaceReplacement = whiteSpaceReplacement;
    }

    public static String encrypt(String input, int FK, int SK) {
        String str = "";
        for (int in = 0; in < input.length(); in++) {
            char get = input.charAt(in);
            if (Character.isLetter(get)) {
                // ax + b % 26
                if (Character.isUpperCase(get)) {
                    get = (char) ((FK * (int) (get + 'A') + SK) % 26 + 'A');
                }
                else if (Character.isLowerCase(get)){
                    char temp = Character.toUpperCase(get);
                    get = (char) ((FK * (int) (temp + 'A') + SK) % 26 + 'A');
                    get = Character.toLowerCase(get);
                }
            }
            else{
                get = whiteSpaceReplacement;
            }
            str +=get;
        }
        return str;
    }

    public static String decrypt(String input,int FK,int SK) {
        String str = "";
        int IN = 0;
        int inverse = 0;

        // find 1 by using modular inverse
        // 17 * IN mod 26 == 1
        // IN is 0 - infiniti
        // if total == 1, then IN is the inverse modular
        while(true){
            inverse = FK * IN % 26;
            if(inverse == 1)
                break;
            IN++;
        }
        for (int in = 0; in < input.length(); in++) {
            char get = input.charAt(in);
            if (Character.isLetter(get)) {
                // IN *(x-b) mod 26

                if (Character.isUpperCase(get)) {
                    get = (char) (IN * ((get + 'A') - SK) % 26 + 'A');
                }
                else if (Character.isLowerCase(get)){
                    char temp = Character.toUpperCase(get);
                    get = (char) (IN * ((temp + 'A') - SK) % 26 + 'A');
                    get = Character.toLowerCase(get);
                }
            }
            str +=get;
        }
        return str;
    }

}
