package unifi.ShopOnline;

public class Bonifico extends PaymentProcess{
	private String IBAN;
	
	public Bonifico(String IBAN){
		this.IBAN = IBAN;
	}
	
	@Override
	void pay() {
		System.out.println("IBAN: "+IBAN);
		System.out.println("\n"+"Payment accepted"+"\n");
	}
}
