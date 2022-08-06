package Suites;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Test.TesteCadastro;
import Test.TesteRegrasCadastros;
import core.DriverFactory;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteRegrasCadastros.class
	
	
})
public class SuitTests {
	
	@AfterClass 
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}
	

}
