package es.uja.calendario.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Preferences implements Serializable {
 
	private static final long serialVersionUID = 1L;

	private String locale;	//idioma seleccionado	

    public Preferences () {
    	locale = "es";
    };

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
}
