package br.com.triadworks.erp.controller.validator;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class MaiorDeIdadeValidator implements Validator {

	@Override
	public void validate(FacesContext ctx, UIComponent component, Object value)
			throws ValidatorException {
		
		Date data = (Date) value;
		Date hoje = new Date();

		long diferenca = hoje.getTime() - data.getTime();
		long idade = (TimeUnit.MILLISECONDS.toDays(diferenca) / 365);
		
		if (idade < 18) {
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"Funcionário menor de idade",
							"Funcionário deve ser maior de 18 nesta empresa"));
		}
	}
}