package com.cipher.tradisional.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author : hafiq on 20/04/2017.
 */

public class PolyAlphabetSubtitution {

    private static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static List<String> list;

    public static List<String> getPeriodList() {
        return list;
    }

    public static void setPeriodList(List<String> list) {
        PolyAlphabetSubtitution.list = list;
    }

    public static List<String> generatePeriod(int polyPeriod){
        List<String> list = new ArrayList<>();
        Random r = new Random();
        for(int x=0;x<polyPeriod;x++){
            String key = "";
            for (int i = 0; i < 26;) {
                char c = (char) (r.nextInt(26) + 'A');
                if(!key.contains(""+c)){
                    key = key + c;
                    i++;
                }
            }
            list.add(key);
        }
        return list;
    }

    public static String PASEncryption(String text,List<String> list){
        int len = text.length();

        String sb = "";

        int p = 0;
        for(int x=0;x<len;x++){
            if (p == list.size())
                p = 0;

            char g = text.charAt(x);

            if(Character.isUpperCase(g)){
                int get = alpha.indexOf(g);

                String CT = list.get(p);

                sb = sb + CT.charAt(get);

                p++;
            }
            else if(Character.isLowerCase(g)){
                int get = alpha.toLowerCase().indexOf(g);

                String CT = list.get(p);

                sb = sb + CT.toLowerCase().charAt(get);

                p++;
            }
            else{
                sb += g;
            }
        }

        return sb;
    }

    public static String PASDecryption(String text,List<String> list){
        int len = text.length();

        String sb = "";

        int p = 0;
        for(int x=0;x<len;x++){
            if (p == list.size())
                p = 0;

            char g = text.charAt(x);
            if(Character.isUpperCase(g)){
                int get = list.get(p).indexOf(g);

                sb = sb + alpha.charAt(get);

                p++;
            }
            else if(Character.isLowerCase(g)){
                int get = list.get(p).toLowerCase().indexOf(g);

                sb = sb + alpha.toLowerCase().charAt(get);

                p++;
            }
            else{
                sb += g;
            }
        }

        return sb;
    }
}
