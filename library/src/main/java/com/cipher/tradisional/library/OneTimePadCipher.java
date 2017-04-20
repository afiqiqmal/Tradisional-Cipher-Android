package com.cipher.tradisional.library;

/**
 * @author : hafiq on 20/04/2017.
 */

public class OneTimePadCipher {
    private static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String checkKey(String text, String key){
        int len = text.length();
        String k = "";
        if(key.length()<len){
            int count = 0;
            for(int x=0;x<len;x++){
                if(count == key.length())
                    count = 0;
                k = k+key.charAt(count);
                count++;
            }

            key = k;
        }

        return key.toUpperCase();
    }

    public static String OTPEncryption(String text,String key){

        key = checkKey(text,key);

        int len = text.length();
        String sb = "";
        int y=0;
        for(int x=0;x<len;x++){
            char get = text.charAt(x);
            char keyget = key.charAt(y);
            if(Character.isUpperCase(get)){
                int index = alpha.indexOf(get);
                int keydex = alpha.indexOf(keyget);

                int total = (index + keydex) % 26;

                sb = sb+ alpha.charAt(total);
                y++;
            }
            else if(Character.isLowerCase(get)){
                int index = alpha.toLowerCase().indexOf(get);
                int keydex = alpha.indexOf(keyget);

                int total = (index + keydex) % 26;

                sb = sb+ alpha.toLowerCase().charAt(total);
                y++;
            }
            else{
                sb = sb + get;
            }
        }

        return sb;
    }
    public static String OTPDecryption(String text,String key){
        key = checkKey(text,key);

        int len = text.length();

        String sb = "";
        int y=0;
        for(int x=0;x<len;x++){
            char get = text.charAt(x);
            char keyget = key.charAt(y);
            if(Character.isUpperCase(get)){
                int index = alpha.indexOf(get);
                int keydex = alpha.indexOf(keyget);

                int total = (index - keydex) % 26;
                total = (total<0)? total + 26 : total;

                sb = sb+ alpha.charAt(total);
                y++;
            }
            else if(Character.isLowerCase(get)){
                int index = alpha.toLowerCase().indexOf(get);
                int keydex = alpha.indexOf(keyget);

                int total = (index - keydex) % 26;
                total = (total<0)? total + 26 : total;

                sb = sb+ alpha.toLowerCase().charAt(total);
                y++;
            }
            else{
                sb = sb + get;
            }
        }

        return sb;
    }
}
