import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String data = "";
        String key = "12";
        boolean b = true;
        while (b == true) {
            System.out.println("******** OPZIONI del MENU ************************");
            System.out.println("1. Cripta il contenuto");
            System.out.println("2. Decripta il contenuto");
            System.out.println("3. Stampa il contenuto");

            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            int n = Integer.valueOf(option);
            boolean wasCrypted = false;
            switch (n) {
              case 1:
                data = Crypto.ReadFile();
                data = Crypto.Cesar(data, Integer.parseInt(key));
                data = Crypto.XOR(data, key);
                Crypto.WriteFile(data);
                wasCrypted = true; 
                break;
              case 2:
                if(wasCrypted == true) { //Se non funziona, è colpa di wasCrypted, volevo fare che se il messagio non è stato crittato prima non fa niente, pero non avevo gia tempo e il PC era troppo lento
                    data = Crypto.decryptXOR(data, key);
                    data = Crypto.decryptCesar(data, Integer.parseInt(key));
                    Crypto.WriteFile(data);
                }
                break;
              case 3:
                System.out.println(data);
                b = false;
                break;
            }  
        }
    }
}


