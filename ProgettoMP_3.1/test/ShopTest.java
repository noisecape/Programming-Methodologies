import static org.junit.Assert.*;

import org.junit.Before;

import unifi.ShopOnline.*;

import org.junit.Test;

public class ShopTest {
	private ShopOnline shop;
	
	@Before
	public void initShop() throws Exception{
		shop = new Shop("APPLE STORE");
		ShopOnline iPad = new Item("iPad", 499);
		ShopOnline macBook = new Item("MacBook", 1499);
		ShopOnline pack = new Pack("XMAS PACK");
		ShopOnline earPods = new Item("Ear Pods",29);
		ShopOnline iPhone = new Item("iPhone", 799);
		pack.addItem(earPods);
		pack.addItem(iPhone);
		shop.addItem(iPad);
		shop.addItem(macBook);
		shop.addItem(pack);
	}

	@Test
	public void getName() throws Exception {
		String actual = shop.getName();
		String expected = "APPLE STORE";
		assertEquals(expected,actual);
	}

	@Test
	public void reportMaxPrice() throws Exception {
		shop.reportMaxPrice();
		double actual = shop.reportMaxPrice();
		double expected = 1499;
		assertEquals(expected,actual,0);
	
	}
	
	@Test
	public void reportMinPrice() throws Exception {
		shop.reportMinPrice();
		double actual = shop.reportMinPrice();
		double expected = 499;
		assertEquals(expected,actual,0);
	
	}
	
}
