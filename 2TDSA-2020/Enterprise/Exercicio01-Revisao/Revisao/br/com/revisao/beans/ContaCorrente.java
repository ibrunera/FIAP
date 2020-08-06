package br.com.revisao.beans;

import java.util.Calendar;

public class ContaCorrente extends Conta{
	private TipoConta tipo;
	
	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	@Override
	public void retirar(double valor) throws Exception{
		if(tipo.equals(TipoConta.COMUM) && super.getSaldo()-valor<0) {
			throw new Exception("Valor Inválido.");
		}else {
			super.retirar(valor);
		}
		
	}
}
