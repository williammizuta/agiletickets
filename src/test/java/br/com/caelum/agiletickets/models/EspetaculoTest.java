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

		sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.SEMANAL);
		Assert.assertEquals(0, sessoes.size());
	}

	@Test
	public void verificaSeSessoesPeriodicidadeDiariaEstaoCorretas() throws Exception {
		LocalDate fim = new LocalDate(2012,8,18);
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.DIARIA);
		Assert.assertEquals(inicio, getDiaFrom(sessoes.get(0)));
		Assert.assertEquals(inicio.plusDays(1), getDiaFrom(sessoes.get(1)));
		Assert.assertEquals(inicio.plusDays(2), getDiaFrom(sessoes.get(2)));
	}

	private LocalDate getDiaFrom(Sessao sessao) {
		return new LocalDate(sessao.getInicio());
	}

	@Test
	public void criaSessoesEspetaculoSemanal() throws Exception {
		LocalDate fim = new LocalDate(2012, 8, 26);
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.SEMANAL);
		Assert.assertEquals(2, sessoes.size());
	}

	@Test
	public void verificaSeSessoesPeriodicidadeSemanalEstaoCorretas() throws Exception {
		LocalDate fim = new LocalDate(2012, 8, 31);
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.SEMANAL);
		Assert.assertEquals(inicio, getDiaFrom(sessoes.get(0)));
		Assert.assertEquals(inicio.plusDays(7), getDiaFrom(sessoes.get(1)));
		Assert.assertEquals(inicio.plusDays(14), getDiaFrom(sessoes.get(2)));
	}

}
