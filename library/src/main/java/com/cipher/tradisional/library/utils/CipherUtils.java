package com.cipher.tradisional.library.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : hafiq on 20/04/2017.
 */

public class CipherUtils {

    public static String RandomAlphaNoDuplicate(int len){
        Random r = new Random();
        String key = "";
        for (int i = 0; i < len;) {
            char c = (char) (r.nextInt(26) + 'A');
            if(!key.contains(""+c)){
                key = key + c;
                i++;
            }
        }
        return key;
    }

    public static boolean checkOnlyAlphabet(String state){
        Pattern ps = Pattern.compile("^[a-zA-Z]+$");
        Matcher ms = ps.matcher(state);

        return ms.matches();
    }
}
