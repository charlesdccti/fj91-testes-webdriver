package br.com.caelum.fj91.rh.cargo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.fj91.rh.pages.PaginaDeCargos;
import br.com.caelum.fj91.rh.pages.Sistema;
import br.com.caelum.fj91.rh.util.Util;

public class CadastroCargoTest {
	
	private Sistema sistema;
	
	@Before
	public void setup() {
		this.sistema = new Sistema();
	}
	
	@After
	public void clean() {
		this.sistema.encerrrar();
	}

	@Test
	public void cargoComSalarioMinimoAbaixoDoValorNacionalNaoPodeSerCadastrado() {
		PaginaDeCargos pagina = sistema.acessaPaginaDeCargos();
		pagina.clicaNoBotaoNovoCargo();
		pagina.preencheFormulario(Util.textoAleatorio(), "700", "1000");
		pagina.clicaNoBotaoGravar();
		
		boolean temMensagemDeErro = pagina.temMensagem("Salário mínimo do cargo nao pode ser menor do que o salário mínimo nacional(R$954,00)");
		Assert.assertTrue(temMensagemDeErro);
	}
	
	@Test
	public void cargoComSalarioMinimoMaiorDoQueSalarioMaximoNaoPodeSerCadastrado() {
		PaginaDeCargos pagina = sistema.acessaPaginaDeCargos();
		pagina.clicaNoBotaoNovoCargo();
		pagina.preencheFormulario(Util.textoAleatorio(), "2000", "1800");
		pagina.clicaNoBotaoGravar();
		
		boolean temMensagemDeErro = pagina.temMensagem("Salário mínimo deve ser menor do que o salário máximo");
		Assert.assertTrue(temMensagemDeErro);
	}
	
	@Test
	public void cargoComSalarioMaximoMaiorDoQueValorMaximoDaEmpresaNaoPodeSerCadastrado() {
		PaginaDeCargos pagina = sistema.acessaPaginaDeCargos();
		pagina.clicaNoBotaoNovoCargo();
		pagina.preencheFormulario(Util.textoAleatorio(), "2000", "120000");
		pagina.clicaNoBotaoGravar();
		
		boolean temMensagemDeErro = pagina.temMensagem("Salário máximo do cargo não pode ser maior do que R$100.000,00");
		Assert.assertTrue(temMensagemDeErro);
	}
	
	@Test
	public void cargoComNomeRepetidoNaoPodeSerCadastrado() {
		String nome = Util.textoAleatorio();
		PaginaDeCargos pagina = sistema.acessaPaginaDeCargos();
		pagina.clicaNoBotaoNovoCargo();
		pagina.preencheFormulario(nome, "5000", "6000");
		pagina.clicaNoBotaoGravar();
		
		//repetido:
		pagina.clicaNoBotaoNovoCargo();
		pagina.preencheFormulario(nome, "5000", "6000");
		pagina.clicaNoBotaoGravar();
		
		boolean temMensagemDeErro = pagina.temMensagem("Já existe outro cargo cadastrado com esse nome");
		Assert.assertTrue(temMensagemDeErro);
	}
	
	@Test
	public void cargoComDadosCorretosPodeSerCadastrado() {
		PaginaDeCargos pagina = sistema.acessaPaginaDeCargos();
		pagina.clicaNoBotaoNovoCargo();
		pagina.preencheFormulario(Util.textoAleatorio(), "5000", "8000");
		pagina.clicaNoBotaoGravar();
		
		boolean temMensagemDeErro = pagina.temMensagem("Cargo cadastrado!");
		Assert.assertTrue(temMensagemDeErro);
	}

}
