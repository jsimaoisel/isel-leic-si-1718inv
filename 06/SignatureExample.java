import java.security.*;

public class SignatureExample {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        KeyPair pair = gen.generateKeyPair();

        byte[] msg = "hello world".getBytes();

        Signature signatureAlgorithm = Signature.getInstance("SHA1withRSA");
        signatureAlgorithm.initSign(pair.getPrivate());
        signatureAlgorithm.update(msg);
        byte[] signature = signatureAlgorithm.sign();

        // send: msg + signature
        ////////////////////////////////
        // change message
        // msg[0] = (byte) (msg[0] ^ 0x01);

        signatureAlgorithm.initVerify(pair.getPublic());
        signatureAlgorithm.update(msg);
        boolean result = signatureAlgorithm.verify(signature);
        System.out.println(result);
    }
}
