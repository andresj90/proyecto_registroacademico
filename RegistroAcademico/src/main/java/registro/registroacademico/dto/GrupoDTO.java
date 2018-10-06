
package registro.registroacademico.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import registro.registroacademico.entities.GrupoEntity;

/**
 * Clase para modelar la Entidad Tipo Curso
 * @author David Cañon
 */
public class GrupoDTO {
   /**
   * Lista de atributos que hacen referencia al objeto Grupo
   */
  private Long idGrupo;
  private String nombreGrupo;
  /**
   * Constructor por defecto
   */  
  
    public GrupoDTO() {
    }
 
    /**
     * Mapeo de Entidad a Objeto
     * @param grupoEntity 
     */
    public GrupoDTO(GrupoEntity grupoEntity) {
        this.idGrupo = grupoEntity.getIdGrupo();
        this.nombreGrupo = grupoEntity.getNombreGrupo();
    }
    
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */

    public GrupoEntity toEntity(){
        
        GrupoEntity entity = new GrupoEntity(); 
        entity.setIdGrupo(this.idGrupo);
        entity.setNombreGrupo(this.nombreGrupo);
        
        return entity;
    }
    
    /**
     * Conversor lista entidad a lista de objetos Grupo
     * @param grupoEntitys
     * @return 
     */
    
    public static List<GrupoDTO> tolistGrupo(List<GrupoEntity> grupoEntitys){
        
        List<GrupoDTO> listaObjectoHorario = new ArrayList<>();
        for (int i = 0; i <grupoEntitys.size(); i++) {
            listaObjectoHorario.add(new GrupoDTO(grupoEntitys.get(i)));
        }
        
        return listaObjectoHorario;
    }
    /**
     * Métodos GET Y SET
     * @return 
     */
    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
}