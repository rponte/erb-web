package br.com.triadworks.erp.controller;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import br.com.triadworks.erp.dao.FuncionarioDao;
import br.com.triadworks.erp.modelo.Funcionario;
import br.com.triadworks.erp.util.FacesUtils;

@ManagedBean
public class FuncionarioBean {

	private Funcionario funcionario = new Funcionario();
	
	public List<Funcionario> getFuncionarios() {
		FuncionarioDao dao = new FuncionarioDao();
		return dao.lista();
	}

	public void salva() {
		FuncionarioDao dao = new FuncionarioDao();

		if (this.funcionario.getId() == null) {
			dao.adiciona(this.funcionario);
		} else {
			dao.atualiza(this.funcionario);
		}

		this.funcionario = new Funcionario(); // limpa os campos
	}
	
	public void remove(Funcionario funcionario) {
		FuncionarioDao dao = new FuncionarioDao();
		dao.remove(funcionario);
	}
	
	public void cancela() {
		
		UIComponent form = FacesContext.getCurrentInstance().getViewRoot().findComponent("form");
//		new FacesUtils().limpa(form);
		
		this.funcionario = new Funcionario();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
