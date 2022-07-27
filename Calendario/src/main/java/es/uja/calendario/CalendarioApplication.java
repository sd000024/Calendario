package es.uja.calendario;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.uja.calendario.entidades.Tareas;
import es.uja.calendario.entidades.Usuario;
import es.uja.calendario.interfaces.SistemaTareas;

@SpringBootApplication
public class CalendarioApplication {

	private static final Logger log = LoggerFactory.getLogger(CalendarioApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(CalendarioApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initApp(SistemaTareas sistema) {
		return (args) -> {
			// Preload sample users
			Usuario us = new Usuario("usuario","123456", "123456");
			sistema.nuevoUsuario(us);
			
			Tareas t1= new Tareas(1, "examen", "no hay examen ahora", "Jaen", 5, 
					LocalDateTime.now().plusDays(6).truncatedTo(ChronoUnit.SECONDS), us);
			sistema.nuevoTarea(t1);
			
			Tareas t2= new Tareas(2, "Pachanga", "Partido de fultbol con amigos", "Jaen", 5, 
					LocalDateTime.now().plusDays(1).truncatedTo(ChronoUnit.SECONDS), us);
			sistema.nuevoTarea(t2);
			
			Tareas t3= new Tareas(3, "Guia museo Ibero", "Visita guiada al museo Ibero de Jaen", "Jaen", 5, 
					LocalDateTime.now().plusDays(20).truncatedTo(ChronoUnit.SECONDS), us);
			sistema.nuevoTarea(t3);

			
	

			log.info("Usuario y tareas de prueba inicializados ");
			log.info("Usuario: usuario");
			log.info("password: 123456 ");
		};
	}

}
