package br.com.caelum.agiletickets.models;

public class SessaoBuilder {

	class CriaSessao
	{
		private final Sessao sessao;

		CriaSessao(int ingressos) {
			sessao = new Sessao();
			sessao.setTotalIngressos(ingressos);
		}

		public Sessao ingressos() {
			return this.sessao;
		}

	}

	public CriaSessao com(int ingressos) {
		return new CriaSessao(ingressos);
	}

}