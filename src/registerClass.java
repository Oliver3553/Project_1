import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import static java.lang.System.in;


public class registerClass {

    public static void register(Path p1) throws IOException, NoSuchAlgorithmException {
        Scanner registerName = new Scanner(in);
        System.out.println("Enter a username: ");
        String username = registerName.nextLine();

        String password;
        int length;
        do {
            Scanner registerPassword = new Scanner(System.in); //create scanner
            System.out.println("Input Desired Password (min 8 characters): ");
            password = registerPassword.nextLine();
            length = password.length();
        } while (length < 7);

        //hash passcode to be saved
        Encryptor encryptor = new Encryptor();
        String encryptedPassword = encryptor.encryptString(password);

        //create dir if one does not exist
        new File(p1.toString()).mkdirs();

        //save username as name of file and save password inside it
        Writer writer = null;
        try {
            File file = new File(p1 + "/" + username);
            writer = new FileWriter(file); //create writer to write file to directory titled username
            writer.write(encryptedPassword); //write in username
            System.out.println("Registration Complete");
        } catch (IOException e) {
            e.getStackTrace(); //catch IOException
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

}
