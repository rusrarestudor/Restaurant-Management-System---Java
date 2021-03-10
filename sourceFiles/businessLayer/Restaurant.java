package businessLayer;

import presentationLayer.*;
import dataLayer.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant implements IRestaurantProcessing, java.io.Serializable {
	
	private List<MenuItem> menu = new ArrayList<MenuItem>();
	private Map<Order, ArrayList<MenuItem>> orderInf = new HashMap();
	
	@Override
	public void createNewMenuItem( int id, String name, double price, ArrayList<MenuItem> ingredients) {
		assert name != null;
		assert price != 0;
		assert id != 0;
		MenuItem item;
		int sizeIng = ingredients.size();
		if( sizeIng != 0)
			item = new CompositProduct( id, name, price, ingredients, true);
		else			
			item = new BaseProduct( id, name, price, false);
		menu.add(item);
		int size = menu.size();
		assert size == menu.size() - 1;
	}

	@Override
	public void deleteMenuItem(String name) {
		assert name != null;
		int  size = menu.size();
		for(int i = 0; i < size; i++) {
			if(menu.get(i).name.equals(name))
				menu.remove(i);
		}
	}

	@Override
	public void editMenuItem(int id, String name, double price, ArrayList<MenuItem> ingredients) {
		assert name != null;
		assert price != 0;
		assert id != 0;
		boolean found = false;
		if(ingredients.size() == 0)
		{
			for(int i = 0; i < menu.size(); i++) 
				if(menu.get(i).name.equals(name))
				{
					menu.remove(i);
					createNewMenuItem( id, name, price, ingredients);
				}			
		}
		else if(ingredients.size() != 0)
		{
			for(int i = 0; i < menu.size(); i++)
				if(menu.get(i).name.equals(name))
				{
					menu.remove(i);
					createNewMenuItem( id, name, price, ingredients);
				}
		}
		else
			System.out.println("No item with given name");
	}

	@Override
	public Order createNewOrder(int id, Date date, int table, ArrayList<MenuItem> menue) {
		assert id != 0;
		assert table != 0;
		Order order = new Order(id, date, table);
		orderInf.put(order, menue);		
		return order;
	}

	@Override
	public double computePrice(Order ord) {
		assert ord != null;
		ArrayList<MenuItem> ingred = new ArrayList<MenuItem>();
		ingred = orderInf.get(ord);
		double price = 0;
		for(int i = 0; i < ingred.size(); i++) 		
			price = price + ingred.get(i).computePrice();
		return price;
	}

	@Override
	public void generateBill(int order, String date, int tableNr, double price) {
		FileWriter.createBill(order, date, tableNr, price);
	}

	@Override
	public void serialRestaurant() {
		RestaurantSerializator.serializeObject(this);
	}

	@Override
	public ArrayList<MenuItem> getItemList() {
		return (ArrayList<MenuItem>) this.menu;
	}

}
