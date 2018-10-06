
package registro.registroacademico.resources;

import registro.registroacademico.dto.HorarioGrupoCursoDTO;
import registro.registroacademico.entities.HorarioGrupoCursoEntity;
import registro.registroacademico.logic.HorarioGrupoCursoLogic;
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
 * Servicio REST HorarioGrupoCurso
 * @author DavidC.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/horariogrupocurso")
public class HorarioGrupoCursoResource {
    
    @EJB
    private HorarioGrupoCursoLogic horarioGrupoCursoLogic;
    
    /**
     * Metodo REST para obtener todos los HorarioGrupoCurso
     * @return lista horarioGrupoCursoDTO
     */
    @GET
    public List<HorarioGrupoCursoDTO> getListaHorarioGrupoCurso(){
        List<HorarioGrupoCursoEntity> horarioGrupoCurso = horarioGrupoCursoLogic.getHorarioGrupoCursos();
        return HorarioGrupoCursoDTO.tolisthorarioGrupoCurso(horarioGrupoCurso);
    }
    
    /**
     * Servicio para obtener un HorarioGrupoCurso
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public HorarioGrupoCursoDTO getHorarioGrupoCurso(@PathParam("id")Long id){
        HorarioGrupoCursoEntity horarioGrupoCurso = horarioGrupoCursoLogic.getHorarioGrupoCurso(id);
        if (horarioGrupoCurso == null){
            throw new RuntimeException("El horarioGrupoCurso NO existe");
        }
        return new HorarioGrupoCursoDTO(horarioGrupoCurso);
    }
    
    @POST
    public HorarioGrupoCursoDTO createHorarioGrupoCurso(HorarioGrupoCursoDTO HorarioGrupoCursoCrear){
        return new HorarioGrupoCursoDTO(horarioGrupoCursoLogic.crearHorarioGrupoCurso(HorarioGrupoCursoCrear.toEntity()));
    }
    
    /**
     * Actualizar un HorarioGrupoCurso
     * @param id
     * @param HorarioGrupoCursoActualizar
     * @return 
     */
    @PUT
    @Path("{id:\\d+}")
    public HorarioGrupoCursoDTO updateHorarioGrupoCurso(@PathParam("id")Long id, HorarioGrupoCursoDTO horarioActualizar){
        HorarioGrupoCursoEntity entity = horarioGrupoCursoLogic.getHorarioGrupoCurso(id);
        if(entity == null){
            throw new RuntimeException("El HorarioGrupoCurso NO existe");
        }
        return new HorarioGrupoCursoDTO(horarioGrupoCursoLogic.updateHorarioGrupoCurso(id, horarioActualizar.toEntity()));
    }
    
    /**
     * Eliminar HorarioGrupoCurso
     * @param id 
     */
    @DELETE
    @Path("{HorarioGrupoCursoId:\\d+}")
    public void deleteProducto(@PathParam("HorarioGrupoCursoId")Long id){
        HorarioGrupoCursoEntity horarioGrupoCurso = horarioGrupoCursoLogic.getHorarioGrupoCurso(id);
        if(horarioGrupoCurso == null){
            throw new RuntimeException("El horarioGrupoCurso NO exite");
        }
        horarioGrupoCursoLogic.removeHorarioGrupoCurso(id);
    }
}

