package br.com.caelum.agiletickets.models;

import java.util.List;

import junit.framework.Assert;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class EspetaculoTest {

	private Espetaculo espetaculo;
	private LocalDate inicio;

	@Before
	public void criaEspetaculo() {
		this.espetaculo = new Espetaculo();
		this.inicio = new LocalDate(2012,8,16);
	}

	@Test
	public void criaSessoesEspetaculoDiario() throws Exception {
		LocalDate fim = new LocalDate(2012,8,26);
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.DIARIA);
		Assert.assertEquals(11, sessoes.size());
	}

	@Test
	public void criaNenhumaSessaoSeInicioMaiorQueFim() throws Exception {
		LocalDate fim = new LocalDate(2012, 8, 15);

		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.DIARIA);
		Assert.assertEquals(0, sessoes.size());
	}
}
