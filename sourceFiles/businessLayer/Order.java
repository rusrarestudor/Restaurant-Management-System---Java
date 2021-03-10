package businessLayer;

import java.util.Date;

public class Order {
	private int orderID;
	private Date date;
	private int table;
	
	public Order(int orderID, Date date, int table) {
		this.orderID = orderID;
		this.date = date;
		this.table = table;
	}

	public int getId() {
		return this.orderID;
	}
	
	public void setId(int id) {
		this.orderID = id;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getTable() {
		return this.table;
	}
	
	public void setTable(int table) {
		this.table = table;
	}
	
	@Override
	public int hashCode(){
		int result = 1;
		result = 7 * result + date.hashCode();
		result = 7 * result + orderID;
		result = 7 * result + table;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if (this == obj)
			return true;
		
		if (getClass() != obj.getClass())
			return false;
		
		Order other = (Order) obj;		
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;		
		if (orderID != other.orderID)
			return false;		
		if (table != other.table)
			return false;
		return true;
	}
}
