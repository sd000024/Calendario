package es.uja.calendario.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.ActiveProfiles;

import es.uja.calendario.CalendarioApplication;
import es.uja.calendario.entidades.Tareas;
import es.uja.calendario.entidades.Usuario;
import es.uja.calendario.interfaces.SistemaTareas;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


@SpringBootTest (classes= {CalendarioApplication.class})
@ActiveProfiles(profiles="test")
public class SistemaTareaIntegracionTest {
	
	@Autowired
	SistemaTareas sistemaTarea;
	
	Usuario u;
	Tareas t;
	Tareas t2;
	Tareas t3;
	int id1=1;
	int id2=2;
	int id3=3;
	

	@Test
    @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)	
	public void buscaTareaPorId() {
		
		LocalDateTime fecha1 = LocalDateTime.now().plusDays(1).truncatedTo(ChronoUnit.SECONDS);
		
		 u = new Usuario("prueba", "123456", "123456");
		  t= new Tareas(id1, "Tarea1", "es para hacer los ejercicio de prueba1", 
				"Jaen", 5, fecha1, u);
		 
		 sistemaTarea.nuevoUsuario(u);
		 sistemaTarea.nuevoTarea(t);
		
		Assertions.assertThat(sistemaTarea.buscarTareaPorId(id1)).isNotEmpty();
	}
	
	

	@Test
    @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)	
	public void boraTareaPorId() {
		LocalDateTime fecha1 = LocalDateTime.now().plusDays(1).truncatedTo(ChronoUnit.SECONDS);
		
		 u = new Usuario("prueba", "123456", "123456");
		 t= new Tareas(id1, "Tarea1", "es para hacer los ejercicio de prueba1", 
				"Jaen", 5, fecha1, u);
		 
		 
		 sistemaTarea.nuevoUsuario(u);
		 sistemaTarea.nuevoTarea(t);
		 
		Assertions.assertThatCode(()-> sistemaTarea.boraTarea(id1)).doesNotThrowAnyException();

	}
	
	
	@Test
    @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)	
	public void actualizaTarea() {
		
		LocalDateTime fecha = LocalDateTime.now().plusDays(1).truncatedTo(ChronoUnit.SECONDS);
		
		 u = new Usuario("prueba", "123456", "123456");
		 t= new Tareas(id1, "Tarea1", "es para hacer los ejercicio de prueba1", 
				"Jaen", 5, fecha, u);
		 
		 sistemaTarea.nuevoUsuario(u);
		 sistemaTarea.nuevoTarea(t);
		 
		LocalDateTime fechaAc = LocalDateTime.now().plusYears(5).truncatedTo(ChronoUnit.SECONDS);
		
		String nuevo_desc="es para hacer los ejercicio de actualizacion";
		String nuevo_titulo="Tarea actualizada";
		String nuevo_lugar="Linares";
		int nuevo_dur=20;
		
		t.setDescripcion(nuevo_desc);
		t.setTitulo(nuevo_titulo);
		t.setLugar(nuevo_lugar);
		t.setDuracion(nuevo_dur);
		t.setFechaHora(fechaAc);
		
		assertTrue(sistemaTarea.actualizaTareas(t));

	}


	@Test
    @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)	
	public void buscaPorFecha() {
		LocalDateTime fecha1 = LocalDateTime.now().plusDays(1).truncatedTo(ChronoUnit.SECONDS);
		LocalDateTime fecha2 = LocalDateTime.now().plusMonths(1).truncatedTo(ChronoUnit.SECONDS);
		LocalDateTime fecha3 = LocalDateTime.now().plusYears(1).truncatedTo(ChronoUnit.SECONDS);
		
		 u = new Usuario("prueba", "123456", "123456");
		 t= new Tareas(id1, "Tarea1", "es para hacer los ejercicio de prueba1", 
				"Jaen", 5, fecha1, u);
		 t2= new Tareas(id2, "Tarea2", "es para hacer los ejercicio de prueba2", 
				"Malaga", 15, fecha2, u);
		 t3= new Tareas(id3, "Tarea3", "es para hacer los ejercicio de prueb3a", 
				"Linares", 25, fecha3, u);
		 sistemaTarea.nuevoUsuario(u);
		 sistemaTarea.nuevoTarea(t);
		 sistemaTarea.nuevoTarea(t2);
		 sistemaTarea.nuevoTarea(t3);
		LocalDateTime inicio = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
		LocalDateTime fin = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).plusMonths(5);
		
		
		List<Tareas> lct=sistemaTarea.buscaTareas(inicio, fin);
		
		
		Assertions.assertThat(lct).isNotEmpty(); 
		Assertions.assertThat(lct.size()==2); 
		
		Assertions.assertThat(lct.get(0).getId()== id1);
		Assertions.assertThat(lct.get(1).getId()== id2);

	}
}
