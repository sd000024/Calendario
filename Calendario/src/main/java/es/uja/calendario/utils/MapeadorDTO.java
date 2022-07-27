package es.uja.calendario.utils;



import org.springframework.web.util.HtmlUtils;

import es.uja.calendario.dto.TareasDTO;
import es.uja.calendario.dto.UsuarioDTO;
import es.uja.calendario.entidades.Tareas;
import es.uja.calendario.entidades.Usuario;

public class MapeadorDTO {

	public  TareasDTO aCalendarioTareasDTO(Tareas tareas) {
		return new TareasDTO(tareas.getId(), tareas.getTitulo(), tareas.getDescripcion(), tareas.getLugar(), 
				tareas.getDuracion(), tareas.getFechaHora(), tareas.getOrganizador().getUsername());
	}
	
	public  Tareas aCalendarioTareas(TareasDTO tDTO, Usuario u) {
		return new Tareas(tDTO.getTitulo(), tDTO.getDescripcion(), tDTO.getLugar(), 
				tDTO.getDuracion(), tDTO.getFechaHora(), u);
	}
	
	
	/** Prevention of XSS*/
	public void sanitizeEventoDTO(TareasDTO t) {
		//Use Spring HtmlUtils html/js encoders
		t.setTitulo(HtmlUtils.htmlEscape( t.getTitulo() ));
		t.setDescripcion(HtmlUtils.htmlEscape( t.getDescripcion() ));
	}

	public void sanitizeUsuarioDTO(UsuarioDTO u) {
		//Use Spring HtmlUtils html/js encoders
		u.setUsername(HtmlUtils.htmlEscape( u.getUsername() ));
	}

	public Usuario aUsuario(UsuarioDTO uDTO) {
		return new Usuario(uDTO.getUsername(), uDTO.getPassword(), uDTO.getPasswordConfirm());
	}
}
