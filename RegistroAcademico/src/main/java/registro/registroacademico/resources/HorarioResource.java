
package registro.registroacademico.resources;

import registro.registroacademico.dto.HorarioDTO;
import registro.registroacademico.entities.HorarioEntity;
import registro.registroacademico.logic.HorarioLogic;
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
 * Servicio REST Horario
 * @author DavidC.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/horario")
public class HorarioResource {
    
    @EJB
    private HorarioLogic horarioLogic;
    
    /**
     * Metodo REST para obtener todos los Horarios
     * @return lista horarioDTO
     */
    @GET
    public List<HorarioDTO> getListaHorario(){
        List<HorarioEntity> horario = horarioLogic.getHorario();
        return HorarioDTO.tolistHorario(horario);
    }
    
    /**
     * Servicio para obtener un Horario
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public HorarioDTO getHorario(@PathParam("id")Long id){
        HorarioEntity horario = horarioLogic.getHorario(id);
        if (horario == null){
            throw new RuntimeException("El horario NO existe");
        }
        return new HorarioDTO(horario);
    }
    
    @POST
    public HorarioDTO createHorario(HorarioDTO horarioCrear){
        return new HorarioDTO(horarioLogic.crearHorario(horarioCrear.toEntity()));
    }
    
    /**
     * Actualizar un horario
     * @param id
     * @param horarioActualizar
     * @return 
     */
    @PUT
    @Path("{id:\\d+}")
    public HorarioDTO updateHorario(@PathParam("id")Long id, HorarioDTO horarioActualizar){
        HorarioEntity entity = horarioLogic.getHorario(id);
        if(entity == null){
            throw new RuntimeException("El horario NO existe");
        }
        return new HorarioDTO(horarioLogic.updateHorario(id, horarioActualizar.toEntity()));
    }
    
    /**
     * Eliminar horario
     * @param id 
     */
    @DELETE
    @Path("{horarioId:\\d+}")
    public void deleteProducto(@PathParam("horarioId")Long id){
        HorarioEntity horario = horarioLogic.getHorario(id);
        if(horario == null){
            throw new RuntimeException("El horario NO exite");
        }
        horarioLogic.removerHorario(id);
    }
}

