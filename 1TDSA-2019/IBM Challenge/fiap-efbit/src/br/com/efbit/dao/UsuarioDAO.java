package br.com.efbit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.efbit.beans.Usuario;
import br.com.efbit.conexao.Conexao;

public class UsuarioDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public UsuarioDAO() throws Exception{
		con = Conexao.getConnection();
	}
	
	public void close() throws Exception{
		con.close();
	}
//create	
	public int addUsuario (Usuario usuario) throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_EFBIT_USUARIO (CD_USUARIO, NM_USUARIO, DS_CPF, DS_EMAIL, SN_SENHA, DT_NASCIMENTO, NR_TIPO) VALUES (SQ_EFBIT_CD_USUARIO.nextval,?,?,?,?,?,?)");
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getCpf());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getSenha());
		stmt.setString(5, usuario.getDataNascimento());
		stmt.setInt(6,usuario.getTipo());
		
		return stmt.executeUpdate();
	}
//read
	public Usuario getUsuario (int codigo) throws Exception{
		stmt=con.prepareStatement("SELECT * FROM T_EFBIT_USUARIO WHERE CD_USUARIO=?");
		stmt.setInt(1, codigo);
		rs=stmt.executeQuery();
		if(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setCodigo(rs.getInt("CD_USUARIO"));
			usuario.setNome(rs.getString("NM_USUARIO"));
			usuario.setCpf(rs.getString("DS_CPF"));
			usuario.setEmail(rs.getString("DS_EMAIL"));
			usuario.setSenha(rs.getString("SN_SENHA"));
			usuario.setDataNascimento(rs.getString("DT_NASCIMENTO"));
			usuario.setTipo(rs.getInt("DS_TIPO"));
			return usuario;
		}else {
			return new Usuario();
		}
	}
	public boolean verificaLogin(int codigo, String senha) throws Exception{
		boolean user = false;
		stmt = con.prepareStatement("SELECT CD_USUARIO, SN_SENHA FROM T_EFBIT_USUARIO WHERE CD_USUARIO=? AND SN_SENHA=?");
		stmt.setInt(1, codigo);
		stmt.setString(2, senha);
		rs=stmt.executeQuery();
		if(rs.next()){
			user = true;
			System.out.println("Usu�rio autenticado.");
		}else {
			System.out.println("Senha ou matr�cula erradas.");
		}
		return user;
	}
	
	public int buscarCodigo(String email, String senha) throws Exception{
		int cod = 0;
		stmt = con.prepareStatement("SELECT CD_USUARIO FROM T_EFBIT_USUARIO WHERE DS_EMAIL=? AND SN_SENHA=?");
		stmt.setString(1, email);
		stmt.setString(2, senha);
		rs = stmt.executeQuery();
		if(rs.next()) {
			cod = rs.getInt("CD_USUARIO");
			System.out.println("Código localizado.");
		}else {
			System.out.println("Código nao localizado.");
		}
		return cod;
	}
	
	public String recuperarSenha(int rm, String email, String cpf) throws Exception{
		String senha = "";
		stmt= con.prepareStatement("SELECT SN_SENHA FROM T_EFBIT_USUARIO WHERE CD_USUARIO=? AND DS_EMAIL=? AND DS_CPF=?");
		stmt.setInt(1, rm);
		stmt.setString(2, email);
		stmt.setString(3, cpf);
		System.out.println(rm);
		System.out.println(email);
		System.out.println(cpf);
		rs=stmt.executeQuery();
		if(rs.next()) {
			senha = rs.getString("SN_SENHA");
			System.out.println("Senha localizada");
		}else {
			System.out.println("Senha não localizada");
		}
		return senha;
	}
	
	public List<Usuario> pesquisarPorNome(String nome) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM T_EFBIT_USUARIO WHERE NM_USUARIO LIKE ?");
		stmt.setString(1, nome + "%");
		rs = stmt.executeQuery();
		List<Usuario> lista = new ArrayList<Usuario>();
		while(rs.next()) {
			lista.add(new Usuario(rs.getInt("CD_USUARIO"), rs.getString("NM_USUARIO"),rs.getString("DS_CPF"), rs.getString("DS_EMAIL") ,rs.getString("SN_SENHA"), rs.getString("DT_NASCIMENTO"), rs.getInt("NR_TIPO")));
		}
		return lista;
	}
//update
	public int updateUsuario(String novoNome, String novoCpf, String novoEmail, String novaDataNascimento, int codigo) throws Exception{
		stmt = con.prepareStatement("UPDATE T_EFBIT_USUARIO SET NM_USUARIO=?,DS_CPF=?,DS_EMAIL=?,DT_NASCIMENTO=? WHERE CD_USUARIO=?");
		stmt.setString(1, novoNome);
		stmt.setString(2, novoCpf);
		stmt.setString(3,novoEmail);
		stmt.setString(4, novaDataNascimento);
		stmt.setInt(5, codigo);
		
		return stmt.executeUpdate();
		
	}
	
	public int updatePassword(String novaSenha, int codigo) throws Exception{
		stmt = con.prepareStatement("UPDATE T_EFBIT_USUARIO SET SN_USUARIO=? WHERE CD_USUARIO=?");
		stmt.setString(1, novaSenha);
		stmt.setInt(2, codigo);
		
		return stmt.executeUpdate();
	}	
//delete	
	public int deleteUsuario (int codigo) throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_EFBIT_USUARIO WHERE CD_USUARIO=?");
		stmt.setInt(1, codigo);
		
		return stmt.executeUpdate();
	}
}
