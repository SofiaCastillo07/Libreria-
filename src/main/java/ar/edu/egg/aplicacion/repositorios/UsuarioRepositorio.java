
package ar.edu.egg.aplicacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Sofia
 */
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
    
    @Query("SELECT a from Usuario a WHERE a.email LIKE :email AND a.activo = true")
    public Usuario buscarPorEmail(@Param("email") String email);
}
