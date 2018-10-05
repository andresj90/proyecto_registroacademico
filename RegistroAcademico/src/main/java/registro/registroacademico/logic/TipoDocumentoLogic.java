package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.TipoDocumentoEntity;
import registro.registroacademico.persistence.TipoDocumentoPersistence;


/**
 *Logica de negocio TipoDocumento
 * @author AndresJ90
 */
@Stateless
public class TipoDocumentoLogic {
    
    @Inject 
    private TipoDocumentoPersistence tipoDocumentoPersistence; 
    
    /**
     * Obtener todos los tipos  de documentos
     * @return tipoDeDocumentos 
     */
    public List<TipoDocumentoEntity> getTipoDocumentos(){
      List<TipoDocumentoEntity> tipoDeDocumentos = tipoDocumentoPersistence.findAll();
      return tipoDeDocumentos;
    }
    
    /**
     * Obtener un tipo  de documento a través del id
     * @param id
     * @return 
     */
    
    public  TipoDocumentoEntity getTipoDocumento(int id){
     TipoDocumentoEntity tipoDocumento = tipoDocumentoPersistence.find(id);
        if (tipoDocumento == null) {
            throw new IllegalArgumentException("El tipo de documento solicitado no existe");
        }
     return tipoDocumento;
    }
    
    /**
     * Crear un nuevo tipo  de documento
     * @param tipoDocumentoEntity 
     * @return 
     */
    
    public TipoDocumentoEntity createTipoDocumento(TipoDocumentoEntity tipoDocumentoEntity){
      tipoDocumentoPersistence.create(tipoDocumentoEntity); 
      return  tipoDocumentoEntity;
    }
    
    /**
     * Actualizar tipo  de documento
     * @param id
     * @param tipoDocumentoEntity 
     * @return 
     */
    
    public TipoDocumentoEntity updateTipoDocumento(int id, TipoDocumentoEntity tipoDocumentoEntity){
     TipoDocumentoEntity tipoDocumento = tipoDocumentoPersistence.update(tipoDocumentoEntity); 
     return tipoDocumento;
    }
    
    /**
     * metodo para eliminar un tipo  de documento de la tabla
     * @param id 
     */
    
    public void deleteTipoDocumento(int id){
        tipoDocumentoPersistence.remove(id);
    }
}
