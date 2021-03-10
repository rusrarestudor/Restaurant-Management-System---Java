package businessLayer;

public abstract class MenuItem implements java.io.Serializable {
	
	protected int id;
	protected String name;
	protected boolean type;

	public MenuItem(int id, String name, boolean type) {
		this.name = name;
		this.id = id;
		this.type = type;
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean getType() {
		return this.type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public abstract double computePrice();
}