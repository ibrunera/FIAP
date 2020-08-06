package br.com.efbit.controle;

import br.com.efbit.dao.UsuarioDAO;

public class Teste {

	public static void main(String[] args) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		int cod =dao.buscarCodigo("THIAGO@TESTE.COM", "12345");
		System.out.println(cod);
	}

}
