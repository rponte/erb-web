package br.com.triadworks.erp.service;

import br.com.triadworks.erp.dao.UsuarioDao;
import br.com.triadworks.erp.modelo.Usuario;

public class AutenticadorImpl implements Autenticador {

	@Override
	public Usuario autentica(String login, String senha) {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = dao.buscaPor(login, senha);
		return usuario;
	}

}