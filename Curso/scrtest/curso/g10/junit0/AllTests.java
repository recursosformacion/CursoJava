package curso.g10.junit0;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreditoTest.class, CuentaTest.class, DebitoTest.class })
public class AllTests {

}
