package br.com.co.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * Informações relevantes referente a entidade Curriculo:

 * 
 * - tratamento se refere se o professor sera chamado de Senhor(a), Doutor(a), Mestre(a), 
 * de acordo com sua formação.
 * - a formação/instituição se referem a ultima formação ou a mais relevante, 
 * ex. "Doutorado em Ciencias Socias", "Universidade Paulista".
 * Para as outras formações, como mestrado e/ou graduação utilizar os campos adicionais.
 *- tipoRegistro e codigoRegistro para profissionais que utilizem, 
 *ex:Advogados, Medicos -> tipo:OAB, CRM. e seus códigos respectivos.
 *
 *
 */

@Entity
@Table(name="TB_CURRICULO")
@SequenceGenerator(name="curriculo", sequenceName="SQ_TB_CURRICULO", allocationSize=1)
public class Curriculo {
	
	@Id
	@Column(name="cd_curriculo")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="curriculo")
	private int codigo;
	
	//bidirecional
	@OneToOne(mappedBy="curriculo", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private Professor professor;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tratamento", nullable=false)
	private Tratamento tratamento;
	
	@Column(name="ds_formacao", nullable=false)
	private String formacao;
	
	@Column(name="ds_instituicao", nullable=false)
	private String instituicao;
	
	@Column(name="ds_registro")
	private String tipoRegistro;
	
	@Column(name="vl_registro")
	private String codigoRegistro;
	
	@Column(name="ds_adicionais")
	private String adicionais;

	public Curriculo() {
		super();
	}

	public Curriculo(Professor professor, Tratamento tratamento, String formacao, String instituicao) {
		super();
		this.professor = professor;
		this.tratamento = tratamento;
		this.formacao = formacao;
		this.instituicao = instituicao;
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

	public Tratamento getTratamento() {
		return tratamento;
	}

	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(String adicionais) {
		this.adicionais = adicionais;
	}
	
}
