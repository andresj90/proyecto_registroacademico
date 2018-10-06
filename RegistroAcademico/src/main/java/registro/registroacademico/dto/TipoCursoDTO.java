
package registro.registroacademico.dto;

import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.TipoCursoEntity;
/**
 * Clase que permite hacer la transferencia a objeto 
 * @author DavidC
 */
public class TipoCursoDTO {
    /**
   * Lista de atributos que hacen referencia al objeto TipoCurso
   */
  private Long idTipoCurso;
  private String nombreTipoCurso;
  /**
   * Constructor por defecto
   */  
  
    public TipoCursoDTO() {
    }
 
    /**
     * Mapeo de Entidad a Objeto
     * @param tipoCursoEntity 
     */
    public TipoCursoDTO(TipoCursoEntity tipoCursoEntity) {
        this.idTipoCurso = tipoCursoEntity.getIdTipoCurso();
        this.nombreTipoCurso = tipoCursoEntity.getNombreTipoCurso();
    }
    
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */

    public TipoCursoEntity toEntity(){
        
        TipoCursoEntity entity = new TipoCursoEntity(); 
        entity.setIdTipoCurso(this.idTipoCurso);
        entity.setNombreTipoCurso(this.nombreTipoCurso);
        
        return entity;
    }
    
    /**
     * Conversor lista entidad a lista de objetos TipoCurso
     * @param tipoCursoEntitys
     * @return 
     */
    
    public static List<TipoCursoDTO> tolistTipoCurso(List<TipoCursoEntity> tipoCursoEntitys){
        
        List<TipoCursoDTO> listaObjectoHorario = new ArrayList<>();
        for (int i = 0; i <tipoCursoEntitys.size(); i++) {
            listaObjectoHorario.add(new TipoCursoDTO(tipoCursoEntitys.get(i)));
        }
        
        return listaObjectoHorario;
    }
    /**
     * Metodos GET AND SET
     */
    public Long getIdTipoCurso() {
        return idTipoCurso;
    }

    public void setIdTipoCurso(Long idTipoCurso) {
        this.idTipoCurso = idTipoCurso;
    }

    public String getNombreTipoCurso() {
        return nombreTipoCurso;
    }

    public void setNombreTipoCurso(String nombreTipoCurso) {
        this.nombreTipoCurso = nombreTipoCurso;
    }
    
}
