package br.com.co.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_ALUNO")
@SequenceGenerator(name="aluno", sequenceName="SQ_TB_ALUNO", allocationSize=1)
public class Aluno {
	
	@Id
	@Column(name="cd_aluno")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="aluno")
	private int codigo;
	
	//bidirecional
	@ManyToMany(mappedBy="alunos",fetch=FetchType.EAGER, 
				cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Curso> cursos;

	@Column(name="nm_aluno", nullable=false, length=150)
	private String nome;	
	
	@Column(name="dt_nascimento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Column(name="ds_email", nullable=false, length=100)
	private String email;
	
	@Column(name="sn_aluno", nullable=false, length=30)
	private String senha;
	
	public Aluno() {
		super();
	}
	
	public Aluno(String nome, Calendar dataNascimento, String email, String senha) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}
	
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
