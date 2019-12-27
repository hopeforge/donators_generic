package br.com.graac.cupomdavida.application.entidades;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_DOADOR", uniqueConstraints = {@UniqueConstraint(columnNames = {"DS_EMAIL"})})
public class Doador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name="NM_DOADOR")
	private String nome;
	
	@Column(name="DS_EMAIL")
	private String email;
	
	@Column(name="QTDE_PONTUACAO")
	private Integer pontuacao;
	
	@OneToMany(mappedBy = "doador", cascade = CascadeType.ALL)
	private List<Cupom> cupons;

	@ManyToMany
	@JoinTable(name = "TB_MEUS_CUP_DESCONTOS", joinColumns = {@JoinColumn(name = "ID_DOADOR")} , inverseJoinColumns = {@JoinColumn(name = "ID_DESCONTO")})
	private List<Desconto> meusCuponsDescontos;
	
	public Doador() {}
	
	public Doador(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	

	public Doador(String nome, String email, Integer pontuacao) {
		super();
		this.nome = nome;
		this.email = email;
		this.pontuacao = pontuacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
		if(this.pontuacao < 0) {
			this.pontuacao = 0;
		}
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

	public int getPontuacao() {
		return pontuacao;
	}

	public List<Cupom> getCupons() {
		if(cupons == null) {
			cupons = new ArrayList<Cupom>();
		}
		return cupons;
	}

	public void setCupons(List<Cupom> cupons) {
		this.cupons = cupons;
	}

	public List<Desconto> getMeusCuponsDescontos() {
		if(meusCuponsDescontos == null) {
			meusCuponsDescontos = new ArrayList<Desconto>();
		}
		return meusCuponsDescontos;
	}

	public void setMeusCuponsDescontos(List<Desconto> meusCuponsDescontos) {
		this.meusCuponsDescontos = meusCuponsDescontos;
	}

}
