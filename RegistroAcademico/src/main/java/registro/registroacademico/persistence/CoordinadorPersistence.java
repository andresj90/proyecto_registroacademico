package registro.registroacademico.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import registro.registroacademico.entities.CoordinadorEntity;
import registro.registroacademico.entities.DocenteEntity;

/**
 * Clase creada para maneejar la transaccionalidad de la entidad Coordinador
 * @author AndresJ90
 */
@Stateless
public class CoordinadorPersistence {
    
      //personalizamos el entity manager
    
    @PersistenceContext(unitName = "registroacademicoPU")
    private EntityManager entityManager; 
    
    /**
     * Metodo que lista todos los elementos que se encuentran en la clase Coordinador
     * @return 
     */
    
    public List<CoordinadorEntity> findAll(){
        
        Query todos = entityManager.createQuery("Select c from Coordinador c");
        return todos.getResultList();
    }
    
    /**
     * Metodo que retorna el Coordinador que contiene el id ingresado
     * @para id
     * @return CoordinadorEncontrado
     */
    
    public CoordinadorEntity find (int id){
        
        CoordinadorEntity coordinadorEncontrado =entityManager.find(CoordinadorEntity.class, id); 
        return coordinadorEncontrado; 
    }
    
    /**
     * Metodo que nos permite crear un usuario Coordinador
     * @para CoordinadorCrear
     * @return 
     */
    
    public CoordinadorEntity create(CoordinadorEntity coordinadorCrear){
        entityManager.persist(coordinadorCrear);
        return coordinadorCrear;
    }
    
    /**
     * Metodo que nos permite actualizar la informacion de un Coordinador
     * @param CoordinadorActualizar
     * @return 
     */
    
    public CoordinadorEntity update(CoordinadorEntity coordinadorActualizar){
        entityManager.merge(coordinadorActualizar);
        return coordinadorActualizar;
    }
    
    /**
     * Metodo que nos permite remover una entidad Coordinador
     * @param id
     */
    
     public void remove(int id){
         CoordinadorEntity coordinadorEliminar = entityManager.find(CoordinadorEntity.class, id);
         entityManager.remove(coordinadorEliminar);
     }
}
