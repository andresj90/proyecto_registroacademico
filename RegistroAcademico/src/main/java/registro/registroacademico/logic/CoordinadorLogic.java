package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.CoordinadorEntity;
import registro.registroacademico.persistence.CoordinadorPersistence;

/**
 * Logica de negocio Coordinador
 * @author AndresJ90
 */

@Stateless
public class CoordinadorLogic {
    
    @Inject 
    private CoordinadorPersistence coordinadorPersistance; 
    
    /**
     * Obtener todos los coordinadores
     * @return coordinadores 
     */
    public List<CoordinadorEntity> getCoordinadores(){
      List<CoordinadorEntity> coordinadores = coordinadorPersistance.findAll();
      return coordinadores;
    }
    
    /**
     * Obtener un coordinador a través del id
     * @param id
     * @return 
     */
    
    public  CoordinadorEntity getCoordinador(int id){
     CoordinadorEntity coordinador = coordinadorPersistance.find(id);
     return coordinador;
    }
    
    /**
     * Crear un nuevo coordinador
     * @param coordinadorEntity
     * @return 
     */
    
    public CoordinadorEntity createCoordinador(CoordinadorEntity coordinadorEntity){
      coordinadorPersistance.create(coordinadorEntity); 
      return  coordinadorEntity;
    }
    
    /**
     * Actualizar coordinador
     * @param id
     * @param coordinadorEntity
     * @return 
     */
    
    public CoordinadorEntity updateCoordinador(int id, CoordinadorEntity coordinadorEntity){
     CoordinadorEntity coordinador = coordinadorPersistance.update(coordinadorEntity); 
     return coordinador;
    }
    
    /**
     * metodo para eliminar coordinador de la tabla
     * @param id 
     */
    
    public void removeCoordinador(int id){
        coordinadorPersistance.remove(id);
    }
}//class
