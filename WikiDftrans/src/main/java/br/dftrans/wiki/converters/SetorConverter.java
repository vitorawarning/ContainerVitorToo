package br.dftrans.wiki.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import br.dftrans.wiki.dao.SetorDAO;
import br.dftrans.wiki.domain.Setor;

@FacesConverter(value="SetorConverter")
public class SetorConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        if (arg2 != null) {  
        	SetorDAO dao = new SetorDAO();
        	return dao.findBy(Long.parseLong(arg2));
        }  
        return null; 
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
	    String str = "";
	    if (arg2 instanceof Setor) {
	        str = "" + ((Setor) arg2).getId();
	    }
	    return str;
	}

}
