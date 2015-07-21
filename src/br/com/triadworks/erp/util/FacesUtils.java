package br.com.triadworks.erp.util;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;

public class FacesUtils {

	public void limpa(UIComponent component) {
	    if (component instanceof EditableValueHolder) {
	        EditableValueHolder evh = (EditableValueHolder) component;
	        evh.resetValue();
	    }
	    if (component.getChildCount()>0){
	        for (UIComponent child : component.getChildren()) {
	            this.limpa(child);
	        }
	    }
	}
}
