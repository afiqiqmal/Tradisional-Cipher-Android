package com.cipher.tradisional.tradiosionalcipherexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cipher.tradisional.library.CaesarCipher;
import com.cipher.tradisional.library.OddEvenCaesar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String enc = OddEvenCaesar.Encode("Hello World",3);
        String dec = OddEvenCaesar.Decode(enc,3);

        //iterate all posible value
        List<String> decodeNoKey = OddEvenCaesar.DecodeNoKey(enc);


    }
}
