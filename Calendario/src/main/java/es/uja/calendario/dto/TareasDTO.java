package es.uja.calendario.dto;

import java.time.LocalDateTime;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TareasDTO {
     
	
	private int id;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String descripcion;
	
	@NotBlank
	private String lugar;
	
	@Positive
	private int duracion;
	
	@Future
	private LocalDateTime fechaHora;
	
	@NotNull
	private String organizadorId;	



	public TareasDTO(@NotBlank String titulo, @NotBlank String descripcion, @NotBlank String lugar,
			@Positive int duracion, @Future LocalDateTime fechaHora, @NotNull String organizadorId) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.duracion = duracion;
		this.fechaHora = fechaHora;
		this.organizadorId = organizadorId;
	}

	public TareasDTO(int id, @NotBlank String titulo, @NotBlank String descripcion, @NotBlank String lugar,
			@Positive int duracion, @Future LocalDateTime fechaHora, @NotNull String organizadorId) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.duracion = duracion;
		this.fechaHora = fechaHora;
		this.organizadorId = organizadorId;
	}

	public TareasDTO() {}

	public int getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getLugar() {
		return lugar;
	}
	
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	

	public String getOrganizadorId() {
		return organizadorId;
	}

	public void setOrganizadorId(String organizadorId) {
		this.organizadorId = organizadorId;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
