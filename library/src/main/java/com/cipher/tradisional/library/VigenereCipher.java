package com.cipher.tradisional.library;

/**
 * @author : hafiq on 20/04/2017.
 */

public class VigenereCipher{

    private static char whiteSpaceReplacement = 'X';

    public static  void setWhiteSpaceReplacement(char whiteSpaceReplacement) {
        VigenereCipher.whiteSpaceReplacement = whiteSpaceReplacement;
    }

    public static String VCEncryptionWork(String text,String key){

        String alphaL = "abcdefghijklmnopqrstuvwxyz";
        String alphaU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String reKey = "";
        int len = text.length();

        // rearrange the key
        int mv=0;
        int count=0;
        for(int x=0;x<len;x++){
            if(mv == key.length()){
                count=0;
                mv=0;
            }
            reKey = reKey + key.charAt(count);
            count++;
            mv++;
        }

        //create venigher table
        char [][] vcl = new char[26][26];
        char [][] vcu = new char[26][26];

        //using caesar cipher algorithm to form table
        for(int x=0;x<26;x++){
            count=x;
            for(int y=0;y<26;y++){
                vcl[x][y] = (char) ('a' + count % 26 );
                vcu[x][y] = (char) ('A' + count % 26 );
                count++;
            }
        }

        //encrypting
        String sb = "";
        for(int x=0;x<len;x++){
            if(Character.isUpperCase(text.charAt(x))){
                int srow  = alphaU.indexOf(Character.toUpperCase(reKey.charAt(x)));
                int scol = alphaU.indexOf(text.charAt(x));
                sb = sb + vcu[srow][scol];
            }
            else if (Character.isLowerCase(text.charAt(x))){
                int srow  = alphaL.indexOf(Character.toLowerCase(reKey.charAt(x)));
                int scol = alphaL.indexOf(text.charAt(x));
                sb = sb + vcl[srow][scol];

            }
            else{
                //can be replace with any random alpha or null space or get from original text
                sb = sb + whiteSpaceReplacement;
            }

        }

        return sb;
    }

    public static String VCDecryption(String text,String key){

        String alphaL = "abcdefghijklmnopqrstuzwxyz";
        String alphaU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String reKey = "";
        int len = text.length();

        // rearrange the key
        int mv=0;
        int count=0;
        for(int x=0;x<len;x++){
            if(mv == key.length()){
                count=0;
                mv=0;
            }
            reKey = reKey + key.charAt(count);
            count++;
            mv++;
        }

        //create venigher table
        char [][] vcl = new char[26][26];
        char [][] vcu = new char[26][26];

        //using caesar cipher algorithm to form table
        for(int x=0;x<26;x++){
            count=x;
            for(int y=0;y<26;y++){
                vcl[x][y] = (char) ('a' + count % 26 );
                vcu[x][y] = (char) ('A' + count % 26 );
                count++;
            }
        }

        //decrypting
        String sb = "";
        for(int x=0;x<len;x++){
            if(Character.isUpperCase(text.charAt(x))){
                for(int y=0;y<26;y++){
                    int scol  = alphaU.indexOf(reKey.charAt(x));
                    if(vcu[y][scol] == text.charAt(x)){
                        sb = sb + (char) ('A' + y % 26 );
                    }
                }
            }
            else if(Character.isLowerCase(text.charAt(x))){
                for(int y=0;y<26;y++){
                    int scol  = alphaL.indexOf(Character.toLowerCase(reKey.charAt(x)));
                    if(vcl[y][scol] == text.charAt(x)){
                        sb = sb + (char) ('a' + y % 26 );
                    }
                }
            }
            else{
                sb = sb+text.charAt(x);
            }
        }
        return sb;
    }
}