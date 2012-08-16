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

	@Test
	public void verificaSeSessoesPeriodicidadeDiariaEstaoCorretas() throws Exception {
		LocalDate fim = new LocalDate(2012,8,18);
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.DIARIA);
		Assert.assertEquals(inicio, new LocalDate(sessoes.get(0).getInicio()));
		Assert.assertEquals(inicio.plusDays(1), new LocalDate(sessoes.get(1).getInicio()));
		Assert.assertEquals(inicio.plusDays(2), new LocalDate(sessoes.get(2).getInicio()));
	}
}
