package unifi.ShopOnline;

public class PayPal extends PaymentProcess{
	private String eMail;
	private String pass;
	
	public PayPal(String eMail, String pass){
		this.eMail = eMail;
		this.pass = pass;
	}
	
	public void pay(){
		System.out.println("\n"+"Payment accepted"+"\n");
	}
}
