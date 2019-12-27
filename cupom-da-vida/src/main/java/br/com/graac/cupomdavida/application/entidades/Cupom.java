package br.com.graac.cupomdavida.application.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CUPOM")
public class Cupom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique = true, nullable = false)
	private int id;
	
	@Column(name="NM_NOME_FANTASIA")
	private String nomeFantasia;
	
	@Column(name = "NR_CUPOM")
	private String numeroCupom;
	
	@Column(name="NM_RAZAO_SOCIAL")
	private String razaoSocial;
	
	@Column(name="DS_ENDERECO")
	private String endereco;
	
	@Column(name="DS_CNPJ")
	private String cnpj;
	
	@Column(name="DS_IE")
	private String inscricaoEstadual;
	
	@Column(name="DS_INSCRICAO_MUNICIPAL")
	private String incricaoMunicipal;
	
	@Column(name="DS_EMAIL")
	private String email;
	
	@Column(name="VL_VALOR")
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "ID_DOADOR", referencedColumnName = "ID")
	private Doador doador;
	
	@Column(name = "DT_CADASTRO")
	private Date dataCadastro;
	
	@Column(name = "DT_CUPOM")
	private Date dataCupom;
	
	@Column(name = "STS_CUPOM")
	@Enumerated(EnumType.STRING)
	private StatusCupomEnum status;
	
	@Column(name = "DS_DADOS_CUMPOM_OCR", length = 8000)
	private String dadosCupom;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getIncricaoMunicipal() {
		return incricaoMunicipal;
	}
	public void setIncricaoMunicipal(String incricaoMunicipal) {
		this.incricaoMunicipal = incricaoMunicipal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Doador getDoador() {
		return doador;
	}
	public void setDoador(Doador doador) {
		this.doador = doador;
	}
	public StatusCupomEnum getStatus() {
		return status;
	}
	public void setStatus(StatusCupomEnum status) {
		this.status = status;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataCupom() {
		return dataCupom;
	}
	public void setDataCupom(Date dataCupom) {
		this.dataCupom = dataCupom;
	}
	public String getDadosCupom() {
		return dadosCupom;
	}
	public void setDadosCupom(String dadosCupom) {
		this.dadosCupom = dadosCupom;
	}
	public String getNumeroCupom() {
		return numeroCupom;
	}
	public void setNumeroCupom(String numeroCupom) {
		this.numeroCupom = numeroCupom;
	}

}