import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import unifi.ShopOnline.*;

public class ItemTest {
	private ShopOnline item;
	private DiscountStrategy student;
	private DiscountStrategy elder;
	
	@Before
	public void initItem(){
		item = new Item("iPad", 499);
		student = new StudentDiscount();
		elder = new ElderDiscount();
	}
	
	@Test
	public void getName() throws Exception {
		String expected = "iPad";
		String actual = item.getName();
		assertEquals(expected,actual);
	}
	
	@Test 
	public void getTotal() throws Exception {
		double expected = 499;
		double actual = item.getTotal();
		assertEquals(expected,actual, 0);
	}
	
	@Test
	public void performDiscountStrategyStudent() throws Exception{
		item.setDiscountStrategy(student);
		double actual = item.perfomDiscountStrategy();
		double expected = 469.06;
		assertEquals(expected,actual,0);
	}
	
	@Test
	public void performDiscountStrategyElder() throws Exception{
		item.setDiscountStrategy(elder);
		double actual = item.perfomDiscountStrategy();
		double expected = 459.08;
		assertEquals(expected,actual,0);
	}
}
