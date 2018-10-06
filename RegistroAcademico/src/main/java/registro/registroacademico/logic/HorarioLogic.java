
package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.HorarioEntity;
import registro.registroacademico.persistence.HorarioPersistence;

/**
 * Logica de negocio Horario
 * @author DavidC
 */

@Stateless
public class HorarioLogic {
    
    @Inject 
    private HorarioPersistence horarioPersistence; 
    
    /**
     * Obtener todos los horarios
     * @return horario; 
     */
    public List<HorarioEntity> getHorario(){
      List<HorarioEntity> horario = horarioPersistence.findAll();
      return horario;
    }
    
    /**
     * Obtener un horario a través del id
     * @param id
     * @return 
     */
    
    public  HorarioEntity getHorario(Long id){
     HorarioEntity horario = horarioPersistence.find(id);
     return horario;
    }
    
    /**
     * Crear un nuevo horario
     * @param horarioEntity
     * @return 
     */
    
    public HorarioEntity crearHorario(HorarioEntity horarioEntity){
      horarioPersistence.create(horarioEntity); 
      return  horarioEntity;
    }
    
    /**
     * Actualizar horario
     * @param id
     * @param horarioEntity
     * @return 
     */
    
    public HorarioEntity updateHorario(int id, HorarioEntity horarioEntity){
     HorarioEntity horario = horarioPersistence.update(horarioEntity); 
     return horario;
    }
    
    /**
     * metodo para eliminar horario de la tabla
     * @param id 
     */
    
    public void removeHorario(Long id){
        horarioPersistence.delete(id);
    }
}
