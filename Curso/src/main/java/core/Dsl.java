package core;
import static core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//
public class Dsl {
	//private WebDriver driver;

	//public Dsl(WebDriver driver) {
		//this.driver = driver;
	//}

	public void escreve(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);

	}

	public void escreve(String id_campo, String texto) {
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}

	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");

	}

	public void clickRadio(String id) {
		getDriver().findElement(By.id(id)).click();

	}

	public boolean checkRadioEstaMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}

	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);

	}

	public String valorSelecionadoCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	public void clicarBotao(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void clickLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}

	public String obterTexto(String id) {
		return getDriver().findElement(By.id(id)).getText();
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public String obterTag(String id) {
		return obterTexto(By.id(id));
	}

	public String alertaObterTextoEAceita() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;

	}

	public void clicarBotaoTabela(String coluna, String valor, String colunaBotao, String idTab) {
		// procurar a coluna

		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		int idColuna = obterColuna(coluna, tabela);
		
		
		// encontrar a linha do registro

		// procurar a coluna botao

		// clicar no botao da celula encotrado

	}

	protected int obterColuna(String coluna, WebElement tabela) {
		List<WebElement> coluna1 = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < coluna1.size(); i++) {
			if (coluna1.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;

			}

		}

		return idColuna;

	}

}
