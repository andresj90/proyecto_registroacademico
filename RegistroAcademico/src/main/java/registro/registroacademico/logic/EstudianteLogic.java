package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.EstudianteEntity;
import registro.registroacademico.persistence.EstudiantePersistence;

/**
 * Logica de negocio Estudiante
 * @author AndresJ90
 */
@Stateless
public class EstudianteLogic{
    
    @Inject 
    private EstudiantePersistence estudiantePersistence; 
    
    /**
     * Obtener todos los estudiantes
     * @return estudiantes 
     */
    public List<EstudianteEntity> getEstudiantes(){
      List<EstudianteEntity> estudiantes = estudiantePersistence.findAll();
      return estudiantes;
    }
    
    /**
     * Obtener un estudiante a través del id
     * @param id
     * @return 
     */
    
    public  EstudianteEntity getEstudiante(int id){
     EstudianteEntity estudiante = estudiantePersistence.find(id);
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante solicitado no existe");
        }
     return estudiante;
    }
    
    /**
     * Crear un nuevo estudiante
     * @param estudianteEntity 
     * @return 
     */
    
    public EstudianteEntity createEstudiante(EstudianteEntity estudianteEntity){
      estudiantePersistence.create(estudianteEntity); 
      return  estudianteEntity;
    }
    
    /**
     * Actualizar estudiante
     * @param id
     * @param estudianteEntity 
     * @return 
     */
    
    public EstudianteEntity updateEstudiante(int id, EstudianteEntity estudianteEntity){
     EstudianteEntity estudiante = estudiantePersistence.update(estudianteEntity); 
     return estudiante;
    }
    
    /**
     * metodo para eliminar estudiante de la tabla
     * @param id 
     */
    
    public void deleteEstudiante(int id){
        estudiantePersistence.remove(id);
    }
}//class
