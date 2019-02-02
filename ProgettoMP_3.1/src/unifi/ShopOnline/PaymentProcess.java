package unifi.ShopOnline;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class PaymentProcess {
	private ShopOnline cart;
	private LinkedList<ShopOnline> productsInBill;

	public void setCart(ShopOnline cart) throws Exception {
		this.cart = cart;
		productsInBill = new LinkedList<ShopOnline>();
	}

	final void processToPay() throws Exception {
		if (acceptPayment()) {
			cart.printProducts();
			cart.getTotal();
			pay();
			printBill();
		}
	}

	public boolean acceptPayment() throws Exception {
		Scanner scanner = new Scanner(System.in);
		String answer;
		System.out.println("Do you want to pay?");
		while(true){
			answer = scanner.nextLine();
			if(answer.equals("YES")){
				productsInBill = cart.getProductsInCart();
				return true;
			}else if(answer.equals("NO")){
				System.out.println("Payment refused");
				return false;
			}else{
				System.out.println("------------------"+"\n"+"PLEASE ANSWER THE QUESTION [YES/NO]"+"\n"+"------------------");
			}
		}
	}

	public void printBill() throws Exception{
		System.out.println("----------"+"\n"+"BILL: "+"\n");
		Iterator<ShopOnline> iterator = productsInBill.iterator();
		while(iterator.hasNext()){
			ShopOnline current = iterator.next();
			current.printProducts();
		}
		System.out.println("\n"+"TOTAL: "+ cart.getTotal());
	}
	
	abstract void pay();
}
