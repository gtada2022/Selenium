package core;
import static core.DriverFactory.killDriver;

import org.junit.After;

import core.Dsl;

public class BasePage {
	protected Dsl dsl;
	//private WebDriver driver;

	//public CampoTreinamentoPage(WebDriver driver) {
	public BasePage() {
		//dsl = new Dsl(driver);
		dsl = new Dsl();

	}

}
