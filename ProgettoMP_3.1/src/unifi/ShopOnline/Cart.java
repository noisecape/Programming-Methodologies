package unifi.ShopOnline;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Cart extends ShopOnline{
	private double total;
	private LinkedList<ShopOnline> products;
	private LinkedList<Observer> observers;
	
	public Cart(){
		total = 0;
		products = new LinkedList<ShopOnline>();
		observers = new LinkedList<Observer>();
	}

	@Override
	public void addItem(ShopOnline p) throws Exception {
		products.add(p);
		notifyObserver();
	}

	@Override
	public void removeItem(ShopOnline p) throws Exception {
		products.remove(p);
	}

	@Override
	public void printProducts() throws Exception {
		System.out.println("----------------"+"\n"+"CART: "+"\n");
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
			total = computeTotal();
			return total;
		}
	}

	@Override
	public String getName() throws Exception {
		throw new Exception("ERROR UNABLE TO GET NAME");
	}

	@Override
	public double computeTotal() throws Exception {
		Iterator<ShopOnline> iterator = products.iterator();
		while(iterator.hasNext()){
			ShopOnline current = iterator.next();
			total += current.getTotal();
		}
		System.out.println("TOTAL: "+total);
		return total;
	}

	@Override
	public double perfomDiscountStrategy() throws Exception {
		total = discount.applyDiscount(this);
		System.out.println("DISCOUNTED TOTAL: " + total);
		return total;
	}

	@Override
	public LinkedList<ShopOnline> getProductsInCart() throws Exception {
		return products;
	}
	
	@Override
	
	public void registerObserver(Observer o)throws Exception{
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o)throws Exception{
		observers.remove(o);
	}

	@Override
	public void notifyObserver() throws Exception{
		for(Observer o : observers){
			o.update(this);
		}
	}
	
	@Override
	public double reportMaxPrice() throws Exception {
		Collections.sort(products, new CompareByPrice());
		System.out.print("REPORT CATALOGUE: "+"\n"+"The most expensive item is: "+products.getLast()+" -> "+products.getLast().getTotal()+" €"+"\n");
		double rst = products.getLast().getTotal();
		return rst;
	}

	@Override
	public double reportMinPrice() throws Exception {
		Collections.sort(products, new CompareByPrice());
		System.out.print("REPORT CATALOGUE: "+"\n"+"The cheaper item is: "+products.getFirst()+" -> "+products.getFirst().getTotal()+" €"+"\n");
		double rst = products.getFirst().getTotal();
		return rst;
	}

}
