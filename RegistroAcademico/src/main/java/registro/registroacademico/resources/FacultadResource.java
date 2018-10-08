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
import registro.registroacademico.dto.FacultadDTO;
import registro.registroacademico.entities.FacultadEntity;
import registro.registroacademico.logic.FacultadLogic;



/**
 * Servicio REST facultad
 * @author Uriel Rodríguez Vallarta
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/facultades")
public class FacultadResource {
    
    @EJB
    private FacultadLogic facultadLogic; 
    
    /**
     * Método REST para obtener todos las facultades
     * @return 
     */
    
    @GET
    public List<FacultadDTO> getListaFacultades(){
        List<FacultadEntity> facultades = facultadLogic.getFacultades(); 
        return FacultadDTO.tolistFacultad(facultades);
    }
    
    /**
     * Método REST para obtener una facultad a través del id
     * @param id
     * @return 
     */
    
    @GET 
    @Path("{id_facultad: \\d+}")
    public FacultadDTO getFacultad(@PathParam("id_facultad") int id){
        FacultadEntity facultad = facultadLogic.getFacultad(id); 
        if (facultad == null) {
            throw new RuntimeException("La facultad no existe");
        }
        
        return new FacultadDTO(facultad);
    }
    
    /**
     * Método REST para crear una facultad
     * @param facultadCrear
     * @return 
     */
    
    @POST 
    public FacultadDTO createFacultad(FacultadDTO facultadCrear){
        return new FacultadDTO(facultadLogic.createFacultad(facultadCrear.toEntity()));
    }
    
    /**
     * Método REST para actualizar una facultad
     * @param id
     * @param facultadActualizar
     * @return 
     */
    
    @PUT 
    @Path("{id_facultad: \\d+}")
    public FacultadDTO updateFacultad (@PathParam("id_facultad") int id,FacultadDTO facultadActualizar ){
        FacultadEntity entity = facultadLogic.getFacultad(id);
        
        if (entity == null) {
            
            throw new RuntimeException("La facultad no existe");
        }
        
        return new FacultadDTO(facultadLogic.updateFacultad(id, facultadActualizar.toEntity()));
    }
    
    /**
     * Método REST para eliminar una facultad
     * @param id 
     */
    @DELETE
    @Path("{id_facultad: \\d+}")
    public void deleteFacultad(@PathParam("id_facultad") int id){
        FacultadEntity facultad = facultadLogic.getFacultad(id);
        if (facultad == null) {
            throw new RuntimeException("La facultad no existe");
        }
        facultadLogic.deleteFacultad(id);
    }
}//class
