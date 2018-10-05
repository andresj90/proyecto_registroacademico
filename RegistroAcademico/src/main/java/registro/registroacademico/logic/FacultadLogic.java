package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.FacultadEntity;
import registro.registroacademico.persistence.FacultadPersistence;

/**
 * Logica de negocio facultad
 * @author Uriel Rodríguez Vallarta
 */

@Stateless
public class FacultadLogic {
    
    @Inject 
    private FacultadPersistence facultadPersistance; 
    
    /**
     * Obtener todos las facultades
     * @return facultad
     */
    public List<FacultadEntity> getFacultad(){
      List<FacultadEntity> facultad = facultadPersistance.findAll();
      return facultad;
    }
    
    /**
     * Obtener una facultad a través del id
     * @param id
     * @return 
     */
    
    public  FacultadEntity getFacultad(int id){
     FacultadEntity facultad = facultadPersistance.find(id);
     return facultad;
    }
    
    /**
     * Crear una nueva facultad
     * @param facultadEntity
     * @return 
     */
    
    public FacultadEntity crearFacultad(FacultadEntity facultadEntity){
      facultadPersistance.create(facultadEntity); 
      return  facultadEntity;
    }
    
    /**
     * Actualizar facultad
     * @param id
     * @param facultadEntity
     * @return 
     */
    
    public FacultadEntity updateFacultad(int id, FacultadEntity facultadEntity){
     FacultadEntity facultad = facultadPersistance.update(facultadEntity); 
     return facultad;
    }
    
    /**
     * metodo para eliminar facultad de la tabla
     * @param id 
     */
    
    public void removeFacultad(int id){
        facultadPersistance.remove(id);
    }
}//class
    