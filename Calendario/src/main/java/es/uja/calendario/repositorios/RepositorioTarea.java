package es.uja.calendario.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.uja.calendario.entidades.Tareas;

@Repository
public interface RepositorioTarea extends JpaRepository<Tareas, Integer>{
	
	@Query("select t from Tareas t where t.fechaHora between :from and :to")
	List<Tareas> findByFechaBetween(@Param("from") LocalDateTime desde, @Param("to")LocalDateTime hasta);


}
