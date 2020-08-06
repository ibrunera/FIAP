package br.com.efbit.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.efbit.beans.Usuario;
import br.com.efbit.bo.UsuarioBO;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String dataNascimento = request.getParameter("data");
		int tipo = 1;
		Usuario usuario = new Usuario(nome, cpf, email, senha, dataNascimento, tipo);
		UsuarioBO usuarioBO = new UsuarioBO();
		
		//padronizando email
		email = email.toUpperCase();
		
		
		//cadastrando
		try {
			if(usuarioBO.cadastrarUsuario(usuario).equals("Usuário Cadastrado")) {
				usuarioBO.cadastrarUsuario(usuario);
				System.out.println("Cadastrado com sucesso");
			}else {
				System.out.println("Erro cadastro 1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//enviando codigo
		request.setAttribute("nome", nome);
		request.setAttribute("senha", senha);
		try {
			request.setAttribute("codigo", usuarioBO.buscarCodigo(email, senha));
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		request.getRequestDispatcher("posCadastro.jsp").forward(request, response);
		
	}

}
