
package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.HorarioGrupoCursoEntity;
import registro.registroacademico.persistence.HorarioGrupoCursoPersistence;

/**
 * Logica de negocio HorarioGrupoCurso
 * @author DavidC
 */

@Stateless
public class HorarioGrupoCursoLogic {
    
    @Inject 
    private HorarioGrupoCursoPersistence horarioGrupoCursoPersistence; 
    
    /**
     * Obtener todos los HorariosGrupoCurso
     * @return HorariosGrupoCurso; 
     */
    public List<HorarioGrupoCursoEntity> getHorarioGrupoCursos(){
      List<HorarioGrupoCursoEntity> horarioGrupoCurso = horarioGrupoCursoPersistence.findAll();
      return horarioGrupoCurso;
    }
    
    /**
     * Obtener un HorarioGrupoCurso a través del id
     * @param id
     * @return 
     */
    
    public  HorarioGrupoCursoEntity getHorarioGrupoCurso(Long id){
     HorarioGrupoCursoEntity horarioGrupoCurso = horarioGrupoCursoPersistence.find(id);
     return horarioGrupoCurso;
    }
    
    /**
     * Crear un nuevo HorarioGrupoCurso
     * @param horarioGrupoCursoEntity
     * @return 
     */
    
    public HorarioGrupoCursoEntity crearHorarioGrupoCurso(HorarioGrupoCursoEntity horarioGrupoCursoEntity){
      horarioGrupoCursoPersistence.create(horarioGrupoCursoEntity); 
      return  horarioGrupoCursoEntity;
    }
    
    /**
     * Actualizar HorarioGrupoCurso
     * @param id
     * @param horarioGrupoCursoEntity
     * @return 
     */
    
    public HorarioGrupoCursoEntity updateHorarioGrupoCurso(Long id, HorarioGrupoCursoEntity horarioGrupoCursoEntity){
     HorarioGrupoCursoEntity horarioGrupoCurso = horarioGrupoCursoPersistence.update(horarioGrupoCursoEntity); 
     return horarioGrupoCurso;
    }
    
    /**
     * metodo para eliminar HorarioGrupoCurso de la tabla
     * @param id 
     */
    
    public void removeHorarioGrupoCurso(Long id){
        horarioGrupoCursoPersistence.delete(id);
    }
}//class
