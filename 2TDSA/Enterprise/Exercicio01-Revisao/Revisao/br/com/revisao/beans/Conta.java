package br.com.revisao.beans;

import java.util.Calendar;

public abstract class Conta {
	private int agencia;
	private int numero;
	private Calendar dataAbertura;
	private double saldo;
	
	public Conta(int agencia, int numero, Calendar dataAbertura, double saldo) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.dataAbertura = dataAbertura;
		this.saldo = saldo;
	}

	//metodos criados
	public void depositar(double valor) {
		this.saldo += valor;
		System.out.printf("Depositado R$%.2f, Saldo: R$%.2f\n",valor,this.saldo);
	}
	
	public void retirar(double valor) throws Exception{
		this.saldo-=valor;
		System.out.printf("Retirado R$%.2f, Saldo: R$%.2f\n",valor,this.saldo);
	}
	
	//gets 
	public int getAgencia() {
		return agencia;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public Calendar getDataAbertura() {
		return dataAbertura;
	}
	
	public double getSaldo() {
		return saldo;
	}
}
