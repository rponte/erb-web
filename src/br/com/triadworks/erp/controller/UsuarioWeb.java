package br.com.triadworks.erp.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.triadworks.erp.modelo.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioWeb implements Serializable {

	private Usuario usuario;

	public void loga(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}
