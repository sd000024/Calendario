package es.uja.calendario.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND , reason="usuario no esta registrado en el sistema")
public class UsuarioNoExiste extends RuntimeException{
	private static final long serialVersionUID = -6416354676267877127L;
}
