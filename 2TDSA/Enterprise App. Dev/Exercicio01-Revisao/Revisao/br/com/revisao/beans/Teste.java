package br.com.revisao.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Teste {

	public static void main(String[] args) throws Exception {
		
		Calendar c = Calendar.getInstance();
		c.set(2020, 01, 15);
		
		//int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo
		List<ContaCorrente> contasC = new ArrayList<>();
		contasC.add(new ContaCorrente(101, 1010, c, 1000, TipoConta.COMUM));
		contasC.add(new ContaCorrente(101, 1020, c, 2000, TipoConta.COMUM));
		contasC.add(new ContaCorrente(101, 1030, c, 50000, TipoConta.PREMIUM));
		
		//int agencia, int numero, Calendar dataAbertura, double saldo, float taxa
		ContaPoupança poup = new ContaPoupança(101, 8010, c, 2000, 25f);
		
		//manipulando poupança
		System.out.println(poup.getSaldo());
		System.out.println(poup.getTaxa());
		System.out.println(poup.getSaldo()+poup.getTaxa());
		
		poup.depositar(100);
		
		System.out.println(poup.getSaldo());
		
		poup.retirar(1100);
		
		System.out.println(poup.getSaldo());

		poup.retirar(1000);
		
		System.out.println();
		
		//manipulando CC
		
		System.out.printf("Saldo cta %d = R$%.2f\n", contasC.get(0).getNumero(),contasC.get(0).getSaldo());
		System.out.printf("Saldo cta %d = R$%.2f\n", contasC.get(1).getNumero(),contasC.get(1).getSaldo());
		System.out.printf("Saldo cta %d = R$%.2f\n", contasC.get(2).getNumero(),contasC.get(2).getSaldo());
		
		//chamando a exception
		try {
			contasC.get(0).retirar(1001);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		contasC.get(0).retirar(1000);
		contasC.get(2).retirar(51000);
		
		
		System.out.printf("Saldo cta %d = R$%.2f\n", contasC.get(0).getNumero(),contasC.get(0).getSaldo());
		System.out.printf("Saldo cta %d = R$%.2f\n", contasC.get(2).getNumero(),contasC.get(2).getSaldo());
		
		
		
	}

}
