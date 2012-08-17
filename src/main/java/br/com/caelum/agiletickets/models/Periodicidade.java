package br.com.caelum.agiletickets.models;

public enum Periodicidade {
	DIARIA(1), SEMANAL(7);

	private int dias;

	private Periodicidade(int dias) {
		this.dias = dias;
	}

	public int getDiferencaEmDias() {
		return this.dias;
	}

}
