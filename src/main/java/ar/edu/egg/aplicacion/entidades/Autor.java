package ar.edu.egg.aplicacion.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Autor {
    @Id //uso id ya que estamos hablando de entidades persistentes
    @GeneratedValue(generator = "uuid") //generacion automatica del id 
    @GenericGenerator(name = "uuid", strategy = "uuid2") //id no duplicados
    private String id;
    private String nombre;
    private boolean alta;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
    
}
