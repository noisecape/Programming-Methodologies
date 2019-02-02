package unifi.ShopOnline;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Pack extends ShopOnline{
	private double total;
	private String name;
	private LinkedList<ShopOnline> products;
	
	public Pack(String name){
		products = new LinkedList<ShopOnline>();
		total = 0;
		this.name = name;
	}
	
	@Override
	public void addItem(ShopOnline p) throws Exception {
		products.add(p);
	}

	@Override
	public void removeItem(ShopOnline p) throws Exception {
		products.remove(p);
	}

	@Override
	public void printProducts() throws Exception {
		Iterator<ShopOnline> iterator = products.iterator();
		while(iterator.hasNext()){
			ShopOnline current = iterator.next();
			current.printProducts();
		}
	}

	@Override
	public double getTotal() throws Exception {
		if(total != 0){
			return total;
		}else{
			computeTotal();
			return total;
		}
	}

	public String getName(){
		return name;
	}

	@Override
	public double computeTotal() throws Exception {
		Iterator<ShopOnline> iterator = products.iterator();
		while(iterator.hasNext()){
			ShopOnline current = iterator.next();
			total += current.getTotal();
		}
		return total;
	}

	@Override
	public double perfomDiscountStrategy() throws Exception {
		System.out.println("Discounted price: "+getTotal());
		total = discount.applyDiscount(this);
		return total;
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
		Collections.sort(products, new CompareByPrice());
		System.out.print("REPORT CATALOGUE: "+"\n"+"The most expensive item is: "+products.getLast()+" -> "+products.getLast().getTotal()+" €"+"\n");
		return products.getLast().getTotal();
	}

	@Override
	public double reportMinPrice() throws Exception {
		Collections.sort(products, new CompareByPrice());
		System.out.print("REPORT CATALOGUE: "+"\n"+"The cheaper item is: "+products.getFirst()+" -> "+products.getFirst().getTotal()+" €"+"\n");
		return products.getFirst().getTotal();
	}
}
