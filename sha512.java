import java.util.Scanner;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class sha512 {
    public sha512(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("SHA512 ENCRYPTION MODE");
    }

    public String takeInput(){
        System.out.printf("Enter a string: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public String encode(){
        String password = takeInput();
        final byte[] defaultBytes = password.getBytes();
        try {
            final MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public void printHash(){
        System.out.println("SHA512: " + encode());
    }
    public static  void main (String [] args ){
        sha512 sha512Obj = new sha512();
        sha512Obj.printHash();
    }
}
