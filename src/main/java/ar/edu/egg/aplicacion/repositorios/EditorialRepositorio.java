
package ar.edu.egg.aplicacion.repositorios;

import ar.edu.egg.aplicacion.entidades.Editorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial,String>  {
    
    //@Query ("SELECT a from Editorial a WHERE a.isAlta = true")
    public List<Editorial> findByNombreContainingOrderByNombre (String nombre);
    
    public List <Editorial> findAllByOrderByNombreAsc();
    
    
}
