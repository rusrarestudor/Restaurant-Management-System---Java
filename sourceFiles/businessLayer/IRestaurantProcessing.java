package businessLayer;

import java.util.ArrayList;
import java.util.Date;

public interface IRestaurantProcessing {

	public void createNewMenuItem( int id, String name, double price, ArrayList<MenuItem> ingredients);
	
	public void deleteMenuItem(String Name);
	
	public void editMenuItem(int id, String name, double price, ArrayList<MenuItem> ingredients);

	public Order createNewOrder(int id, Date date, int table, ArrayList<MenuItem> menue);
	
	public double computePrice(Order ord);
	
	public void generateBill(int orderd, String date, int tableNr, double price);
	
	public void serialRestaurant();
	
	public ArrayList<MenuItem> getItemList();
	
}
