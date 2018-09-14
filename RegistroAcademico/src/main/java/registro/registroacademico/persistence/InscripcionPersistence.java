package registro.registroacademico.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import registro.registroacademico.entities.InscripcionEntity;

/**
 * Clase creada para maneejar la transaccionalidad de la entidad Inscripcion
 * @author AndresJ90
 */
@Stateless
public class InscripcionPersistence {
    
       //personalizamos el entity manager
    
    @PersistenceContext(unitName = "registroacademicoPU")
    private EntityManager entityManager; 
    
    /**
     * Metodo que lista todos los elementos que se encuentran en la clase Inscripcion
     * @return 
     */
    
    public List<InscripcionEntity> findAll(){
        
        Query todos = entityManager.createQuery("Select i from inscripcion i");
        return todos.getResultList();
    }
    
    /**
     * Metodo que retorna el Inscripcion que contiene el id ingresado
     * @para id
     * @return inscripcionEncontrada
     */
    
    public InscripcionEntity find (int id){
        
        InscripcionEntity inscripcionEncontrada =entityManager.find(InscripcionEntity.class, id); 
        return inscripcionEncontrada; 
    }
    
    /**
     * Metodo que nos permite crear un usuario Inscripcion
     * @para inscripcionCrear
     * @return 
     */
    
    public InscripcionEntity create(InscripcionEntity inscripcionCrear){
        entityManager.persist(inscripcionCrear);
        return inscripcionCrear;
    }
    
    /**
     * Metodo que nos permite actualizar la informacion de un Inscripcion
     * @param inscripcionActualizar
     * @return 
     */
    
    public InscripcionEntity update(InscripcionEntity inscripcionActualizar){
        entityManager.merge(inscripcionActualizar);
        return inscripcionActualizar;
    }
    
    /**
     * Metodo que nos permite remover una entidad Inscripcion
     * @param id
     */
    
     public void remove(int id){
         InscripcionEntity inscripcionEliminar = entityManager.find(InscripcionEntity.class, id);
         entityManager.remove(inscripcionEliminar);
     }
}
