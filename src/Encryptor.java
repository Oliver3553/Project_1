import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
    public String encryptString(String input) throws NoSuchAlgorithmException {

        //Message Digest for SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1, encodedHash);
        return bigInt.toString(16);

    }
}
