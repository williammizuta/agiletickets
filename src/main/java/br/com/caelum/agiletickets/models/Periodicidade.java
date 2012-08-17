package br.com.caelum.agiletickets.models;

import org.joda.time.LocalDate;

public enum Periodicidade {
	DIARIA(1), SEMANAL(7);

	private int dias;

	private Periodicidade(int dias) {
		this.dias = dias;
	}

	public LocalDate getProximoDia(LocalDate data) {
		return data.plusDays(dias);
	}

}
