package com.cipher.tradisional.tradiosionalcipherexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cipher.tradisional.library.AffineCipher;
import com.cipher.tradisional.library.CaesarCipher;
import com.cipher.tradisional.library.OneTimePadCipher;
import com.cipher.tradisional.library.RailFenceCipher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String plainText = "Hello World Tradisional Cipher";
        int key = 4;


        AffineCipher.setWhiteSpaceReplacement('A');


    }
}
