package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {

	@Test
	public void deveVenderUmNumeroMenorDeIngressoDoQuevagas() throws Exception {
		Sessao sessao = new SessaoBuilder().com(2).ingressos();
		Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVenderUmNumeroMaiorDeIngressoDoQuevagas() throws Exception {
		Sessao sessao = new SessaoBuilder().com(2).ingressos();
		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void deveVenderOMesmoNumeroDeIngressoEVagas() throws Exception {
		Sessao sessao = new SessaoBuilder().com(5).ingressos();
		Assert.assertTrue(sessao.podeReservar(5));
	}

	@Test
	public void naoDeveReservarUmNumeroNegativoDeVagas() throws Exception {
		Sessao sessao = new SessaoBuilder().com(5).ingressos();
		Assert.assertFalse(sessao.podeReservar(-1));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new SessaoBuilder().com(5).ingressos();
		sessao.reserva(3);

		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
}
