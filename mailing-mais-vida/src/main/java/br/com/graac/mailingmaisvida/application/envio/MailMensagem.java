package br.com.graac.mailingmaisvida.application.envio;

import java.util.List;

public class MailMensagem {
private String remetente;
private List<String>destinatarios;
private String assunto;
private String corpo;

public MailMensagem(String remetente, List<String> destinatarios, String assunto, String corpo) {
	super();
	this.remetente = remetente;
	this.destinatarios = destinatarios;
	this.assunto = assunto;
	this.corpo = corpo;
}

public String getRemetente() {
	return remetente;
}

public void setRemetente(String remetente) {
	this.remetente = remetente;
}

public List<String> getDestinatarios() {
	return destinatarios;
}

public void setDestinatarios(List<String> destinatarios) {
	this.destinatarios = destinatarios;
}

public String getAssunto() {
	return assunto;
}

public void setAssunto(String assunto) {
	this.assunto = assunto;
}

public String getCorpo() {
	return corpo;
}

public void setCorpo(String corpo) {
	this.corpo = corpo;
}


}
