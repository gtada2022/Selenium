package Test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	@Test
	public void teste() {
		System.setProperty("webdriver.gecko.driver","/Users/tada/Desktop/GeckoDriver/geckodriver 2" );
		//System.setProperty("webdriver.chrome.driver","/Users/tada/Desktop/GeckoDriver/chromedriver" );
		WebDriver driver  = new FirefoxDriver();
	    //WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
		
	}

}
