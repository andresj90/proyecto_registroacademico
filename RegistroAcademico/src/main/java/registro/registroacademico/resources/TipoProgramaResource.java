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
import registro.registroacademico.dto.TipoProgramaDTO;
import registro.registroacademico.entities.TipoProgramaEntity;
import registro.registroacademico.logic.TipoProgramaLogic;



/**
 * Servicio REST Programa
 * @author Uriel Rodríguez Vallarta
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tipoProgramas")
public class TipoProgramaResource {
    
    @EJB
    private TipoProgramaLogic tipoProgramaLogic; 
    
    /**
     * Método REST para obtener todos los programas
     * @return 
     */
    
    @GET
    public List<TipoProgramaDTO> getListaTipoPrograma(){
        List<TipoProgramaEntity> tipoProgramas = tipoProgramaLogic.getTipoProgramas(); 
        return TipoProgramaDTO.tolistTipoPrograma(tipoProgramas);
    }
    
    /**
     * Método REST para obtener un tipo Programa a través del id
     * @param id
     * @return 
     */
    
    @GET 
    @Path("{id_tipo_programa: \\d+}")
    public TipoProgramaDTO getTipoPrograma(@PathParam("id_tipo_programa") int id){
        TipoProgramaEntity tipoPrograma = tipoProgramaLogic.getTipoPrograma(id); 
        if (tipoPrograma == null) {
            throw new RuntimeException("El tipo programa no existe");
        }
        
        return new TipoProgramaDTO(tipoPrograma);
    }
    
    /**
     * Método REST para crear un tipo programa
     * @param tipoProgramaCrear
     * @return 
     */
    
    @POST 
    public TipoProgramaDTO createTipoPrograma(TipoProgramaDTO tipoProgramaCrear){
        return new TipoProgramaDTO(tipoProgramaLogic.createTipoPrograma(tipoProgramaCrear.toEntity()));
    }
    
    /**
     * Método REST para actualizar un tipo programa
     * @param id
     * @param tipoProgramaActualizar
     * @return 
     */
    
    @PUT 
    @Path("{id_tipo_programa: \\d+}")
    public TipoProgramaDTO updateTipoPrograma (@PathParam("id_tipo_programa") int id,TipoProgramaDTO tipoProgramaActualizar ){
        TipoProgramaEntity entity = tipoProgramaLogic.getTipoPrograma(id);
        
        if (entity == null) {
            
            throw new RuntimeException("El tipo Programa no existe");
        }
        
        return new TipoProgramaDTO(tipoProgramaLogic.updateTipoPrograma(id, tipoProgramaActualizar.toEntity()));
    }
    
    /**
     * Método REST para eliminar un tipo programa
     * @param id 
     */
    @DELETE
    @Path("{id_tipo_programa: \\d+}")
    public void deleteTipoPrograma(@PathParam("id_tipo_programa") int id){
        TipoProgramaEntity tipoPrograma = tipoProgramaLogic.getTipoPrograma(id);
        if (tipoPrograma == null) {
            throw new RuntimeException("El tipo Programa no existe");
        }
        tipoProgramaLogic.deleteTipoPrograma(id);
    }
}//class
