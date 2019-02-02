package unifi.ShopOnline;

public class ElderDiscount implements DiscountStrategy{

	@Override
	public double applyDiscount(ShopOnline p) throws Exception {
		double discount = (p.getTotal()*8)/100;
		return p.getTotal()-discount;
	}

}
