import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import unifi.ShopOnline.*;
public class PaymentTest {

	private PaymentProcess payment;
	private ShopOnline cart;
	private ShopOnline pack;
	private ShopOnline iPhone;
	private ShopOnline iPad;
	private ShopOnline earPods;
	
	@Before
	public void initPayment() throws Exception{
		cart = new Cart();
		iPad = new Item("iPad",499);
		iPhone = new Item("iPhone",799);
		earPods = new Item("Ear pods",29);
		pack = new Pack("XMAS PACK");
		
		pack.addItem(iPhone);
		pack.addItem(earPods);
		cart.addItem(pack);
		cart.addItem(iPad);
		cart.addItem(iPhone);
		payment = new CreditCard("Tommaso","Capecchi","123456789");
		payment.setCart(cart);
	}
	
	@Test
	public void acceptPayment() throws Exception {
		boolean actual = payment.acceptPayment();
		boolean expected = true;
		assertEquals(expected,actual);
	}

}
