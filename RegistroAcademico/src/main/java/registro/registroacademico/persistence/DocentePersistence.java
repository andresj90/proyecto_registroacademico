package registro.registroacademico.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import registro.registroacademico.entities.DocenteEntity;

/**
 * Clase creada para maneejar la transaccionalidad de la entidad Docente
 * @author AndresJ90
 */
@Stateless
public class DocentePersistence {
    
    //personalizamos el entity manager
    
    @PersistenceContext(unitName = "registroacademicoPU")
    private EntityManager entityManager; 
    
    /**
     * Metodo que lista todos los elementos que se encuentran en la clase Docente
     * @return 
     */
    
    public List<DocenteEntity> findAll(){
        
        Query todos = entityManager.createQuery("Select d from Docente d");
        return todos.getResultList();
    }
    
    /**
     * Metodo que retorna el docente que contiene el id ingresado
     * @para id
     * @return docenteEncontrado
     */
    
    public DocenteEntity find (int id){
        
        DocenteEntity docenteEncontrado =entityManager.find(DocenteEntity.class, id); 
        return docenteEncontrado; 
    }
    
    /**
     * Metodo que nos permite crear un usuario docente
     * @para docenteCrear
     * @return 
     */
    
    public DocenteEntity create(DocenteEntity docenteCrear){
        entityManager.persist(docenteCrear);
        return docenteCrear;
    }
    
    /**
     * Metodo que nos permite actualizar la informacion de un Docente
     * @param DocenteActualizar
     * @return 
     */
    
    public DocenteEntity update(DocenteEntity docenteActualizar){
        entityManager.merge(docenteActualizar);
        return docenteActualizar;
    }
    
    /**
     * Metodo que nos permite remover una entidad Docente
     * @param id
     */
    
     public void remove(int id){
         DocenteEntity docenteEliminar = entityManager.find(DocenteEntity.class, id);
         entityManager.remove(docenteEliminar);
     }
}
