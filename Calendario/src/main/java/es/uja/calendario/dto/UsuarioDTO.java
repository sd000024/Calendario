package es.uja.calendario.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

public class UsuarioDTO {

	private int id;

	@NotBlank
    private String username;

	@NotBlank
    private String password;

    @Transient
	@NotBlank
    private String passwordConfirm;


    public UsuarioDTO() {
	}

	public UsuarioDTO(@NotBlank String username, @NotBlank String password, @NotBlank String passwordConfirm) {
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public UsuarioDTO(int id, @NotBlank String username, @NotBlank String password, @NotBlank String passwordConfirm) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(@NotBlank String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
