package es.uja.calendario.interfaces;


public interface ServicioSeguridad {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
