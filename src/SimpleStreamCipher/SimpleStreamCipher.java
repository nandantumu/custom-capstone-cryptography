package SimpleStreamCipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by Nandan on 12/14/2015.
 */
public class SimpleStreamCipher {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a key. If it's your first time, make one up.");
        Random PRNG = new Random(Long.parseLong(bufferedReader.readLine()));
        System.out.println("Would you like to encrypt or decrypt? Enter E/D");
        String userChoice = bufferedReader.readLine();
        if(userChoice.equalsIgnoreCase("e")){
            System.out.println("Enter plaintext.");
            String pltxt = bufferedReader.readLine();
            byte[] binarypltxt = new BigInteger(pltxt.getBytes()).toByteArray();
            byte[] cryptarray = new byte[binarypltxt.length];
            System.out.println(binarypltxt);
            PRNG.nextBytes(cryptarray);
            for (int i = 0; i <binarypltxt.length ; i++) {
                binarypltxt[i] ^= cryptarray[i];
            }
            String ciphertext = new String(binarypltxt);
            System.out.println(ciphertext);
        }
        else if(userChoice.equalsIgnoreCase("d")){
            System.out.println("Enter ciphertext");
            String citxt = bufferedReader.readLine();
            byte[] binarycitxt = new BigInteger(citxt.getBytes()).toByteArray();
            byte[] cryptarray = new byte[binarycitxt.length];
            System.out.println(binarycitxt);
            PRNG.nextBytes(cryptarray);
            for (int i = 0; i <binarycitxt.length ; i++) {
                binarycitxt[i] ^= cryptarray[i];
            }
            String plaintext = new String(binarycitxt);
            System.out.println(plaintext);
        }
        else {
            System.out.println("Enter a valid option and try again.");
        }
        System.out.println("Thanks for using this simple stream encryption class!");
    }
}
