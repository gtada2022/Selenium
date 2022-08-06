package Test;
import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Page.CampoTreinamentoPage;
import core.BaseTest;
import core.DriverFactory;
import core.Dsl;


public class TesteCadastro extends BaseTest  {
	

	private CampoTreinamentoPage page;


	@Before
	public void inicializa(){
		//driver = new FirefoxDriver();
		//driver.manage().window().setSize(new Dimension(1200, 765));
		//driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//dsl = new Dsl(driver);
		//page = new CampoTreinamentoPage(driver);
		page = new CampoTreinamentoPage();

	}
	
	

	@Test
	public void deveRealizarCadastroComSucesso(){
		page.setNome("Wagner");
		//dsl.escreve("elementosForm:nome", "Wagner");
		page.setSobreNome("Costa");
		//dsl.escreve("elementosForm:sobrenome", "Costa");
		page.setSexoMasculino();
		//dsl.clickRadio("elementosForm:sexo:0");
		page.setComidaPizza();
		//dsl.clickRadio("elementosForm:comidaFavorita:2");
		page.setEsolaridade("Mestrado");
		//dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
		page.setEsport("Natacao");
		//dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		page.botaoCadastrar();
		//dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		//Assert.assertTrue(dsl.obterTexto("resultado").startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterResultadoNome().endsWith("Wagner"));
		//Assert.assertTrue(dsl.obterTexto("descNome").endsWith("Wagner"));
		//Assert.assertEquals("Sobrenome: Costa",page.obterResultadoSobrenome());
		//Assert.assertEquals("Sobrenome: Costa", dsl.obterTexto("descSobrenome"));
		//Assert.assertEquals("Sexo: Masculino",page.obterResultadoSexo());
		//Assert.assertEquals("Sexo: Masculino", dsl.obterTexto("descSexo"));
		//Assert.assertEquals("Comida: Pizza", dsl.obterTexto("descComida"));
		//Assert.assertEquals("Escolaridade: mestrado", dsl.obterTexto("descEscolaridade"));
		//Assert.assertEquals("Esportes: Natacao", dsl.obterTexto("descEsportes"));
	}
	/*
	
	@Test
	public void deveValidarNomeObrigatorio(){
		page.botaoCadastrar();
		//dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio(){
		dsl.escreve("elementosForm:nome", "Nome qualquer");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSexoObrigatorio(){
		dsl.escreve("elementosForm:nome", "Nome qualquer");
		dsl.escreve("elementosForm:sobrenome", "Sobrenome qualquer");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarComidaVegetariana(){
		dsl.escreve("elementosForm:nome", "Nome qualquer");
		dsl.escreve("elementosForm:sobrenome", "Sobrenome qualquer");
		dsl.clickRadio("elementosForm:sexo:1");
		dsl.clickRadio("elementosForm:comidaFavorita:0");
		dsl.clickRadio("elementosForm:comidaFavorita:3");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}
	
	/*@Test
	public void deveValidarEsportistaIndeciso(){
		dsl.escreve("elementosForm:nome", "Nome qualquer");
		dsl.escreve("elementosForm:sobrenome", "Sobrenome qualquer");
		dsl.clickRadio("elementosForm:sexo:1");
		dsl.clickRadio("elementosForm:comidaFavorita:0");
		page.setEsport("Karate","O que eh esporte?");
	
		//dsl.selecionarCombo("elementosForm:esportes", "Karate");
		//dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}
	@Test
	public void deveValidarEsportistaIndeciso(){
		page.setNome("Nome qualquer");
		page.setSobreNome("Sobrenome qualquer");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setEsport("Karate", "O que eh esporte?");
		page.botaoCadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}
	*/
}

