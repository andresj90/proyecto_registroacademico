package registro.registroacademico.dto;

import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.CalificacionEntity;

/**
 * Clase que permite hacer la transferencia a objeto 
 * @author AndresJ90
 */
public class CalificacionDTO {
    
    /**
   * Lista de atributos que hacen referencia al objeto Docente
   */   
    
    private int id_calificacion;
    private int curso_grupo_id;
    private int estudiante_id_est; 
    private float valor_nota; 

   /**
   * Constructor por defecto
   */  
    
    public CalificacionDTO() {
    }

    /**
     * Mapeo de Entidad a Objeto
     * @param coordinadorEntity 
     */
    
    
    
    public CalificacionDTO(CalificacionEntity calificacionEntity) {
        this.id_calificacion = calificacionEntity.getId_calificacion();
        this.curso_grupo_id = calificacionEntity.getCurso_grupo_id();
        this.estudiante_id_est = calificacionEntity.getEstudiante_id_est();
        this.valor_nota = calificacionEntity.getValor_nota();
    }
    
    
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */
    
    public CalificacionEntity toEntity(){
     CalificacionEntity entity = new CalificacionEntity();
     
     entity.setId_calificacion(id_calificacion);
     entity.setCurso_grupo_id(curso_grupo_id);
     entity.setEstudiante_id_est(estudiante_id_est);
     entity.setValor_nota(valor_nota);
             
     return entity;
    }
    
    /**
     * Conversor lista entidad a lista de objetos Calificacion
     * @param docenteEntitys 
     * @return 
     */
    
    public static List<CalificacionDTO> tolistCalificacion(List<CalificacionEntity> calificacionEntitys){
        
        List<CalificacionDTO> listaObjectoCalificacion = new ArrayList<>();
        for (int i = 0; i <calificacionEntitys.size(); i++) {
            listaObjectoCalificacion.add(new CalificacionDTO(calificacionEntitys.get(i)));
        }
        
        return listaObjectoCalificacion;
    }

    /**METODOS SET Y GET*/ 
    
    public int getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
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

    public float getValor_nota() {
        return valor_nota;
    }

    public void setValor_nota(float valor_nota) {
        this.valor_nota = valor_nota;
    }
    
}//class
