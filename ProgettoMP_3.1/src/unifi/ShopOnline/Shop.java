package unifi.ShopOnline;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


public class Shop extends ShopOnline{
	private String name;
	private LinkedList<ShopOnline> products;
	
	public Shop(String name){
		this.name = name;
		products = new LinkedList<ShopOnline>();
	}
	
	public void addItem(ShopOnline p){
		products.add(p);
	}
	
	public void removeItem(ShopOnline p){
		products.remove(p);
	}

	public void printProducts() throws Exception{
		System.out.println("PRODUCTS: "+"\n");
		Iterator<ShopOnline> iterator = products.iterator();
		while(iterator.hasNext()){
			ShopOnline current = iterator.next();
			current.printProducts();
		}
	}
	@Override
	public double getTotal() throws Exception{
		throw new Exception("ERROR UNABLE TO RETURN TOTAL");
	}

	@Override
	public String getName() throws Exception {
		return name;
	}

	@Override
	public double computeTotal() throws Exception {
		throw new Exception("ERROR UNABLE TO COMPUTE TOTAL");
	}

	@Override
	public double perfomDiscountStrategy() throws Exception {
		throw new Exception("ERROR UNABLE TO PERMFORM DISCOUNT");
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

	@Override
	public double reportMaxPrice() throws Exception {
		Collections.sort(products, new CompareByPrice());
		System.out.print("REPORT SHOP: "+"\n"+"The most expensive item is: "+products.getLast()+" -> "+products.getLast().getTotal()+" €"+"\n");
		return products.getLast().getTotal();
	}

	@Override
	public double reportMinPrice() throws Exception {
		Collections.sort(products, new CompareByPrice());
		System.out.print("REPORT SHOP: "+"\n"+"The cheaper item is: "+products.getFirst()+" -> "+products.getFirst().getTotal()+" €"+"\n");
		return products.getFirst().getTotal();
	}

}
