/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro.registroacademico.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import registro.registroacademico.entities.CalificacionEntity;

/**
 * Clase creada para maneejar la transaccionalidad de la entidad Calificacion
 * @author AndresJ90
 */
@Stateless
public class CalificacionPersistence {
    
    //personalizamos el entity manager
    
    @PersistenceContext(unitName = "registroacademicoPU")
    private EntityManager entityManager; 
    
    /**
     * Metodo que lista todos los elementos que se encuentran en la clase Calificacion
     * @return 
     */
    
    public List<CalificacionEntity> findAll(){
        
        Query todos = entityManager.createQuery("Select c from Calificacion c");
        return todos.getResultList();
    }
    
    /**
     * Metodo que retorna el Calificacion que contiene el id ingresado
     * @para id
     * @return calificacionEncontrada
     */
    
    public CalificacionEntity find (int id){
        
        CalificacionEntity calificacionEncontrada =entityManager.find(CalificacionEntity.class, id); 
        return calificacionEncontrada; 
    }
    
    /**
     * Metodo que nos permite crear un usuario Calificacion
     * @para calificacionCrear
     * @return 
     */
    
    public CalificacionEntity create(CalificacionEntity calificacionCrear){
        entityManager.persist(calificacionCrear);
        return calificacionCrear;
    }
    
    /**
     * Metodo que nos permite actualizar la informacion de un Calificacion
     * @param calificacionActualizar
     * @return 
     */
    
    public CalificacionEntity update(CalificacionEntity calificacionActualizar){
        entityManager.merge(calificacionActualizar);
        return calificacionActualizar;
    }
    
    /**
     * Metodo que nos permite remover una entidad Calificacion
     * @param id
     */
    
     public void remove(int id){
         CalificacionEntity calificacionEliminar = entityManager.find(CalificacionEntity.class, id);
         entityManager.remove(calificacionEliminar);
     }
}
