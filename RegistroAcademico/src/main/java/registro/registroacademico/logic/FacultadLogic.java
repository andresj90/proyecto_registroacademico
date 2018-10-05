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
    public List<FacultadEntity> getFacultades(){
      List<FacultadEntity> facultades = facultadPersistance.findAll();
      return facultades;
    }
    
    /**
     * Obtener una facultad a través del id
     * @param id
     * @return 
     */
    
    public  FacultadEntity getFacultad(int id){
     FacultadEntity facultad = facultadPersistance.find(id);
     if (facultad == null) {
            throw new IllegalArgumentException("La facultad solicitado no existe");
        }
     return facultad;
    }
    
    /**
     * Crear una nueva facultad
     * @param facultadEntity
     * @return 
     */
    
    public FacultadEntity createFacultad(FacultadEntity facultadEntity){
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
    
    public void deleteFacultad(int id){
        facultadPersistance.remove(id);
    }
}//class
    