package es.uja.calendario.entidades;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Tareas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Column(nullable = false)
	private String titulo;

	@NotBlank
	@Column(nullable = false)
	private String descripcion;

	@NotBlank
	@Column(nullable = false)
	private String lugar;

	@Positive
	@Column
	private int duracion;

	@Future
	@Column
	private LocalDateTime fechaHora;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "organizador", nullable = false)
	private Usuario organizador;

	public Tareas(@Positive int id, @NotBlank String titulo, @NotBlank String descripcion, @NotBlank String lugar,
			@Positive int duracion, @Future LocalDateTime fechaHora, @NotNull Usuario organizador) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.duracion = duracion;
		this.fechaHora = fechaHora;
		this.organizador = organizador;
	}

	public Tareas(@NotBlank String titulo, @NotBlank String descripcion, @NotBlank String lugar, @Positive int duracion,
			@Future LocalDateTime fechaHora, @NotNull Usuario organizador) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.duracion = duracion;
		this.fechaHora = fechaHora;
		this.organizador = organizador;
	}

	public Tareas() {
	}

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

	public Usuario getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}

	public void setId(int id) {
		this.id = id;
	}

}
