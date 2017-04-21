# Tradisional Cipher Android
Simple tradisional cipher for encryption and decryption Android 


### Contain:
1. Affine Cipher
2. Caesar Cipher
3. Odd and Even Caesar Cipher
4. Kamasutra Cipher
5. One Time Pad Cipher
6. Poly AlphabetSubstitution Cipher
7. Rail Fence Cipher
8. Vigenere Cipher



### Usage

1. Affine Cipher
```java

AffineCipher.setWhiteSpaceReplacement('P'); //Optional
String enc = AffineCipher.encrypt("Hello World",17,20);
String dec = AffineCipher.decrypt(enc,17,20);

```

2. Caesar Cipher
```java

String enc = CaesarCipher.leftEncode("Hello World",3);
String dec = CaesarCipher.rightDecode(enc,3);

String enc = CaesarCipher.rightEncode("Hello World",3);
String dec = CaesarCipher.leftDecode(enc,3);

```

3. Odd and Even Caesar Cipher
```java

String enc = OddEvenCaesar.Encode("Hello World",3);
String dec = OddEvenCaesar.Decode(enc,3);
        
//iterate all posible value
List<String> decodeNoKey = OddEvenCaesar.DecodeNoKey(enc);

```


Refer to[Here](https://programmingcode4life.blogspot.my/search?q=cipher)
