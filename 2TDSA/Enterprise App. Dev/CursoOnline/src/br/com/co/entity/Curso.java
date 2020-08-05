package br.com.co.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CURSO")
@SequenceGenerator(name="curso", allocationSize = 1, sequenceName = "SQ_TB_CURSO")
public class Curso {
	
	@Id
	@Column(name="cd_curso")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="curso")
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="cd_professor", nullable=false)
	private Professor professor;
	
	//Tabela associativa - "TB_CURSANDO"
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="TB_CURSANDO", 
				joinColumns=@JoinColumn(name="cd_curso"),
				inverseJoinColumns=@JoinColumn(name="cd_aluno"))
	private List<Aluno> alunos;
	
	@Column(name="nm_curso", nullable=false)
	private String nome;
	
	@Column(name="hr_duracao", nullable=false)
	private int horas;
	
	@Column(name="vl_curso", nullable=false)
	private float valor;

	public Curso() {
		super();
	}

	public Curso(String nome, int horas, float valor) {
		super();
		this.nome = nome;
		this.horas = horas;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
}
