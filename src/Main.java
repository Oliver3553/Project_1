import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    static Path p1 = Paths.get(".\\src\\Users\\");

    public static void main(String[] args) {

        String answerUpperCase;
        do {
            Scanner prompt = new Scanner(System.in);
            System.out.println("Input desired action: Login / Register");

            String answer = prompt.nextLine();
            answerUpperCase = answer.toUpperCase();
        } while (!answerUpperCase.equals("REGISTER") && !answerUpperCase.equals("LOGIN"));

        if (answerUpperCase.equals("LOGIN")) {
            try {
                loginClass.login(p1);
            } catch (IOException | NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        } else if (answerUpperCase.equals("REGISTER")) {
            try {
                registerClass.register(p1);
            } catch (IOException | NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Error, please make sure its spelt correctly");
        }
    }

}

