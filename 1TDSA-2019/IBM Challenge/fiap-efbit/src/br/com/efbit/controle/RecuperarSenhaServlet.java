package br.com.efbit.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.efbit.bo.UsuarioBO;

@WebServlet("/Senha")
public class RecuperarSenhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rm = Integer.parseInt(request.getParameter("codigo"));
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		email = email.toUpperCase();
		UsuarioBO usuarioBO = new UsuarioBO();
		
		//padronizando email
		
		
		//enviando codigo
		request.setAttribute("codigo", rm);
		try {
			request.setAttribute("senha", usuarioBO.recuperarSenha(rm, email, cpf));
		} catch (Exception e) {
			e.printStackTrace();
		}	
		request.getRequestDispatcher("posSenha.jsp").forward(request, response);
	}

}
