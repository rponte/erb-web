package br.com.triadworks.erp.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.triadworks.erp.dao.FuncionarioDao;
import br.com.triadworks.erp.modelo.Funcionario;

@ViewScoped // javax.faces.bean.ViewScoped
@ManagedBean
public class FuncionarioDataModel extends LazyDataModel<Funcionario> {

	@Override
	public List<Funcionario> load(int inicio, int quantidade, String campoDeOrdenacao,
			SortOrder sentidoDeOrdenacao, Map<String, Object> filtros) {
		
		FuncionarioDao dao = new FuncionarioDao();
		this.setRowCount(dao.contaTodos());
		
		return dao.listaPaginada(inicio, quantidade);
	}
}
