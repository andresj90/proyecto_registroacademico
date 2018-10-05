package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.ProgramaEntity;
import registro.registroacademico.persistence.ProgramaPersistence;

/**
 * Logica de negocio programa
 * @author Uriel Rodríguez Vallarta
 */

@Stateless
public class ProgramaLogic {
    
    @Inject 
    private ProgramaPersistence programaPersistance; 
    
    /**
     * Obtener todos los programas
     * @return programa
     */
    public List<ProgramaEntity> getPrograma(){
      List<ProgramaEntity> programa = programaPersistance.findAll();
      return programa;
    }
    
    /**
     * Obtener un programa a través del id
     * @param id
     * @return 
     */
    
    public  ProgramaEntity getPrograma(int id){
     ProgramaEntity programa = programaPersistance.find(id);
     return programa;
    }
    
    /**
     * Crear un nuevo programa
     * @param programaEntity
     * @return 
     */
    
    public ProgramaEntity crearPrograma(ProgramaEntity programaEntity){
      programaPersistance.create(programaEntity); 
      return  programaEntity;
    }
    
    /**
     * Actualizar programa
     * @param id
     * @param programaEntity
     * @return 
     */
    
    public ProgramaEntity updatePrograma(int id, ProgramaEntity programaEntity){
     ProgramaEntity programa = programaPersistance.update(programaEntity); 
     return programa;
    }
    
    /**
     * metodo para eliminar programa de la tabla
     * @param id 
     */
    
    public void removePrograma(int id){
        programaPersistance.remove(id);
    }
}//class
    