package com.cipher.tradisional.library;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : hafiq on 20/04/2017.
 */

public class OddEvenCaesar {

    public static String Encode(String enc, int offset) {
        offset = offset % 26;
        StringBuilder encoded = new StringBuilder();

        int count =0;

        for (char i : enc.toCharArray()) {
            if(count%2 == 0){
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
            else if(count%2 == 1){
                if (Character.isLetter(i)) {
                    if (Character.isUpperCase(i)) {
                        encoded.append((char) ('A' + (i - 'A' + 26-offset) % 26 ));
                    } else {
                        encoded.append((char) ('a' + (i - 'a' + 26-offset) % 26 ));
                    }
                } else {
                    encoded.append(i);
                }
            }

            count++;
        }
        return encoded.toString();
    }

    public static String Decode(String enc, int offset) {
        offset = offset % 26;
        StringBuilder decoded = new StringBuilder();

        int count =0;

        for (char i : enc.toCharArray()) {
            if(count%2 == 1){
                if (Character.isLetter(i)) {
                    if (Character.isUpperCase(i)) {
                        decoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                    } else {
                        decoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                    }
                } else {
                    decoded.append(i);
                }
            }
            else if(count%2 == 0){
                if (Character.isLetter(i)) {
                    if (Character.isUpperCase(i)) {
                        decoded.append((char) ('A' + (i - 'A' + 26-offset) % 26 ));
                    } else {
                        decoded.append((char) ('a' + (i - 'a' + 26-offset) % 26 ));
                    }
                } else {
                    decoded.append(i);
                }
            }

            count++;
        }
        return decoded.toString();
    }

    public static List<String> DecodeNoKey(String enc) {
        List<String> predict = new ArrayList<>();
        for(int x=0;x<26;x++){
            int offset = x % 26;
            StringBuilder decoded = new StringBuilder();

            int count =0;

            for (char i : enc.toCharArray()) {
                if(count%2 == 1){
                    if (Character.isLetter(i)) {
                        if (Character.isUpperCase(i)) {
                            decoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                        } else {
                            decoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                        }
                    } else {
                        decoded.append(i);
                    }
                }
                else if(count%2 == 0){
                    if (Character.isLetter(i)) {
                        if (Character.isUpperCase(i)) {
                            decoded.append((char) ('A' + (i - 'A' + 26-offset) % 26 ));
                        } else {
                            decoded.append((char) ('a' + (i - 'a' + 26-offset) % 26 ));
                        }
                    } else {
                        decoded.append(i);
                    }
                }

                count++;
            }

            predict.add(decoded.toString());
        }

        return predict;
    }
}
