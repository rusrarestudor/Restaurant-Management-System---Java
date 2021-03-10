package dataLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import businessLayer.Restaurant;

public class RestaurantSerializator {
	
	public static void serializeObject(Restaurant rest) {
		FileOutputStream file;
		try {
			file = new FileOutputStream("file");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(rest);
			out.close();
			file.close();		
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch(IOException e) { 
			System.out.println("IOException is caught for output");
		}		
	}
	
	public static Restaurant deserializeObject() {
		Restaurant r = new Restaurant();
		try {
			FileInputStream file = new FileInputStream("file");
			ObjectInputStream in = new ObjectInputStream(file);
			r = (Restaurant)in.readObject();
			in.close();
			file.close();
		}catch(IOException e) 
		{
			System.out.println("IOException is caught for input");

		}
		 catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
		return r;
	}

}
