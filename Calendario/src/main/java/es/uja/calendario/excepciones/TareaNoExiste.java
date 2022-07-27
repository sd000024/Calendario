package es.uja.calendario.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="La tareas no existe en el sistema")
public class TareaNoExiste extends RuntimeException{
	private static final long serialVersionUID = -1416356718297877123L;
}
