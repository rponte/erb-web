package br.com.triadworks.erp.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class FacesUtils {

	private FacesContext facesContext;

	public FacesUtils() {
		this.facesContext = FacesContext.getCurrentInstance();
	}

	public void adicionaMensagemDeSucesso(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		facesContext.addMessage(null, facesMessage);
	}
}
