package br.com.transpobrasil.test.convert;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.transpobrasil.test.model.Posting;
import br.com.transpobrasil.test.service.IPostingService;



@FacesConverter(forClass = Posting.class)
public class PostingConvert implements Converter {

	   @Inject
	    private IPostingService postingService;

	    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	        if(value == null || value.equals("")) {
	            return null;
	        }
	        
	        Posting posting = postingService.byCode(Long.parseLong(value));
	        if(posting == null) {
	            throw new ConverterException(new FacesMessage("Posting with number: " + value + " not found."));
	        }
	        return posting;
	    }

	    public String getAsString(FacesContext context, UIComponent component, Object value) {
	        if (!(value instanceof Posting) || (value == null)) {
	            return null;
	        }
	        return String.valueOf(((Posting)value).getCode());
	    }

}
