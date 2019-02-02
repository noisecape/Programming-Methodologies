package unifi.ShopOnline;

public interface Subject {

	void registerObserver(Observer o)throws Exception;

	void removeObserver(Observer o)throws Exception;

	void notifyObserver()throws Exception;
	
}
