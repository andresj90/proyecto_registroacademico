
package registro.registroacademico.resources;

import registro.registroacademico.dto.TipoCursoDTO;
import registro.registroacademico.entities.TipoCursoEntity;
import registro.registroacademico.logic.TipoCursoLogic;
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
 * Servicio REST TipoCurso
 * @author DavidC.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tipocurso")
public class TipoCursoResource {
   
    @EJB
    private TipoCursoLogic tipoCursoLogic;
    
    /**
     * Metodo REST para obtener todos los TipoCursos
     * @return lista tipoCursoDTO
     */
    @GET
    public List<TipoCursoDTO> getListaTipoCurso(){
        List<TipoCursoEntity> tipoCurso = tipoCursoLogic.getTipoCurso();
        return TipoCursoDTO.tolistTipoCurso(tipoCurso);
    }
    
    /**
     * Servicio para obtener un TipoCurso
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public TipoCursoDTO getTipoCurso(@PathParam("id")Long id){
        TipoCursoEntity tipoCurso = tipoCursoLogic.getTipoCurso(id);
        if (tipoCurso == null){
            throw new RuntimeException("El TipoCurso NO existe");
        }
        return new TipoCursoDTO(tipoCurso);
    }
    
    @POST
    public TipoCursoDTO createTipoCurso(TipoCursoDTO TipoCursoCrear){
        return new TipoCursoDTO(tipoCursoLogic.crearTipoCurso(TipoCursoCrear.toEntity()));
    }
    
    /**
     * Actualizar un TipoCurso
     * @param id
     * @param TipoCursoActualizar
     * @return 
     */
    @PUT
    @Path("{id:\\d+}")
    public TipoCursoDTO updateTipoCurso(@PathParam("id")Long id, TipoCursoDTO tipoCursoActualizar){
        TipoCursoEntity entity = tipoCursoLogic.getTipoCurso(id);
        if(entity == null){
            throw new RuntimeException("El TipoCurso NO existe");
        }
        return new TipoCursoDTO(tipoCursoLogic.updateTipoCurso(id, tipoCursoActualizar.toEntity()));
    }
    
    /**
     * Eliminar TipoCurso
     * @param id 
     */
    @DELETE
    @Path("{TipoCursoId:\\d+}")
    public void deleteGrupo(@PathParam("TipoCursoId")Long id){
        TipoCursoEntity tipoCurso = tipoCursoLogic.getTipoCurso(id);
        if(tipoCurso == null){
            throw new RuntimeException("El TipoCurso NO exite");
        }
        tipoCursoLogic.removeTipoCurso(id);
    }
}

