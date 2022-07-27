package es.uja.calendario.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import es.uja.calendario.entidades.Tareas;
import es.uja.calendario.entidades.Usuario;

public interface SistemaTareas {
	

	boolean nuevoTarea(@Valid Tareas tarea);
	boolean actualizaTareas(@Valid Tareas tarea);
	List<Tareas> buscaTareas(LocalDateTime inicio, LocalDateTime fin);
	void boraTarea(int id);
	Optional<Tareas> buscarTareaPorId(int id);
	public boolean nuevoUsuario(@Valid Usuario u);
	Usuario getUsuario(String username);

}
