package registro.registroacademico.resources;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import registro.registroacademico.dto.CoordinadorDTO;
import registro.registroacademico.entities.CoordinadorEntity;
import registro.registroacademico.logic.CoordinadorLogic;



/**
 * Servicio REST Coordinador
 * @author AndresJ90
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/coordinadores")
public class CoordinadorResource {
    
    @EJB
    private CoordinadorLogic coordinadorLogic; 
    
    /**
     * Método REST para obtener todos los coordinadores
     * @return 
     */
    
    @GET
    public List<CoordinadorDTO> getListaCoordinador(){
        List<CoordinadorEntity> coordinadores = coordinadorLogic.getCoordinadores(); 
        return CoordinadorDTO.tolistCoordinador(coordinadores);
    }
    
    /**
     * Método REST para obtener un coordinador a través del id
     * @param id
     * @return 
     */
    
    @GET 
    @Path("{id_coodinador: \\d+}")
    public CoordinadorDTO getCoordinador(@PathParam("id_coordinador") int id){
        CoordinadorEntity coordinador = coordinadorLogic.getCoordinador(id); 
        if (coordinador == null) {
            throw new RuntimeException("El coordinador no existe");
        }
        
        return new CoordinadorDTO(coordinador);
    }
    
    /**
     * Método REST para crear un coordinador
     * @param coordinadorCrear
     * @return 
     */
    
    @POST 
    public CoordinadorDTO createCoordinador(CoordinadorDTO coordinadorCrear){
        return new CoordinadorDTO(coordinadorLogic.createCoordinador(coordinadorCrear.toEntity()));
    }
    
    /**
     * Método REST para actualizar un coordinador
     * @param id
     * @param coordinadoractualizar
     * @return 
     */
    
    @PUT 
    @Path("{id_coodinador: \\d+}")
    public CoordinadorDTO updateCoordinador (@PathParam("id_coordinador") int id,CoordinadorDTO coordinadoractualizar ){
        CoordinadorEntity entity = coordinadorLogic.getCoordinador(id);
        
        if (entity == null) {
            
            throw new RuntimeException("El coordinador no existe");
        }
        
        return new CoordinadorDTO(coordinadorLogic.updateCoordinador(id, coordinadoractualizar.toEntity()));
    }
    
    /**
     * Método REST para eliminar un coordinador
     * @param id 
     */
    @DELETE
    @Path("{id_coodinador: \\d+}")
    public void deleteCoordinador(@PathParam("id_coordinador") int id){
        CoordinadorEntity coordinador = coordinadorLogic.getCoordinador(id);
        if (coordinador == null) {
            throw new RuntimeException("El coordinador no existe");
        }
        coordinadorLogic.deleteCoordinador(id);
    }
}//class
