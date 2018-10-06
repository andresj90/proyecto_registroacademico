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
import registro.registroacademico.dto.DocenteDTO;
import registro.registroacademico.entities.DocenteEntity;
import registro.registroacademico.logic.DocenteLogic;


/**
 * Servicio REST Docente
 * @author AndresJ90
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/docentes")
public class DocenteResource {
    
    @EJB
    private DocenteLogic docenteLogic; 
    
    /**
     * Método REST para obtener todos los docentes
     * @return 
     */
    
    @GET
    public List<DocenteDTO> getListaDocente(){
        List<DocenteEntity> docentes = docenteLogic.getDocentes(); 
        return DocenteDTO.tolistDocente(docentes);
    }
    
    /**
     * Método REST para obtener un docente a través del id
     * @param id
     * @return 
     */
    
    @GET 
    @Path("{id_docente: \\d+}")
    public DocenteDTO getDocente(@PathParam("id_docente") int id){
        DocenteEntity docente = docenteLogic.getDocente(id); 
        if (docente == null) {
            throw new RuntimeException("El Docente no existe");
        }
        
        return new DocenteDTO(docente);
    }
    
    /**
     * Método REST para crear un docente
     * @param docenteCrear 
     * @return 
     */
    
    @POST 
    public DocenteDTO createDocente(DocenteDTO docenteCrear){
        return new DocenteDTO(docenteLogic.createDocente(docenteCrear.toEntity()));
    }
    
    /**
     * Método REST para actualizar un docente
     * @param id
     * @param docenteActualizar 
     * @return 
     */
    
    @PUT 
    @Path("{id_docente: \\d+}")
    public DocenteDTO updateDocente(@PathParam("id_docente") int id,DocenteDTO docenteActualizar ){
        DocenteEntity entity = docenteLogic.getDocente(id);
        
        if (entity == null) {
            
            throw new RuntimeException("El Docente no existe");
        }
        
        return new DocenteDTO(docenteLogic.updateDocente(id, docenteActualizar.toEntity()));
    }
    
    /**
     * Método REST para eliminar un docente
     * @param id 
     */
    @DELETE
    @Path("{id_docente: \\d+}")
    public void deleteDocente(@PathParam("id_docente") int id){
        DocenteEntity docente = docenteLogic.getDocente(id);
        if (docente == null) {
            throw new RuntimeException("El Docente no existe");
        }
        docenteLogic.deleteDocente(id);
    }
}//class
