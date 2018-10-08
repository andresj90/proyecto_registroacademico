package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.CalificacionEntity;
import registro.registroacademico.persistence.CalificacionPersistence;


/**
 * Logica de negocio Calificacion
 * @author AndresJ90
 */

@Stateless
public class CalificacionLogic {
   
    @Inject 
    private CalificacionPersistence calificacionPersistence; 
    
    /**
     * Obtener todos los calificaciones
     * @return calificaciones 
     */
    public List<CalificacionEntity> getCalificaciones(){
      List<CalificacionEntity> calificaciones = calificacionPersistence.findAll();
      return calificaciones;
    }
    
    /**
     * Obtener una calificacion a través del id
     * @param id
     * @return 
     */
    
    public  CalificacionEntity getCalificacion(int id){
     CalificacionEntity calificacion = calificacionPersistence.find(id);
        if (calificacion == null) {
            throw new IllegalArgumentException("La calificacion solicitada no existe");
        }
     return calificacion;
    }
    
    /**
     * Crear una nueva calificacion
     * @param calificacionEntity 
     * @return 
     */
    
    public CalificacionEntity createCalificacion(CalificacionEntity calificacionEntity){
      calificacionPersistence.create(calificacionEntity); 
      return  calificacionEntity;
    }
    
    /**
     * Actualizar calificacion
     * @param id
     * @param calificacionEntity 
     * @return 
     */
    
    public CalificacionEntity updateCalificacion(int id, CalificacionEntity calificacionEntity){
     CalificacionEntity calificacion = calificacionPersistence.update(calificacionEntity); 
     return calificacion;
    }
    
    /**
     * metodo para eliminar una calificacion de la tabla
     * @param id 
     */
    
    public void deleteCalificacion(int id){
        calificacionPersistence.remove(id);
    }
}//class
