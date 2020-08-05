package br.com.co.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PROFESSOR")
@SequenceGenerator(name="professor", sequenceName="SQ_TB_PROFESSOR", allocationSize=1)
public class Professor {
	
	@Id
	@Column(name="cd_professor")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="professor")
	private int codigo;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cd_curriculo")
	private Curriculo curriculo;
	
	@Column(name="nm_professor", nullable=false)
	private String nome;
	
	@Column(name="ds_email", nullable=false)
	private String email;
	
	//bidirecional
	@OneToMany(mappedBy="professor", cascade = CascadeType.ALL)
	private List<Curso> cursos = new ArrayList<Curso>();
	
	//adicionar Cursos pelo Professor, garantindo a FK
	public void addCurso(Curso curso) {
		curso.setProfessor(this);
		cursos.add(curso);
	}

	public Professor() {
		super();
	}

	public Professor(Curriculo curriculo, String nome, String email) {
		super();
		this.curriculo = curriculo;
		this.nome = nome;
		this.email = email;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
