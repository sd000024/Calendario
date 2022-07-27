package es.uja.calendario.seguridad;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;

import es.uja.calendario.entidades.Usuario;
import es.uja.calendario.excepciones.UsuarioNoExiste;
import es.uja.calendario.repositorios.RepositorioUsuario;

import java.util.HashSet;
import java.util.Set;

@Service
public class CalendarioDetailsServiceImpl implements UserDetailsService{
	
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Usuario u = repositorioUsuario.findById(username).orElseThrow(UsuarioNoExiste::new);
        if (u == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USUARIO"));


        return new User(u.getUsername(), u.getPassword(), grantedAuthorities);
    }
}
