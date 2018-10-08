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
import registro.registroacademico.dto.ProgramaDTO;
import registro.registroacademico.entities.ProgramaEntity;
import registro.registroacademico.logic.ProgramaLogic;



/**
 * Servicio REST Programa
 * @author Uriel Rodríguez Vallarta
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/programas")
public class ProgramaResource {
    
    @EJB
    private ProgramaLogic programaLogic; 
    
    /**
     * Método REST para obtener todos los programas
     * @return 
     */
    
    @GET
    public List<ProgramaDTO> getListaPrograma(){
        List<ProgramaEntity> programas = programaLogic.getProgramas(); 
        return ProgramaDTO.tolistPrograma(programas);
    }
    
    /**
     * Método REST para obtener un Programa a través del id
     * @param id
     * @return 
     */
    
    @GET 
    @Path("{id_programa: \\d+}")
    public ProgramaDTO getPrograma(@PathParam("id_programa") int id){
        ProgramaEntity programa = programaLogic.getPrograma(id); 
        if (programa == null) {
            throw new RuntimeException("El programa no existe");
        }
        
        return new ProgramaDTO(programa);
    }
    
    /**
     * Método REST para crear un programa
     * @param programaCrear
     * @return 
     */
    
    @POST 
    public ProgramaDTO createPrograma(ProgramaDTO programaCrear){
        return new ProgramaDTO(programaLogic.createPrograma(programaCrear.toEntity()));
    }
    
    /**
     * Método REST para actualizar un programa
     * @param id
     * @param programaActualizar
     * @return 
     */
    
    @PUT 
    @Path("{id_programa: \\d+}")
    public ProgramaDTO updatePrograma (@PathParam("id_programa") int id,ProgramaDTO programaActualizar ){
        ProgramaEntity entity = programaLogic.getPrograma(id);
        
        if (entity == null) {
            
            throw new RuntimeException("El Programa no existe");
        }
        
        return new ProgramaDTO(programaLogic.updatePrograma(id, programaActualizar.toEntity()));
    }
    
    /**
     * Método REST para eliminar un programa
     * @param id 
     */
    @DELETE
    @Path("{id_programa: \\d+}")
    public void deletePrograma(@PathParam("id_programa") int id){
        ProgramaEntity programa = programaLogic.getPrograma(id);
        if (programa == null) {
            throw new RuntimeException("El programa no existe");
        }
        programaLogic.deletePrograma(id);
    }
}//class
