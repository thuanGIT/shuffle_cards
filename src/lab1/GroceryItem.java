package lab1;

public class GroceryItem {
	private String name;
	private String category;
	private int quantity;
	
	//constructor
	public GroceryItem(String name, String category, int quantity) {
		this.name = name;
		this.category = category;
		this.quantity = quantity;
	}
	
	//getter methods
	public String getName() { return name; }
	public String getCategory() { return category; }
	public int getQuantity() { return quantity; }
	
	//setter methods
	public void setName(String name) { this.name = name; }
	public void setCategory(String category) { this.category = category; }
	public void setQuantity(int quantity) { this.quantity = quantity; }		
	
	//toString method, e.g. "2 bagel (bakery)"
	@Override
	public String toString() {
		return quantity+" "+name+" ("+category+")";
	}
}