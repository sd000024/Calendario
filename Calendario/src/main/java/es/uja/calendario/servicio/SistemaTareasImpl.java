package es.uja.calendario.servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import es.uja.calendario.entidades.Tareas;
import es.uja.calendario.entidades.Usuario;
import es.uja.calendario.excepciones.TareaNoExiste;
import es.uja.calendario.excepciones.TareaYaExiste;
import es.uja.calendario.excepciones.UsuarioYaRegistrado;
import es.uja.calendario.interfaces.SistemaTareas;
import es.uja.calendario.repositorios.RepositorioTarea;
import es.uja.calendario.repositorios.RepositorioUsuario;

@Service
@Validated
public class SistemaTareasImpl implements SistemaTareas {

	@Autowired
	RepositorioTarea reposTareas;

	@Autowired
	RepositorioUsuario reposUsuario;

	Tareas tr;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public boolean nuevoUsuario(@Valid Usuario u) {
		if (reposUsuario.existsById(u.getUsername())) {
			throw new UsuarioYaRegistrado();
		}
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		Usuario us = reposUsuario.save(u);
		return us.equals(u);
	}

	@Override
	public Usuario getUsuario(String username) {
		return reposUsuario.getById(username);
	}

	@Override
	public boolean nuevoTarea(@Valid Tareas t) {
		if (reposTareas.existsById(t.getId())) {
			throw new TareaYaExiste();
		}
		return reposTareas.save(t).equals(t);

	}

	@Override
	public boolean actualizaTareas(@Valid Tareas t) {
		if (reposTareas.existsById(t.getId())) {
			throw new TareaNoExiste();
		}
		return reposTareas.save(t).equals(t);
	}

	@Override
	public List<Tareas> buscaTareas(LocalDateTime inicio, LocalDateTime fin) {
		return (List<Tareas>) reposTareas.findByFechaBetween(inicio, fin);
	}

	@Override
	public void boraTarea(int id) {

		if (!reposTareas.existsById(id)) {
			throw new TareaNoExiste();
		}
		reposTareas.deleteById(id);

	}

	@Override
	public Optional<Tareas> buscarTareaPorId(int id) {
		return reposTareas.findById(id);
	}
}
