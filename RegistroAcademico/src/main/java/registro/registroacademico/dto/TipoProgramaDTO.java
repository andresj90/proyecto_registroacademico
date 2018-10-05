package registro.registroacademico.dto;

import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.TipoProgramaEntity;

/**
 * Clase que permite hacer la transferencia a objeto 
 * @author Uriel Rodríguez Vallarta
 */
public class TipoProgramaDTO {
   
  /**
   * Lista de atributos que hacen referencia al objeto Tipo Programa
   */    
  private int id_tipo_programa;
  private String nombre_tipo_programa; 

  /**
   * Constructor por defecto
   */  
  
    public TipoProgramaDTO() {
    }
 
    /**
     * Mapeo de Entidad a Objeto
     * @param TipoProgramaEntity 
     */
    public TipoProgramaDTO(TipoProgramaEntity TipoProgramaEntity) {
        this.id_tipo_programa = TipoProgramaEntity.getId_tipo_programa();
        this.nombre_tipo_programa = TipoProgramaEntity.getNombre_tipo_programa();
    }
    
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */

    public TipoProgramaEntity toEntity(){
        TipoProgramaEntity entity = new TipoProgramaEntity(); 
        entity.setId_tipo_programa(this.id_tipo_programa);
        entity.setNombre_tipo_programa(this.nombre_tipo_programa);
        
        return entity;
    }
    
    /**
     * Conversor lista entidad a lista de objetos Coordinador
     * @param tipoProgramaEntitys
     * @return 
     */
    
    public static List<TipoProgramaDTO> tolistTipoPrograma(List<TipoProgramaEntity> tipoProgramaEntitys){
        
        List<TipoProgramaDTO> listaObjectoTipoPrograma = new ArrayList<>();
        for (int i = 0; i <tipoProgramaEntitys.size(); i++) {
            listaObjectoTipoPrograma.add(new TipoProgramaDTO(tipoProgramaEntitys.get(i)));
        }
        
        return listaObjectoTipoPrograma;
    
    }

    
    /**
     * Metodos GET AND SET
     * @return 
     */

    public int getId_tipo_programa() {
        return id_tipo_programa;
    }

    public void setId_tipo_programa(int id_tipo_programa) {
        this.id_tipo_programa = id_tipo_programa;
    }

    public String getNombre_tipo_programa() {
        return nombre_tipo_programa;
    }

    public void setNombre_tipo_programa(String nombre_tipo_programa) {
        this.nombre_tipo_programa = nombre_tipo_programa;
    }
}