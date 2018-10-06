package registro.registroacademico.dto;

import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.InscripcionEntity;

/**
 * Clase que permite hacer la transferencia a objeto 
 * @author AndresJ90
 */
public class InscripcionDTO {
    
  /**
   * Lista de atributos que hacen referencia al objeto Inscripcion
  */    
    
   private int id_inscripcion;
   private int curso_grupo_id;
   private int estudiante_id_est; 
  
   
   /**
   * Constructor por defecto
   */  
   
    public InscripcionDTO() {
    }
    
    /**
     * Mapeo de Entidad a Objeto
     * @param coordinadorEntity 
     */

    public InscripcionDTO(InscripcionEntity inscripcionEntity ) {
        this.id_inscripcion = inscripcionEntity.getId_inscripcion();
        this.curso_grupo_id = inscripcionEntity.getCurso_grupo_id();
        this.estudiante_id_est = inscripcionEntity.getEstudiante_id_est();
    }
   
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */
    
    public InscripcionEntity toEntity(){
        InscripcionEntity entity = new InscripcionEntity();
        
        entity.setId_inscripcion(this.id_inscripcion);
        entity.setCurso_grupo_id(this.curso_grupo_id);
        entity.setEstudiante_id_est(this.estudiante_id_est);
        
        return entity;
    }
    
    /**
     * Conversor lista entidad a lista de objetos Inscripcion
     * @param inscripcionEntitys  
     * @return 
     */
   
    public List<InscripcionDTO> tolistInscripcion(List<InscripcionEntity> inscripcionEntitys){
        List<InscripcionDTO> listaObjectoInscripcion = new ArrayList<>(); 
        for (int i = 0; i < inscripcionEntitys.size(); i++) {
            
            listaObjectoInscripcion.add(new InscripcionDTO(inscripcionEntitys.get(i)));
        }
        
        return listaObjectoInscripcion;
    }
    
    /**
     * Metodos GET AND SET
     * @return 
     */

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public int getCurso_grupo_id() {
        return curso_grupo_id;
    }

    public void setCurso_grupo_id(int curso_grupo_id) {
        this.curso_grupo_id = curso_grupo_id;
    }

    public int getEstudiante_id_est() {
        return estudiante_id_est;
    }

    public void setEstudiante_id_est(int estudiante_id_est) {
        this.estudiante_id_est = estudiante_id_est;
    }
    
}//class
