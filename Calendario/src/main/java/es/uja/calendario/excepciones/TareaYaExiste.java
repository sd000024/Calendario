package es.uja.calendario.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT,  reason="La tarea ya existe en el sistema")
public class TareaYaExiste extends RuntimeException{
	private static final long serialVersionUID = -1416825676267877128L;
}
