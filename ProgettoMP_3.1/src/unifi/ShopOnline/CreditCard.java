package unifi.ShopOnline;

public class CreditCard extends PaymentProcess{
	private String name;
	private String surname;
	private String ID;
	
	public CreditCard(String name, String surname, String ID){
		this.name = name;
		this.surname = surname;
		this.ID = ID;
	}
	
	@Override
	public void pay() {
		System.out.println("Credit Card ID: "+ID+"\n"+"Owner: "+name+" "+surname);
		System.out.println("\n"+"Payment accepted"+"\n");
	}
}
