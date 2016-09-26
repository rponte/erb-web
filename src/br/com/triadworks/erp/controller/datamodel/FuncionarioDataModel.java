package br.com.triadworks.erp.controller.datamodel;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.ExtendedDataModel;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;

import br.com.triadworks.erp.dao.FuncionarioDao;
import br.com.triadworks.erp.modelo.Funcionario;

@ViewScoped
@ManagedBean
public class FuncionarioDataModel extends ExtendedDataModel<Funcionario> {
	
	private Integer rowKey;
	private Integer count;
	private List<Funcionario> lista;
	private int firstRow = -1;
	
	private FuncionarioDao dao;
	
	public FuncionarioDataModel() {
		this(new FuncionarioDao());
	}
	
	public FuncionarioDataModel(FuncionarioDao dao) {
		this.dao = dao;
	}

	@Override
	public Object getRowKey() {
		return rowKey;
	}

	@Override
	public void setRowKey(Object rowKey) {
		this.rowKey = (Integer) rowKey;
	}

	@Override
	public void walk(FacesContext ctx, DataVisitor visitor, Range range, Object argumento) {
		int firstRow = ((SequenceRange) range).getFirstRow();
		if (this.firstRow != firstRow) {
			int totalDeLinhas = ((SequenceRange) range).getRows();
			this.lista = dao.listaPaginada(firstRow, totalDeLinhas);
			for (int i = 0; i < lista.size(); i++) {
			    visitor.process(ctx, i, argumento);
			}
		}
	}

	@Override
	public int getRowCount() {
		if (count == null){
            count = dao.contaTodos();
        }
		return count;
	}

	@Override
	public Funcionario getRowData() {
		Funcionario funcionario = lista.get(rowKey);
		return funcionario;
	}

	@Override
	public int getRowIndex() {
		return rowKey == null ? 0 : rowKey;
	}

	@Override
	public boolean isRowAvailable() {
		return lista.size() > rowKey;
	}

	@Override
	public void setRowIndex(int arg0) {
		throw new UnsupportedOperationException();		
	}
	
	@Override
	public Object getWrappedData() {
		throw new UnsupportedOperationException();	
	}

	@Override
	public void setWrappedData(Object arg0) {
		throw new UnsupportedOperationException();		
	}

}
