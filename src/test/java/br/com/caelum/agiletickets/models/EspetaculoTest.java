package br.com.caelum.agiletickets.models;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class EspetaculoTest {

	private Espetaculo espetaculo;
	private LocalDate inicio;

	@Before
	public void criaEspetaculo() {
		this.espetaculo = new Espetaculo();
		this.inicio = new LocalDate(2012, 8, 16);
	}

	@Test
	public void criaSessoesEspetaculoDiario() throws Exception {
		LocalDate fim = new LocalDate(2012, 8, 26);
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.DIARIA);
		assertThat(sessoes.size(), is(11));
	}

	@Test
	public void criaNenhumaSessaoSeInicioMaiorQueFim() throws Exception {
		LocalDate fim = new LocalDate(2012, 8, 15);

		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.DIARIA);
		assertThat(sessoes.size(), is(0));

		sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.SEMANAL);
		assertThat(sessoes.size(), is(0));
	}

	@Test
	public void verificaSeSessoesPeriodicidadeDiariaEstaoCorretas() throws Exception {
		LocalDate fim = new LocalDate(2012, 8, 18);
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.DIARIA);
		assertThat(getDiasFrom(sessoes), hasItems(inicio, inicio.plusDays(1), inicio.plusDays(2)));
	}

	@Test
	public void criaSessoesEspetaculoSemanal() throws Exception {
		LocalDate fim = new LocalDate(2012, 8, 26);
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.SEMANAL);
		assertThat(sessoes.size(), is(2));
	}

	@Test
	public void verificaSeSessoesPeriodicidadeSemanalEstaoCorretas() throws Exception {
		LocalDate fim = new LocalDate(2012, 8, 31);
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, null, Periodicidade.SEMANAL);
		assertThat(getDiasFrom(sessoes), hasItems(inicio, inicio.plusWeeks(1), inicio.plusWeeks(2)));
	}

	private List<LocalDate> getDiasFrom(List<Sessao> sessoes) {
		List<LocalDate> dias = new ArrayList<>();
		for (Sessao sessao : sessoes) {
			dias.add(new LocalDate(sessao.getInicio()));
		}
		return dias;
	}

}
