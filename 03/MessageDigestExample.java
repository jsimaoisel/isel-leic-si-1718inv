import java.security.*;
import java.util.*;
import java.io.*;

public class MessageDigestExample {

    public static void main(String[] args) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        FileInputStream fin = new FileInputStream(args[0]);
        int nread = 0;
        byte buf[] = new byte[1024];
        while ((nread = fin.read(buf)) != -1) {
            sha.update(buf, 0, nread);
        }
        byte[] digest = sha.digest();
        System.out.print("SHA1(" + args[0] + ") = ");
        for(int i=0; i<digest.length; ++i) {
            System.out.print(String.format("%1$02x",digest[i]));
        }
    }

}