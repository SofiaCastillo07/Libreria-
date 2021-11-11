
package ar.edu.egg.aplicacion.servicios;

import ar.edu.egg.aplicacion.entidades.Autor;
import ar.edu.egg.aplicacion.entidades.Editorial;
import ar.edu.egg.aplicacion.entidades.Libro;
import ar.edu.egg.aplicacion.repositorios.AutorRepositorio;
import ar.edu.egg.aplicacion.repositorios.EditorialRepositorio;
import ar.edu.egg.aplicacion.repositorios.LibroRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroServicio {
 
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private EditorialRepositorio editorialRepositorio;
    @Autowired
    private LibroRepositorio libroRepositorio;
     
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public Libro guardarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados,Integer ejemplaresRestantes, String autor, String editorial){
       
        Libro libro = new Libro();
        
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libro.setEjemplaresRestantes(ejemplaresRestantes);
        libro.setAlta(true);
        libro.setAutor(guardarAutor(autor));
        libro.setEditorial(guardarEditorial(editorial));
        return libroRepositorio.save(libro);
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public Autor guardarAutor(String nombre){
        
        Autor autor = new Autor();
        
        autor.setNombre(nombre);
        autor.setAlta(true);
        
        return autorRepositorio.save(autor);
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public Editorial guardarEditorial(String nombre){
        
        Editorial editorial = new Editorial();
        
        editorial.setNombre(nombre);
        editorial.setAlta(true);
        
        return editorialRepositorio.save(editorial);
    }
    
    @Transactional(readOnly = true)
	public List<Libro> listarActivos() {
		return libroRepositorio.findByAltaTrueOrderByAlta();
	}

	@Transactional(readOnly = true)
	public List<Libro> listarTodos() {
		return libroRepositorio.findAllByOrderByTituloAsc();
	}
        
        @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Libro alta(String id) {

		Libro entidad = libroRepositorio.getOne(id);

		entidad.setAlta(true);
		return libroRepositorio.save(entidad);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Libro baja(String id) {

		Libro entidad = libroRepositorio.getOne(id);

		entidad.setAlta(false);
		return libroRepositorio.save(entidad);
	}
        
       
}
