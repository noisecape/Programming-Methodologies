package unifi.ShopOnline;
import java.util.LinkedList;

public abstract class ShopOnline implements Subject{
	
	DiscountStrategy discount;
	
	public void setDiscountStrategy(DiscountStrategy newStrategy){
		discount = newStrategy;
	}
	
	public abstract double reportMaxPrice()throws Exception;
	
	public abstract double reportMinPrice()throws Exception;
	
	public abstract double  perfomDiscountStrategy()throws Exception;
	
	public abstract void addItem(ShopOnline p)throws Exception;
	
	public abstract void removeItem(ShopOnline p)throws Exception;
	
	public abstract void printProducts()throws Exception;
	
	public abstract double getTotal()throws Exception;
	
	public abstract double computeTotal()throws Exception;
	
	public abstract String getName()throws Exception;
	
	public abstract LinkedList<ShopOnline> getProductsInCart()throws Exception;
	
}
