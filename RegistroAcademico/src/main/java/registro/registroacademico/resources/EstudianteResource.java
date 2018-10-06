/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import registro.registroacademico.dto.EstudianteDTO;
import registro.registroacademico.entities.EstudianteEntity;
import registro.registroacademico.logic.EstudianteLogic;


/**
 * Servicio REST Estudiante
 * @author AndresJ90
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/estudiantes")
public class EstudianteResource {
     @EJB
    private EstudianteLogic estudianteLogic; 
    
    /**
     * Método REST para obtener todos los coordinadores
     * @return 
     */
    
    @GET
    public List<EstudianteDTO> getListaEstudiante(){
        List<EstudianteEntity> estudiantes = estudianteLogic.getEstudiantes(); 
        return EstudianteDTO.tolistEstudiante(estudiantes);
    }
    
    /**
     * Método REST para obtener un coordinador a través del id
     * @param id
     * @return 
     */
    
    @GET 
    @Path("{id_estudiante: \\d+}")
    public EstudianteDTO getEstudiante(@PathParam("id_estudiante") int id){
        EstudianteEntity estudiante = estudianteLogic.getEstudiante(id); 
        if (estudiante == null) {
            throw new RuntimeException("El Estudiante no existe");
        }
        
        return new EstudianteDTO(estudiante);
    }
    
    /**
     * Método REST para crear un docente
     * @param estudianteCrear 
     * @return 
     */
    
    @POST 
    public EstudianteDTO createEstudiante(EstudianteDTO estudianteCrear){
        return new EstudianteDTO(estudianteLogic.createEstudiante(estudianteCrear.toEntity()));
    }
    
    /**
     * Método REST para actualizar un docente
     * @param id
     * @param estudianteActualizar 
     * @return 
     */
    
    @PUT 
    @Path("{id_estudiante: \\d+}")
    public EstudianteDTO updateEstudiante (@PathParam("id_estudiante") int id,EstudianteDTO estudianteActualizar ){
        EstudianteEntity entity = estudianteLogic.getEstudiante(id);
        
        if (entity == null) {
            
            throw new RuntimeException("El coordinador no existe");
        }
        
        return new EstudianteDTO(estudianteLogic.updateEstudiante(id, estudianteActualizar.toEntity()));
    }
    
    /**
     * Método REST para eliminar un estudiante
     * @param id 
     */
    @DELETE
    @Path("{id_estudiante: \\d+}")
    public void deleteEstudiante(@PathParam("id_estudiante") int id){
        EstudianteEntity estudiante = estudianteLogic.getEstudiante(id);
        if (estudiante == null) {
            throw new RuntimeException("El estudiante no existe");
        }
        estudianteLogic.deleteEstudiante(id);
    }
}
