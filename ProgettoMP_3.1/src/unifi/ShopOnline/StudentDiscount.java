package unifi.ShopOnline;

public class StudentDiscount implements DiscountStrategy {

	@Override
	public double applyDiscount(ShopOnline p) throws Exception {
		double discount = (p.getTotal()*6)/100;
		return p.getTotal()-discount;
	}
	
}
