package br.com.graac.cupomdavida.application.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DESCONTO")
public class Desconto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "NM_PARCEIRO")
	private String parceiro;
	
	@Column(name = "VL_DESCONTO")
	private String desconto;
	
	@Column(name = "QTDE_PONTUACAO_MINIMA")
	private Integer pontuacaoMinima;

	@Column(name = "DT_VENCIMENTO")
	private Date dataVencimento;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

	public Integer getPontuacaoMinima() {
		return pontuacaoMinima;
	}

	public void setPontuacaoMinima(Integer pontuacaoMinima) {
		this.pontuacaoMinima = pontuacaoMinima;
	}

	public String getParceiro() {
		return parceiro;
	}

	public void setParceiro(String parceiro) {
		this.parceiro = parceiro;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
}
