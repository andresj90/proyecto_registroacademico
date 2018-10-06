package registro.registroacademico.dto;

import java.util.ArrayList;
import java.util.List;
import registro.registroacademico.entities.TipoDocumentoEntity;

/**
 *Clase que permite hacer la transferencia a objeto 
 * @author AndresJ90
 */
public class TipoDocumentoDTO {
    
  /**
   * Lista de atributos que hacen referencia al objeto TipoDocumento
  */    
  
  private int id_tipo_documento;
  private String tipo_documento; 

    public TipoDocumentoDTO() {
    }

    /**
     * Mapeo de Entidad a Objeto
     * @param coordinadorEntity 
     */
    
    public TipoDocumentoDTO(TipoDocumentoEntity documentoEntity) {
        this.id_tipo_documento = documentoEntity.getId_tipo_documento();
        this.tipo_documento = documentoEntity.getTipo_documento();
    }
  
    /**
     * Mapear de Objeto a Entidad
     * @return 
     */
  
    public TipoDocumentoEntity toEntity(){
        TipoDocumentoEntity entity = new TipoDocumentoEntity();
        
        entity.setId_tipo_documento(this.id_tipo_documento);
        entity.setTipo_documento(this.tipo_documento);
        
        return entity;
    }
  
    /**
     * Conversor lista entidad a lista de objetos TipoDocumento
     * @param documentoEntitys  
     * @return 
     */
    
    public static List<TipoDocumentoDTO> tolistTipoDocumento(List<TipoDocumentoEntity> documentoEntitys){
        List<TipoDocumentoDTO> listaObjectoTipoDocumentos = new ArrayList<>(); 
        for (int i = 0; i < documentoEntitys.size(); i++) {
            
            listaObjectoTipoDocumentos.add(new TipoDocumentoDTO(documentoEntitys.get(i)));
        }
        
        return listaObjectoTipoDocumentos;
    }
    
    /**
     * Metodos GET AND SET
     * @return 
     */
  

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }
    
    
}//class
