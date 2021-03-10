package businessLayer;

public class BaseProduct extends MenuItem{

	private double price;
	
	public BaseProduct( int id, String name, double price, boolean type) {
		super( id, name, type);
		this.price = price;
		
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double computePrice() {
		return this.price;
	}
	
	
	
}
