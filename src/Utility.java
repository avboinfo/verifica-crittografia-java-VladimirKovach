import java.util.Scanner;

public class Utility {
	
	public static int like = 0;
	
	public static int scegli( String[] opzioni ) {
		like++;
		int nscelta, nopzioni=opzioni.length;
		String scelta;
		Scanner lettore = new Scanner(System.in);
		System.out.println("******** OPZIONI del MENU ************************");
		for (int i=1; i<nopzioni+1; i++) {
			System.out.println("[" + i + "]\t" + opzioni[i]);
		}
		while (true) {
			scelta = lettore.nextLine();
			try {
				nscelta = Integer.parseInt(scelta);
				if (nscelta<0 || nscelta>=nopzioni) {
					System.out.println("Sono validi sono le ozioni da 0 a " + (nopzioni-1));
				} else break;
			} catch (Exception ex) {
				System.out.println("Fai il serio e scrivi un numero!");
			}
		}
		return nscelta;
	}

}