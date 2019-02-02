import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CartTest.class, ItemTest.class, PackTest.class, PaymentTest.class, ShopTest.class })
public class AllTests {

}
