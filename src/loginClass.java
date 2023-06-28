import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class loginClass {

    public static void login(Path p1) throws IOException, NoSuchAlgorithmException {
        //prompt for the users username
        Scanner enterUsername = new Scanner(System.in); //create scanner
        System.out.println("Enter Username: ");
        String username = enterUsername.nextLine();

        //see if username exists in user directory
        File directory = new File(p1.toString());//create path
        File[] userList = directory.listFiles(); //array of files

        if (userList != null) {
            boolean found = false; //fixes multiple print no user message
            for (File file : userList) {
                //if username is a match
                if (file.getName().equals(username)) {

                    //prompt for password
                    Scanner enterPassword = new Scanner(System.in);
                    System.out.println("Enter Password: ");
                    String password = enterPassword.nextLine();

                    //hash passcode for login check
                    Encryptor encryptor = new Encryptor();
                    String encryptedPassword = encryptor.encryptString(password);

                    //see if password exists in username file
                    String filePath = file.getPath();
                    File openFile = new File(filePath);

                    BufferedReader reader = null;
                    try {
                        reader = new BufferedReader(new FileReader(openFile)); //open file
                        String line = reader.readLine(); //read passcode
                        if (line.equals(encryptedPassword)) {
                            System.out.println("Successfully Logged In");
                        } else {
                            System.out.println("Incorrect Password. Please Login Again");
                        }
                    } catch (IOException e) {
                        e.getStackTrace();
                    } finally {
                        if (reader != null) {
                            reader.close();
                        }
                    }

                    //set bool to true
                    found = true;

                }
            }
            if (!found) {
                System.out.println("Username Does Not Exist. Try Registering");
            }

        }
    }
}
