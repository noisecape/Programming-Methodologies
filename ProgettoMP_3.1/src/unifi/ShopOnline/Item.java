package unifi.ShopOnline;
import java.util.LinkedList;

public class Item extends ShopOnline{

	private String name;
	private double price;
	
	public Item(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void addItem(ShopOnline p) throws Exception {
		throw new Exception("ERROR ADDING ITEM");
	}

	@Override
	public void removeItem(ShopOnline p) throws Exception {
		throw new Exception("ERROR REMOVING ITEM");
	}

	@Override
	public void printProducts() throws Exception {
		System.out.println("-"+getName()+" --> "+getTotal()+" €");
	}

	@Override
	public double getTotal() throws Exception {
		return price;
	}

	@Override
	public double computeTotal() throws Exception {
		throw new Exception("ERROR UNABLE TO COMPUTE TOTAL");
	}

	@Override
	public double perfomDiscountStrategy() throws Exception {
		System.out.println("Discounted price of "+getName()+": "+getTotal());
		price = discount.applyDiscount(this);
		return price;
	}

	@Override
	public LinkedList<ShopOnline> getProductsInCart() throws Exception {
		throw new Exception("ERROR UNABLE TO RETURN PRODUCTS IN CART");
	}
	
	@Override
	public void registerObserver(Observer o) throws Exception {
		throw new Exception("ERROR UNABLE TO ADD OBSERVER TO THE LIST");
	}

	@Override
	public void removeObserver(Observer o) throws Exception {
		throw new Exception("ERROR UNABLE TO REMOVE OBSERVER TO THE LIST");
	}

	@Override
	public void notifyObserver() throws Exception {
		throw new Exception("ERROR UNABLE TO NOTIFY OBSERVER TO THE LIST");
	}
	
	public String toString(){
		return getName();
	}
	
	@Override
	public double reportMaxPrice() throws Exception {
		throw new Exception("ERROR REPORTING MAX PRICE");
	}

	@Override
	public double reportMinPrice() throws Exception {
		throw new Exception("ERROR REPORTING MIN PRICE");
	}
	
}
