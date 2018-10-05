/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.InscripcionEntity;
import registro.registroacademico.persistence.InscripcionPersistence;


/**
 * Logica de negocio Inscripcion
 * @author AndresJ90
 */
@Stateless
public class InscripcionLogic {
    @Inject 
    private InscripcionPersistence inscripcionPersistence; 
    
    /**
     * Obtener todos las inscripciones
     * @return inscripciones 
     */
    public List<InscripcionEntity> getInscripciones(){
      List<InscripcionEntity> inscripciones = inscripcionPersistence.findAll();
      return inscripciones;
    }
    
    /**
     * Obtener una inscripcion a través del id
     * @param id
     * @return 
     */
    
    public  InscripcionEntity getInscripcion(int id){
     InscripcionEntity inscripcion = inscripcionPersistence.find(id);
        if (inscripcion == null) {
            throw new IllegalArgumentException("La inscripcion solicitada no existe");
        }
     return inscripcion;
    }
    
    /**
     * Crear una nueva inscripcion
     * @param inscripcionEntity 
     * @return 
     */
    
    public InscripcionEntity createInscripcion(InscripcionEntity inscripcionEntity){
      inscripcionPersistence.create(inscripcionEntity); 
      return  inscripcionEntity;
    }
    
    /**
     * Actualizar inscripcion
     * @param id
     * @param inscripcionEntity 
     * @return 
     */
    
    public InscripcionEntity updateInscripcion(int id, InscripcionEntity inscripcionEntity){
     InscripcionEntity inscripcion = inscripcionPersistence.update(inscripcionEntity); 
     return inscripcion;
    }
    
    /**
     * metodo para eliminar una inscripcion de la tabla
     * @param id 
     */
    
    public void deleteInscripcion(int id){
        inscripcionPersistence.remove(id);
    }
}
