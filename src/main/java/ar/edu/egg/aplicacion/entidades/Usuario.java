
package ar.edu.egg.aplicacion.entidades;

import ar.edu.egg.aplicacion.enumeracoines.Rol;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
/**
 *
 * @author Sofia
 */
@Data
@Entity
public class Usuario {
    
    private static final long serialVersionUID = 6522896498689132123L;
    
        @Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String nombre;

	private String apellido;

	private String email;
        
        @Enumerated(EnumType.STRING)
	private Rol rol;

	private String clave;

	@Temporal(TemporalType.DATE)
	private Date creado;

	@Temporal(TemporalType.DATE)
	private Date editado;

	private boolean activo;
    
}
