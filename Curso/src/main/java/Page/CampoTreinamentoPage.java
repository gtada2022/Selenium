package Page;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.BasePage;
import core.Dsl;

public class CampoTreinamentoPage extends BasePage {
	/*private Dsl dsl;
	//private WebDriver driver;

	//public CampoTreinamentoPage(WebDriver driver) {
	public CampoTreinamentoPage() {
		//dsl = new Dsl(driver);
		dsl = new Dsl(); 

	}*/

	public void setNome(String nome) {
		dsl.escreve("elementosForm:nome", nome);
	}

	public void setSobreNome(String sobreNome) {
		dsl.escreve("elementosForm:sobrenome", "Costa");
	}

	public void setSexoMasculino() {
		dsl.clickRadio("elementosForm:sexo:0");
	}

	public void setSexoFeminino() {
		dsl.clickRadio("elementosForm:sexo:1");
	}

	public void setComidaPizza() {
		dsl.clickRadio("elementosForm:comidaFavorita:2");
	}

	public void setComidaCarne() {
		dsl.clickRadio("elementosForm:comidaFavorita:0");
	}

	public void setComidaVegetariano() {
		dsl.clickRadio("elementosForm:comidaFavorita:3");
	}

	public void setEsolaridade(String valor) {
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}

	public void setEsport(String... valores) {
		for (String valor : valores) {
			dsl.selecionarCombo("elementosForm:esportes", valor);

		}

	}

	public void botaoCadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}

	public String obterResultadoCadastro() {
		return dsl.obterTexto("resultado");
	}

	public String obterResultadoNome() {
		return dsl.obterTexto("descNome");

	}

	public String obterResultadoSobrenome() {
		return dsl.obterTexto("descSobrenome");
	}

	public String obterResultadoSexo() {
		return dsl.obterTexto("descSexo");
	}
	public void testJavaScrit() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("alert('Testando ')"); 
		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		
		WebElement element = driver.findElement(By.id("elementosForm:nome"));
		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}

}
