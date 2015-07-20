package br.com.triadworks.erp.service;

import br.com.triadworks.erp.modelo.Usuario;

public interface Autenticador {

	public Usuario autentica(String login, String senha);
	
}