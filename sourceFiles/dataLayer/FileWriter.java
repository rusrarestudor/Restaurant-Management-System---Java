package dataLayer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {	
	public static void createBill(int order, String date, int tableNb, double price) {
		File file = new File("Bill" + order + ".txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
				PrintWriter pw = new PrintWriter(file);
				pw.println("                                     --- Bill at Restaurant ---");
				pw.println("                                              Nb. " + order);
				pw.println();
				pw.println();
				pw.println();
				pw.println("Order at the table" + tableNb +"............................................" + price + "$" );
				pw.println();
				pw.println();
				pw.println();
				pw.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
				pw.println();
				pw.println("**this bill was created on**");
				pw.println("  " + date);
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
