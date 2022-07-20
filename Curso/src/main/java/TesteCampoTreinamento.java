import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	private WebDriver driver;
	private Dsl dsl;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new Dsl(driver);

	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void testeTextField() {
		dsl.escreve("elementosForm:nome", "Tada");
		Assert.assertEquals("Tada", dsl.obterValorCampo("elementosForm:nome"));

	}

	@Test
	public void testeArea() {
		dsl.escreve("elementosForm:sugestoes", "teste");
		Assert.assertEquals("teste", dsl.obterValorCampo("elementosForm:sugestoes"));

	}

	@Test
	public void testeRadioButton() {
		dsl.clickRadio("elementosForm:sexo:1");
		dsl.checkRadioEstaMarcado("elementosForm:sexo:1");

	}

	@Test
	public void testeCheckBox() {
		dsl.clickRadio("elementosForm:comidaFavorita:1");
		dsl.checkRadioEstaMarcado("elementosForm:comidaFavorita:1");
	}

	@Test
	public void testeComboBox() {

		// WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		// Select combo = new Select(element);
		// combo.selectByIndex(2);
		// combo.selectByVisibleText("2o grau incompleto");

		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		Assert.assertEquals("Superior", dsl.valorSelecionadoCombo("elementosForm:escolaridade"));

	}

	@Test
	public void ValortesteComboBox() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		// combo.selectByIndex(2);
		List<WebElement> option = combo.getOptions();
		Assert.assertEquals(8, option.size());
		boolean achou = false;
		for (WebElement option1 : option) {
			if (option1.getText().equals("Mestrado"))
				;
			{
				achou = true;
				break;
			}

		}
		Assert.assertTrue(achou);

		driver.quit();
	}

	@Test
	public void ValortesteEsporteComboBox() {
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		driver.quit();

	}

	@Test
	public void IteracaoBotao() {
		;

		// driver.findElement(By.id("buttonSimple")).click();
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();

	}

	@Test
	// @Ignore
	public void LinkBusca() {
		dsl.clickLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));

	}

	@Test

	public void BuscarTexto() {

		// System.out.println(driver.findElement(By.tagName("body")).getText());
		// Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo
		// de Treinamento"));
		// Assert.assertEquals("Campo de Treinamento",
		// driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));

		// driver.findElement(By.className("facilAchar")).getText());

		
	}

}
