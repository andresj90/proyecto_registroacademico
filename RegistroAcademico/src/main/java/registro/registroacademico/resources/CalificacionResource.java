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
import registro.registroacademico.dto.CalificacionDTO;
import registro.registroacademico.entities.CalificacionEntity;
import registro.registroacademico.logic.CalificacionLogic;


/**
 * SERVICIO REST para Calificacion
 * @author AndresJ90
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/calificaciones")
public class CalificacionResource {
   @EJB
    private CalificacionLogic calificacionLogic; 
    
    /**
     * Método REST para obtener todos los calificaciones
     * @return 
     */
    
    @GET
    public List<CalificacionDTO> getListaCalificacion(){
        List<CalificacionEntity> coordinadores = calificacionLogic.getCalificaciones(); 
        return CalificacionDTO.tolistCalificacion(coordinadores);
    }
    
    /**
     * Método REST para obtener una calificacion a través del id
     * @param id
     * @return 
     */
    
    @GET 
    @Path("{id_calificacion: \\d+}")
    public CalificacionDTO getCalificacion(@PathParam("id_calificacion") int id){
        CalificacionEntity coordinador = calificacionLogic.getCalificacion(id); 
        if (coordinador == null) {
            throw new RuntimeException("La calificacion no existe");
        }
        
        return new CalificacionDTO(coordinador);
    }
    
    /**
     * Método REST para crear una calificacion
     * @param calificacionCrear 
     * @return 
     */
    
    @POST 
    public CalificacionDTO createCalificacion(CalificacionDTO calificacionCrear){
        return new CalificacionDTO(calificacionLogic.createCalificacion(calificacionCrear.toEntity()));
    }
    
    /**
     * Método REST para actualizar una calificacion
     * @param id
     * @param calificacionActualizar 
     * @return 
     */
    
    @PUT 
    @Path("{id_calificacion: \\d+}")
    public CalificacionDTO updateCalificacion(@PathParam("id_calificacion") int id,CalificacionDTO calificacionActualizar ){
        CalificacionEntity entity = calificacionLogic.getCalificacion(id);
        
        if (entity == null) {
            
            throw new RuntimeException("La calificacion no existe");
        }
        
        return new CalificacionDTO(calificacionLogic.updateCalificacion(id, calificacionActualizar.toEntity()));
    }
    
    /**
     * Método REST para eliminar una calificacion
     * @param id 
     */
    @DELETE
    @Path("{id_calificacion: \\d+}")
    public void deleteCalificacion(@PathParam("id_calificacion") int id){
        CalificacionEntity coordinador = calificacionLogic.getCalificacion(id);
        if (coordinador == null) {
            throw new RuntimeException("La calificacion no existe");
        }
        calificacionLogic.deleteCalificacion(id);
    }  
    
}//class
