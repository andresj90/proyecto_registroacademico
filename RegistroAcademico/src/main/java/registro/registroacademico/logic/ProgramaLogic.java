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
    public List<ProgramaEntity> getProgramas(){
      List<ProgramaEntity> programas = programaPersistance.findAll();
      return programas;
    }
    
    /**
     * Obtener un programa a través del id
     * @param id
     * @return 
     */
    
    public  ProgramaEntity getPrograma(int id){
     ProgramaEntity programa = programaPersistance.find(id);
     if (programa == null) {
            throw new IllegalArgumentException("El programa solicitado no existe");
        }
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
    
    public void deletePrograma(int id){
        programaPersistance.remove(id);
    }
}//class
    