package unifi.ShopOnline;
import java.util.Comparator;

public class CompareByPrice implements Comparator<ShopOnline>{

	@Override
	public int compare(ShopOnline o1, ShopOnline o2) {
		
		try {
			return Double.compare(o1.getTotal(), o2.getTotal());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
