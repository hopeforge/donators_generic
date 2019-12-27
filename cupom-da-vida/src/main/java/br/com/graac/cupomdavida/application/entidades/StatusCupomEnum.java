package br.com.graac.cupomdavida.application.entidades;

public enum StatusCupomEnum {

	UTILIZADO("Utilizado"),
	NAO_UTILIZADO("Não Utilizado"),
	VENCIDO("Vencido");
	
	private String desc;

	private StatusCupomEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
}
