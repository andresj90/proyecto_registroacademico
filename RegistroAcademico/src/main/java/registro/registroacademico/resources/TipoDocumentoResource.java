package registro.registroacademico.resources;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import registro.registroacademico.dto.TipoDocumentoDTO;
import registro.registroacademico.entities.TipoDocumentoEntity;
import registro.registroacademico.logic.TipoDocumentoLogic;


/**
 * Servicio REST TipoDocumento
 * @author AndresJ90
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tipodocumentos")
public class TipoDocumentoResource {
    
    @EJB
    private TipoDocumentoLogic tipoDocumentoLogic; 
    
    /**
     * Método REST para obtener todos los tipos de documentos
     * @return 
     */
    
    @GET
    public List<TipoDocumentoDTO> getListaTipoDocumentos(){
        List<TipoDocumentoEntity> tipoDocumentos = tipoDocumentoLogic.getTipoDocumentos(); 
        return TipoDocumentoDTO.tolistTipoDocumento(tipoDocumentos);
    }
    
    /**
     * Método REST para obtener un tipo de documento a través del id
     * @param id
     * @return 
     */
    
    @GET 
    @Path("{id_tipo_documento: \\d+}")
    public TipoDocumentoDTO getTipoDocumento(@PathParam("id_tipo_documento") int id){
        TipoDocumentoEntity tipoDocumento = tipoDocumentoLogic.getTipoDocumento(id); 
        if (tipoDocumento == null) {
            throw new RuntimeException("El tipo de documento no existe");
        }
        
        return new TipoDocumentoDTO(tipoDocumento);
    }
    
    /**
     * Método REST para crear un tipo de documento
     * @param tipoDocumentoCrear 
     * @return 
     */
    
    @POST 
    public TipoDocumentoDTO createTipoDocumento(TipoDocumentoDTO tipoDocumentoCrear){
        return new TipoDocumentoDTO(tipoDocumentoLogic.createTipoDocumento(tipoDocumentoCrear.toEntity()));
    }
    
    /**
     * Método REST para actualizar un tipo de documento
     * @param id
     * @param tipoDocumentoActualizar 
     * @return 
     */
    
    @PUT 
    @Path("{id_tipo_documento: \\d+}")
    public TipoDocumentoDTO updateTipoDocumento(@PathParam("id_tipo_documento") int id,TipoDocumentoDTO tipoDocumentoActualizar ){
        TipoDocumentoEntity entity = tipoDocumentoLogic.getTipoDocumento(id);
        
        if (entity == null) {
            
            throw new RuntimeException("El tipo de documento no existe");
        }
        
        return new TipoDocumentoDTO(tipoDocumentoLogic.updateTipoDocumento(id, tipoDocumentoActualizar.toEntity()));
    }
    
    /**
     * Método REST para eliminar un tipo de documento
     * @param id 
     */
    @DELETE
    @Path("{id_tipo_documento: \\d+}")
    public void deleteTipoDocumento(@PathParam("id_tipo_documento") int id){
        TipoDocumentoEntity tipoDocumento = tipoDocumentoLogic.getTipoDocumento(id);
        if (tipoDocumento == null) {
            throw new RuntimeException("El tipo de documento no existe");
        }
        tipoDocumentoLogic.deleteTipoDocumento(id);
    }
}//class
