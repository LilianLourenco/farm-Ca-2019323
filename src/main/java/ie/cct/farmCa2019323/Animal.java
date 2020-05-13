package ie.cct.farmCa2019323;

public class Animal {
	String type;
	float price;
	float weight;
	public Animal() {
		super();
	}
	public Animal(String type, float price, float weight) {
		super();
		this.type = type;
		this.price = price;
		this.weight = weight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Animal [type=" + type + ", price=" + price + "]";
	}
	
	

}
