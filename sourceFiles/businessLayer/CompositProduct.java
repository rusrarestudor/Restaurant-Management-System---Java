package businessLayer;

import java.util.ArrayList;
import java.util.List;

public class CompositProduct extends MenuItem{
	
	private List<MenuItem> ingredients;
	private double price;
	
	public CompositProduct(int id, String name, double price, List<MenuItem> ingredients, boolean type) {
		super(id, name, type);
		this.ingredients = ingredients;
		this.price = price;
	}	
	
	public void addIngredients(MenuItem ing) {
		this.ingredients.add(ing);
	}
	
	
	public double computePrice() {
		double price = 0;
		for(int i = 0; i < ingredients.size(); i++)
			price = price + ingredients.get(i).computePrice();
		return price;
	}

	public void deleteIngredient(String name) {
		for(int i = 0; i < ingredients.size(); i++) 
			if(ingredients.get(i).getName().equals(name))
				ingredients.remove(i);
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
}
