package br.com.efbit.bo;

import br.com.efbit.beans.Usuario;
import br.com.efbit.dao.UsuarioDAO;

public class UsuarioBO {
	

	public boolean verificaLogin(int codigo, String senha) throws Exception{
		UsuarioDAO usuarioDAO= new UsuarioDAO();
		if(usuarioDAO.verificaLogin(codigo, senha)) {
			System.out.println("Usu�rio autenticado");
			return true;
		}else {
			return false;
		}
	}
	
	public String cadastrarUsuario(Usuario objetoUsuario) throws Exception {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		objetoUsuario.setNome(objetoUsuario.getNome().toUpperCase());
		objetoUsuario.setEmail(objetoUsuario.getEmail().toUpperCase());
		
		usuarioDao.addUsuario(objetoUsuario);
		usuarioDao.close();
		return "Usuário Cadastrado";
		
	}
	
	public Usuario buscarUsuario(int codigo) throws Exception {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		return usuarioDao.getUsuario(codigo);
	}
	
	public int buscarCodigo(String email, String senha) throws Exception{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.buscarCodigo(email, senha);
	}
	
	public String recuperarSenha(int rm, String email, String cpf)throws Exception{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.recuperarSenha(rm, email, cpf);
	}
	
	
	public String atualizarUsuario(String novoNome, String novoCpf, String novoEmail, String novaDataNascimento, int codigo) throws Exception {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.updateUsuario(novoNome, novoCpf, novoEmail, novaDataNascimento, codigo);
		return "Usu�rio atualizado";
	}
	
	public String atualizarSenha(int codigo, String novaSenha) throws Exception{
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.updatePassword(novaSenha, codigo);
		return "Senha atualizada";
	}
	
	public String deletarUsuario(int codigo) throws Exception{
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.deleteUsuario(codigo);
		return "Usu�rio deletado";
	}
}
