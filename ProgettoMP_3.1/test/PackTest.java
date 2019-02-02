import static org.junit.Assert.*;

import org.junit.Before;

import unifi.ShopOnline.*;

import org.junit.Test;
public class PackTest {
	
	private ShopOnline pack;
	private ShopOnline iPhone;
	private ShopOnline earPods;
	
	@Before
	public void initPack() throws Exception{
		pack = new Pack("XMAS PACK");
		iPhone = new Item("iPhone", 799);
		earPods = new Item("Ear Pods",29);
		pack.addItem(iPhone);
		pack.addItem(earPods);
		
	}
	
	@Test
	public void getTotal()throws Exception{
		double actual = pack.getTotal();
		double expected = 828;
		assertEquals(expected,actual,0);
	}
	
	@Test
	public void computeTotal()throws Exception{
		double actual = pack.computeTotal();
		double expected = 828;
		assertEquals(expected,actual,0);
	}
	
	@Test
	public void performDiscountStrategyStudent() throws Exception {
		DiscountStrategy student = new StudentDiscount();
		pack.setDiscountStrategy(student);
		double actual = pack.perfomDiscountStrategy();
		double expected = 778.32;
		assertEquals(expected,actual,0);
	
	}
	
	@Test
	public void performDiscountStrategyElder() throws Exception {
		DiscountStrategy elder = new ElderDiscount();
		pack.setDiscountStrategy(elder);
		double actual = pack.perfomDiscountStrategy();
		double expected = 761.76;
		assertEquals(expected,actual,0);
	
	}
	
	@Test
	public void reportMaxPrice() throws Exception {
		pack.reportMaxPrice();
		double actual = pack.reportMaxPrice();
		double expected = 799;
		assertEquals(expected,actual,0);
	
	}
	
	@Test
	public void reportMinPrice() throws Exception {
		pack.reportMinPrice();
		double actual = pack.reportMinPrice();
		double expected = 29;
		assertEquals(expected,actual,0);
	
	}

}
