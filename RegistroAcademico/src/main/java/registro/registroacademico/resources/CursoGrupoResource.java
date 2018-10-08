
package registro.registroacademico.resources;

import registro.registroacademico.dto.CursoGrupoDTO;
import registro.registroacademico.entities.CursoGrupoEntity;
import registro.registroacademico.logic.CursoGrupoLogic;
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
 * Servicio REST CursoGrupo
 * @author DavidC.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cursogrupos")
public class CursoGrupoResource {
    
    @EJB
    private CursoGrupoLogic cursoGrupoLogic;
    
    /**
     * Metodo REST para obtener todos los CursoGrupos
     * @return lista cursoCursoGrupoDTO
     */
    @GET
    public List<CursoGrupoDTO> getListaGrupo(){
        List<CursoGrupoEntity> cursoGrupo = cursoGrupoLogic.getCursoGrupo();
        return CursoGrupoDTO.tolistCursoGrupo(cursoGrupo);
    }
    
    /**
     * Servicio para obtener un CursoGrupo
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public CursoGrupoDTO getCursoGrupo(@PathParam("id")Long id){
        CursoGrupoEntity cursoGrupo = cursoGrupoLogic.getCursoGrupo(id);
        if (cursoGrupo == null){
            throw new RuntimeException("El CursoGrupo NO existe");
        }
        return new CursoGrupoDTO(cursoGrupo);
    }
    
    @POST
    public CursoGrupoDTO createCursoGrupo(CursoGrupoDTO cursoGrupoCrear){
        return new CursoGrupoDTO(cursoGrupoLogic.crearCursoGrupo(cursoGrupoCrear.toEntity()));
    }
    
    /**
     * Actualizar un CursoGrupo
     * @param id
     * @param CursoGrupoActualizar
     * @return 
     */
    @PUT
    @Path("{id:\\d+}")
    public CursoGrupoDTO updateGrupo(@PathParam("id")Long id, CursoGrupoDTO cursoGrupoActualizar){
        CursoGrupoEntity entity = cursoGrupoLogic.getCursoGrupo(id);
        if(entity == null){
            throw new RuntimeException("El CursoGrupo NO existe");
        }
        return new CursoGrupoDTO(cursoGrupoLogic.updateCursoGrupo(id, cursoGrupoActualizar.toEntity()));
    }
    
    /**
     * Eliminar CursoGrupo
     * @param id 
     */
    @DELETE
    @Path("{CursoGrupoId:\\d+}")
    public void deleteGrupo(@PathParam("CursoGrupoId")Long id){
        CursoGrupoEntity cursoGrupo = cursoGrupoLogic.getCursoGrupo(id);
        if(cursoGrupo == null){
            throw new RuntimeException("El CursoGrupo NO exite");
        }
        cursoGrupoLogic.removeCursoGrupo(id);
    }
}

