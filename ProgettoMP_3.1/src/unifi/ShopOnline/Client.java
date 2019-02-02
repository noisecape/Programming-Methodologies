package unifi.ShopOnline;

public class Client {
	public static void main(String args[]) throws Exception {
		// Creo i vari oggetti del negozio, il negozio stesso, il carrello, un
		// pacchetto e la fattura

		ShopOnline shop = new Shop("Apple Store");
		ShopOnline cart = new Cart();
		Bill bill = new Bill(cart);
		ShopOnline iPhone = new Item("iPhone", 799);
		ShopOnline iPad = new Item("iPad", 499);
		ShopOnline earPods = new Item("Ear Pods", 29);
		ShopOnline macBook = new Item("MacBook", 1499);
		ShopOnline iMac = new Item("iMac", 1499);

		ShopOnline pack = new Pack("XMAS PACK");

		// Aggiungo gli articoli al negozio

		shop.addItem(earPods);
		shop.addItem(iPad);
		shop.addItem(iPhone);
		shop.addItem(macBook);
		shop.addItem(pack);
		shop.addItem(iMac);

		// Aggiungo due articoli al pacchetto creato

		pack.addItem(iPhone);
		pack.addItem(earPods);

		// Faccio report degli articoli con il prezzo massimo e minimo

		shop.reportMaxPrice();
		shop.reportMinPrice();

		// Aggiungo vari articoli al carrello. Tutte le volte che un articolo
		// viene aggiunto, viene stampata la fattura aggiornata

		cart.addItem(pack);
		cart.addItem(iPad);
		cart.addItem(iMac);

		// Stampo il prezzo totale senza articoli scontati

		cart.getTotal();

		// Applico lo sconto studente al carrello

		DiscountStrategy student = new StudentDiscount();
		cart.setDiscountStrategy(student);
		cart.perfomDiscountStrategy();

		//Pago il contenuto del carrello con uno dei metodi a disposizione
		
		PaymentProcess paying = new PayPal("email","password");
		paying.setCart(cart);
		paying.processToPay();
	}
}
