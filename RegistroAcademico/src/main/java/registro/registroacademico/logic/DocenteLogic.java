package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.DocenteEntity;
import registro.registroacademico.persistence.DocentePersistence;


/**
 *Logica de negocio Docente
 * @author AndresJ90
 */
@Stateless
public class DocenteLogic {
    
    @Inject 
    private DocentePersistence docentePersistence; 
    
    /**
     * Obtener todos los docentes
     * @return docentes 
     */
    public List<DocenteEntity> getDocentes(){
      List<DocenteEntity> docentes = docentePersistence.findAll();
      return docentes;
    }
    
    /**
     * Obtener un docente a través del id
     * @param id
     * @return 
     */
    
    public  DocenteEntity getDocente(int id){
     DocenteEntity docente = docentePersistence.find(id);
        if (docente == null) {
            throw new IllegalArgumentException("El docente solicitado no existe");
        }
     return docente;
    }
    
    /**
     * Crear un nuevo docente
     * @param docenteEntity 
     * @return 
     */
    
    public DocenteEntity createDocente(DocenteEntity docenteEntity){
      docentePersistence.create(docenteEntity); 
      return  docenteEntity;
    }
    
    /**
     * Actualizar docente
     * @param id
     * @param docenteEntity 
     * @return 
     */
    
    public DocenteEntity updateDocente(int id, DocenteEntity docenteEntity){
     DocenteEntity docente = docentePersistence.update(docenteEntity); 
     return docente;
    }
    
    /**
     * metodo para eliminar el docente de la tabla
     * @param id 
     */
    
    public void deleteDocente(int id){
        docentePersistence.remove(id);
    }
}
