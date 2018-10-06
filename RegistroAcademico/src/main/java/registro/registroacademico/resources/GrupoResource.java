
package registro.registroacademico.resources;

import registro.registroacademico.dto.GrupoDTO;
import registro.registroacademico.entities.GrupoEntity;
import registro.registroacademico.logic.GrupoLogic;
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

/**
 * Servicio REST Grupo
 * @author DavidC.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/grupo")
public class GrupoResource {
    
    @EJB
    private GrupoLogic grupoLogic;
    
    /**
     * Metodo REST para obtener todos los Grupos
     * @return lista grupoDTO
     */
    @GET
    public List<GrupoDTO> getListaGrupo(){
        List<GrupoEntity> grupo = grupoLogic.getGrupo();
        return GrupoDTO.tolistGrupo(grupo);
    }
    
    /**
     * Servicio para obtener un Grupo
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public GrupoDTO getGrupo(@PathParam("id")Long id){
        GrupoEntity grupo = grupoLogic.getGrupo(id);
        if (grupo == null){
            throw new RuntimeException("El Grupo NO existe");
        }
        return new GrupoDTO(grupo);
    }
    
    @POST
    public GrupoDTO createGrupo(GrupoDTO grupoCrear){
        return new GrupoDTO(grupoLogic.crearGrupo(grupoCrear.toEntity()));
    }
    
    /**
     * Actualizar un Grupo
     * @param id
     * @param GrupoActualizar
     * @return 
     */
    @PUT
    @Path("{id:\\d+}")
    public GrupoDTO updateGrupo(@PathParam("id")Long id, GrupoDTO grupoActualizar){
        GrupoEntity entity = grupoLogic.getGrupo(id);
        if(entity == null){
            throw new RuntimeException("El Grupo NO existe");
        }
        return new GrupoDTO(grupoLogic.updateGrupo(id, grupoActualizar.toEntity()));
    }
    
    /**
     * Eliminar Grupo
     * @param id 
     */
    @DELETE
    @Path("{GrupoId:\\d+}")
    public void deleteGrupo(@PathParam("GrupoId")Long id){
        GrupoEntity grupo = grupoLogic.getGrupo(id);
        if(grupo == null){
            throw new RuntimeException("El Grupo NO exite");
        }
        grupoLogic.removeGrupo(id);
    }
}

