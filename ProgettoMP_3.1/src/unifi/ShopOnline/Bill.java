package unifi.ShopOnline;
import java.util.LinkedList;

public class Bill implements Observer{
	private LinkedList<ShopOnline> products;
	
	public Bill(ShopOnline p) throws Exception{
		p.registerObserver(this);
		products = new LinkedList<ShopOnline>();
	}

	@Override
	public void update(ShopOnline p) throws Exception{
		products = p.getProductsInCart();
		printBill();
	}
	
	public void printBill(){
		System.out.println("ADDED TO BILL: "+products.getLast().toString());
	}
	
}
