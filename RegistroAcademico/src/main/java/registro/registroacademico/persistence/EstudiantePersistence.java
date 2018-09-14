package registro.registroacademico.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import registro.registroacademico.entities.EstudianteEntity;

/**
 * Clase creada para maneejar la transaccionalidad de la entidad Estudiante
 * @author AndresJ90
 */
@Stateless
public class EstudiantePersistence {
    
    //personalizamos el entity manager
    
    @PersistenceContext(unitName = "registroacademicoPU")
    private EntityManager entityManager; 
    
    /**
     * Metodo que lista todos los elementos que se encuentran en la clase Estudiante
     * @return 
     */
    
    public List<EstudianteEntity> findAll(){
        
        Query todos = entityManager.createQuery("Select e from Estudiante e");
        return todos.getResultList();
    }
    
    /**
     * Metodo que retorna el Estudiante que contiene el id ingresado
     * @para id
     * @return estudianteEncontrado
     */
    
    public EstudianteEntity find (int id){
        
        EstudianteEntity estudianteEncontrado =entityManager.find(EstudianteEntity.class, id); 
        return estudianteEncontrado; 
    }
    
    /**
     * Metodo que nos permite crear un usuario Estudiante
     * @para estudianteCrear
     * @return 
     */
    
    public EstudianteEntity create(EstudianteEntity estudianteCrear){
        entityManager.persist(estudianteCrear);
        return estudianteCrear;
    }
    
    /**
     * Metodo que nos permite actualizar la informacion de un Estudiante
     * @param estudianteActualizar
     * @return 
     */
    
    public EstudianteEntity update(EstudianteEntity estudianteActualizar){
        entityManager.merge(estudianteActualizar);
        return estudianteActualizar;
    }
    
    /**
     * Metodo que nos permite remover una entidad Estudiante
     * @param id
     */
    
     public void remove(int id){
         EstudianteEntity estudianteEliminar = entityManager.find(EstudianteEntity.class, id);
         entityManager.remove(estudianteEliminar);
     }
}
