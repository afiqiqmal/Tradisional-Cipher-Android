package com.cipher.tradisional.library;

import com.cipher.tradisional.library.utils.CipherUtils;

import java.util.IllegalFormatException;

/**
 * @author : hafiq on 20/04/2017.
 */

public class AutoKeyCipher {

    private static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static String AutoEncryption(String text,String key){

        if (!CipherUtils.checkOnlyAlphabet(key)){
            throw new IllegalArgumentException("key must alphabet only ex: A, B , C....");
        }

        int len = text.length();

        String subkey = key + text;
        subkey = subkey.substring(0,subkey.length()-key.length());

        String sb = "";
        int y =0;
        for(int x=0;x<len;x++){
            char get = text.charAt(x);
            char skey = subkey.charAt(y);
            if(Character.isUpperCase(get)){
                int get1 = alpha.indexOf(get);
                int get2 = alpha.indexOf(skey);

                int total = (get1 + get2)%26;

                sb += alpha.charAt(total);
                y++;
            }
            else if(Character.isLowerCase(get)){
                int get1 = alpha.toLowerCase().indexOf(get);
                int get2 = alpha.indexOf(skey);

                int total = (get1 + get2)%26;

                sb += alpha.toLowerCase().charAt(total);
                y++;
            }
            else{
                sb += get;
            }
        }

        return sb;
    }

    public static String AutoDecryption(String text,String key){

        if (!CipherUtils.checkOnlyAlphabet(key)){
            throw new IllegalArgumentException("key must alphabet only ex: A, B , C....");
        }

        int len = text.length();

        String current = key;
        String sb ="";
        int y=0;
        for(int x=0;x<len;x++){
            char get = text.charAt(x);
            char subkey = current.charAt(y);
            if(Character.isUpperCase(get)){
                int get1 = alpha.indexOf(get);
                int get2 = alpha.indexOf(subkey);

                int total = (get1 - get2)%26;
                total = (total<0)? total + 26 : total;
                sb += alpha.charAt(total);

                current += alpha.charAt(total);
                y++;
            }
            else if(Character.isLowerCase(get)){
                int get1 = alpha.toLowerCase().indexOf(get);
                int get2 = alpha.indexOf(subkey);

                int total = (get1 - get2)%26;
                total = (total<0)? total + 26 : total;
                sb += alpha.charAt(total);

                current += alpha.toLowerCase().charAt(total);
                y++;
            }
            else{
                sb += get;
            }
        }
        return sb;
    }
}
