package es.uja.calendario.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario {
	

	@NotBlank
	@Id
	@Column(nullable = false)
    private String username;

	@NotBlank
	@Column(nullable  = false)
    private String password;

    @Transient
	@NotBlank
    private String passwordConfirm;


    public Usuario() {
	}

	public Usuario(@NotBlank String username, @NotBlank String password, @NotBlank String passwordConfirm) {
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

	
}
