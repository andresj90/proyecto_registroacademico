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
import registro.registroacademico.dto.InscripcionDTO;
import registro.registroacademico.entities.InscripcionEntity;
import registro.registroacademico.logic.InscripcionLogic;


/**
 * Servicio REST Inscripcion
 * @author AndresJ90
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/inscripciones")
public class InscripcionResource {
    
    @EJB
    private InscripcionLogic inscripcionLogic; 
    
    /**
     * Método REST para obtener todas las inscripciones
     * @return 
     */
    
    @GET
    public List<InscripcionDTO> getListaInscripcion(){
        List<InscripcionEntity> inscripciones = inscripcionLogic.getInscripciones(); 
        return InscripcionDTO.tolistInscripcion(inscripciones);
    }
    
    /**
     * Método REST para obtener una inscripcion a través del id
     * @param id
     * @return 
     */
    
    @GET 
    @Path("{id_inscripcion: \\d+}")
    public InscripcionDTO getInscripcion(@PathParam("id_inscripcion") int id){
        InscripcionEntity inscripcion = inscripcionLogic.getInscripcion(id); 
        if (inscripcion == null) {
            throw new RuntimeException("La inscripcion no existe");
        }
        
        return new InscripcionDTO(inscripcion);
    }
    
    /**
     * Método REST para crear una inscripcion
     * @param inscripcionCrear 
     * @return 
     */
    
    @POST 
    public InscripcionDTO createInscripcion(InscripcionDTO inscripcionCrear){
        return new InscripcionDTO(inscripcionLogic.createInscripcion(inscripcionCrear.toEntity()));
    }
    
    /**
     * Método REST para actualizar una inscripcion
     * @param id
     * @param inscripcionActualizar 
     * @return 
     */
    
    @PUT 
    @Path("{id_inscripcion: \\d+}")
    public InscripcionDTO updateInscripcion(@PathParam("id_inscripcion") int id,InscripcionDTO inscripcionActualizar ){
        InscripcionEntity entity = inscripcionLogic.getInscripcion(id);
        
        if (entity == null) {
            
            throw new RuntimeException("La inscripcion no existe");
        }
        
        return new InscripcionDTO(inscripcionLogic.updateInscripcion(id, inscripcionActualizar.toEntity()));
    }
    
    /**
     * Método REST para eliminar una inscripcion
     * @param id 
     */
    @DELETE
    @Path("{id_inscripcion: \\d+}")
    public void deleteInscripcion(@PathParam("id_inscripcion") int id){
        InscripcionEntity inscripcion = inscripcionLogic.getInscripcion(id);
        if (inscripcion == null) {
            throw new RuntimeException("La inscripcion no existe");
        }
        inscripcionLogic.deleteInscripcion(id);
    }
}//class
