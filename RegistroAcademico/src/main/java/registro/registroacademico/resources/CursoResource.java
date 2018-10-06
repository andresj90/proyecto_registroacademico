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
import registro.registroacademico.dto.CursoDTO;
import registro.registroacademico.entities.CursoEntity;
import registro.registroacademico.logic.CursoLogic;



/**
 * Servicio REST curso
 * @author Uriel Rodríguez Vallarta
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/curso")
public class CursoResource {
    
    @EJB
    private CursoLogic cursoLogic; 
    
    /**
     * Método REST para obtener todos los cursos
     * @return 
     */
    
    @GET
    public List<CursoDTO> getListaCurso(){
        List<CursoEntity> cursos = cursoLogic.getCursos(); 
        return CursoDTO.tolistCurso(cursos);
    }
    
    /**
     * Método REST para obtener un curso a través del id
     * @param id
     * @return 
     */
    
    @GET 
    @Path("{id_curso: \\d+}")
    public CursoDTO getCurso(@PathParam("id_curso") int id){
        CursoEntity curso = cursoLogic.getCurso(id); 
        if (curso == null) {
            throw new RuntimeException("El curso no existe");
        }
        
        return new CursoDTO(curso);
    }
    
    /**
     * Método REST para crear un curso
     * @param cursoCrear
     * @return 
     */
    
    @POST 
    public CursoDTO createCurso(CursoDTO cursoCrear){
        return new CursoDTO(cursoLogic.createCurso(cursoCrear.toEntity()));
    }
    
    /**
     * Método REST para actualizar un curso
     * @param id
     * @param cursoActualizar
     * @return 
     */
    
    @PUT 
    @Path("{id_curso: \\d+}")
    public CursoDTO updateCurso (@PathParam("id_curso") int id,CursoDTO cursoActualizar ){
        CursoEntity entity = cursoLogic.getCurso(id);
        
        if (entity == null) {
            
            throw new RuntimeException("El curso no existe");
        }
        
        return new CursoDTO(cursoLogic.updateCurso(id, cursoActualizar.toEntity()));
    }
    
    /**
     * Método REST para eliminar un curso
     * @param id 
     */
    @DELETE
    @Path("{id_curso: \\d+}")
    public void deleteCurso(@PathParam("id_curso") int id){
        CursoEntity curso = cursoLogic.getCurso(id);
        if (curso == null) {
            throw new RuntimeException("El curso no existe");
        }
        cursoLogic.deleteCurso(id);
    }
}//class
