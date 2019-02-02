import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import unifi.ShopOnline.Cart;
import unifi.ShopOnline.*;

public class CartTest {
	private ShopOnline cart;
	private ShopOnline pack;
	private ShopOnline iPhone;
	private ShopOnline iPad;
	private ShopOnline earPods;
	private DiscountStrategy student;
	private DiscountStrategy elder;
	
	@Before
	public void initCartTest() throws Exception{
		cart = new Cart();
		iPad = new Item("iPad",499);
		iPhone = new Item("iPhone",799);
		earPods = new Item("Ear pods",29);
		pack = new Pack("XMAS PACK");
		
		pack.addItem(iPhone);
		pack.addItem(earPods);
		cart.addItem(pack);
		cart.addItem(iPad);
		student = new StudentDiscount();
		elder = new ElderDiscount();
	}
	
	@Test
	public void reportMaxPrice() throws Exception {
		double actual = cart.reportMaxPrice();
		double expected = 828;
		assertEquals(expected,actual,0);
	
	}
	
	@Test
	public void reportMinPrice() throws Exception {
		double actual = cart.reportMinPrice();
		double expected = 499;
		assertEquals(expected,actual,0);
	}
	
	@Test
	public void performDiscountStrategyStudent() throws Exception {
		cart.setDiscountStrategy(student);
		double actual = cart.perfomDiscountStrategy();
		double expected = 1247.38;
		assertEquals(expected,actual,0);
	}
	
	@Test
	public void performDiscountStrategyElder() throws Exception {
		cart.setDiscountStrategy(elder);
		double actual = cart.perfomDiscountStrategy();
		double expected = 1220.84;
		assertEquals(expected,actual,0);
	}
	
	@Test
	public void getTotal() throws Exception {
		double actual = cart.getTotal();
		double expected = 1327;
		assertEquals(expected,actual,0);
	}
	
	@Test
	public void computeTotal() throws Exception {
		double actual = cart.computeTotal();
		double expected = 1327;
		assertEquals(expected,actual,0);
	}
	
	@Test
	public void getProductsInCart() throws Exception {
		LinkedList<ShopOnline> products = cart.getProductsInCart();
		double actual = products.size();	
		double expected = 2;
		assertEquals(expected,actual,0);
	}
}
