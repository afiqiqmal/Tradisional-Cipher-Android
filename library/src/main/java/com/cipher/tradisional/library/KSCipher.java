package com.cipher.tradisional.library;

import java.util.Random;

/**
 * @author : hafiq on 20/04/2017.
 */

public class KSCipher {

    public static String MakeKSutra(String text,String key){
        int keyLen = key.length()/2;

        // arrange random key
        char[][] keyRow = new char[2][keyLen];
        int count=0;
        for(int x=0;x<2;x++){
            for(int y=0;y<keyLen;y++){
                keyRow[x][y] = key.charAt(count);
                System.out.print(keyRow[x][y]+" ");
                count++;
            }
            System.out.println();
        }

        String sb = "";

        for(int x=0;x<text.length();x++){
            for(int y=0;y<2;y++){
                for(int z=0;z<keyLen;z++){
                    if(y == 0){
                        if(text.charAt(x) == keyRow[y][z])
                            sb += keyRow[y+1][z];
                    }
                    else if (y == 1){
                        if(text.charAt(x) == keyRow[y][z])
                            sb += keyRow[y-1][z];
                    }
                }
            }
            if(text.charAt(x) == ' ')
                sb += text.charAt(x);
        }

        return sb;
    }
}
