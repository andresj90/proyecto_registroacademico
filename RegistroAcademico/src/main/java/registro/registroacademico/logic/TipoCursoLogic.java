
package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.TipoCursoEntity;
import registro.registroacademico.persistence.TipoCursoPersistence;

/**
 * Logica de negocio TipoCurso
 * @author DavidC
 */

@Stateless
public class TipoCursoLogic {

    @Inject 
    private TipoCursoPersistence tipoCursoPersistence; 
    
    /**
     * Obtener todos los TipoCurso
     * @return TipoCurso; 
     */
    public List<TipoCursoEntity> getTipoCurso(){
      List<TipoCursoEntity> tipoCurso = tipoCursoPersistence.findAll();
      return tipoCurso;
    }
    
    /**
     * Obtener un TipoCurso a través del id
     * @param id
     * @return 
     */
    
    public  TipoCursoEntity getTipoCurso(Long id){
     TipoCursoEntity tipoCurso = tipoCursoPersistence.find(id);
     return tipoCurso;
    }
    
    /**
     * Crear un nuevo TipoCurso
     * @param tipoCursoEntity
     * @return 
     */
    
    public TipoCursoEntity crearTipoCurso (TipoCursoEntity tipoCursoEntity){
      tipoCursoPersistence.create(tipoCursoEntity); 
      return  tipoCursoEntity;
    }
    
    /**
     * Actualizar TipoCurso
     * @param id
     * @param tipoCursoEntity
     * @return 
     */
    
    public TipoCursoEntity updateTipoCurso(Long id, TipoCursoEntity tipoCursoEntity){
     TipoCursoEntity tipoCurso = tipoCursoPersistence.update(tipoCursoEntity); 
     return tipoCurso;
    }
    
    /**
     * metodo para eliminar TipoCurso de la tabla
     * @param id 
     */
    
    public void removeTipoCurso(Long id){
        tipoCursoPersistence.delete(id);
    }
}