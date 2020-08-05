package br.com.revisao.beans;

import java.util.Calendar;

public class ContaPoupança extends Conta implements ContaInvestimento{
	
	private float taxa;
	private final float rendimento = 0.0020f;//0,20% ao mês
	
		
	public ContaPoupança(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}
	
	@Override
	public void retirar(double valor) throws Exception{
		if(this.getSaldo()>=valor+this.taxa) {
			System.out.println("Taxa:"+this.taxa);
			super.retirar(valor+this.taxa);
		}else {
			System.out.println("Saldo insuficiente.");
		}
	}

	@Override
	public double calculaRetornoInvestimento() {
		return this.getSaldo()*this.rendimento;
	}
	
	public float getTaxa() {
		return taxa;
	}

}
