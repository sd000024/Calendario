package es.uja.calendario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uja.calendario.entidades.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, String>{

}
