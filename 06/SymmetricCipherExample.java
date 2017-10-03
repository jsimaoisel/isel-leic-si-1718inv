import java.security.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

class SymmetricCipherExample {

    public static void main(String[] args) throws Exception {
        KeyGenerator gen = KeyGenerator.getInstance("AES");
        SecretKey key = gen.generateKey();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] msg = "hello world".getBytes();
        byte[] cryptogram = cipher.doFinal(msg);

        System.out.println("Plain text length = " + msg.length);
        System.out.println("Cipher text length = " + cryptogram.length);
    }
}