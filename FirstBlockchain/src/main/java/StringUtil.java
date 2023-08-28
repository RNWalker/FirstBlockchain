//messageDigest provides functionality for
// cryptographic message digests, which are commonly
// used for generating hash values from input data.
import java.security.MessageDigest;

public class StringUtil {

//    applies Sha256 to a string and returns the result.

    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("Sha-256");
//            applies sha256 to our input
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            // Create a StringBuffer to store the hash as hexadecimal
            StringBuffer hexString = new StringBuffer(); // this will contain hash as hexidecimal
            // Convert each byte of the hash into a hexadecimal representation
            for (int i = 0; i < hash.length ; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0'); // Add a leading zero if necessary
                hexString.append(hex);

            }
            // Return the hash as a hexadecimal string
            return hexString.toString();
        }
        catch(Exception e){
            // Wrap any exceptions in a RuntimeException
            throw new RuntimeException(e);
        }
    }


    }



