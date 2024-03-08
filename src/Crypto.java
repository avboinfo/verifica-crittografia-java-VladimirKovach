import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Crypto {
    
    public static String Cesar(String data, int shift) {
        StringBuilder output = new StringBuilder(data.length());
        for (char singleChar : data.toCharArray()) {
            int shiftedChar = (int) (singleChar + shift) % 256;
            output.append((char) shiftedChar);
        }
        return output.toString();
    }

    public static String decryptCesar(String data, int shift) {
        String output = Cesar(data, -shift);
        return output;
    }

    public static String XOR(String data, String key) {
        String output = "";
        
        for (int i = 0; i < data.length();) {
            for (int j = 0; j < key.length() && i < data.length(); j++, i++) {
                char k = key.charAt(j); // Single Char Key
                char d = data.charAt(i); // Single Char Data

                char xorChar = (char) (d ^ k);
                output += xorChar;
            }
        }
        return output;
    }

    public static String decryptXOR(String data, String shift) {
        String output = XOR(data, shift);
        return output;
    }

    public static String ReadFile() {
        String strings = "";
        try {
            File f = new File("static/data.txt");
            Scanner read = new Scanner(f);

            while(read.hasNextLine()) {
                String str = read.nextLine();
                strings = strings + str + "\n";
            }
            read.close();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return strings;
    }

    public static String WriteFile(String data) {
        String strings = "";
        try {
            File f = new File("static/data.txt");
            PrintWriter writer = new PrintWriter(f);

            writer.print(data);
            writer.close();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return strings;
    }
}