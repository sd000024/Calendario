package es.uja.calendario.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="usuario ya registrado en el sistema")
public class UsuarioYaRegistrado extends RuntimeException{
	private static final long serialVersionUID = 1626719340828698588L;
}
