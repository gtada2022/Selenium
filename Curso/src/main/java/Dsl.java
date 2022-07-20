import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dsl {
	private WebDriver driver;

	public Dsl(WebDriver driver) {
		this.driver = driver;
	}
	public void escreve(By by, String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
		
	
	}
	public void escreve(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}

	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");

	}

	public void clickRadio(String id) {
		//driver.findElement(By.id(id)).click();

	}

	public boolean checkRadioEstaMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}

	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);

	}
	public String valorSelecionadoCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
	}
	public void clicarBotao(String id) {
		driver.findElement(By.id(id)).click();
	}
	public void clickLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	
	public String obterTexto(String id) {
		return driver.findElement(By.id(id)).getText();
	}
	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}
	
	public String obterTag(String id) {
		 return obterTexto(By.id(id));
	}

}
