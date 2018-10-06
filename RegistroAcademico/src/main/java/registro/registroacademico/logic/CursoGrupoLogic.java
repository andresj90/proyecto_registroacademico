
package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.CursoGrupoEntity;
import registro.registroacademico.persistence.CursoGrupoPersistence;

/**
 * Logica de negocio CursoGrupo
 * @author DavidC
 */

@Stateless
public class CursoGrupoLogic {
    
    @Inject 
    private CursoGrupoPersistence cursoGrupoPersistence; 
    
    /**
     * Obtener todos los CursoGrupo
     * @return CursoGrupo; 
     */
    public List<CursoGrupoEntity> getCursoGrupo(){
      List<CursoGrupoEntity> cursoGrupo = cursoGrupoPersistence.findAll();
      return cursoGrupo;
    }
    
    /**
     * Obtener un CursoGrupo a través del id
     * @param id
     * @return 
     */
    
    public  CursoGrupoEntity getCursoGrupo(Long id){
     CursoGrupoEntity cursoGrupo = cursoGrupoPersistence.find(id);
     return cursoGrupo;
    }
    
    /**
     * Crear un nuevo CursoGrupo
     * @param cursoGrupoEntity
     * @return 
     */
    
    public CursoGrupoEntity crearCursoGrupo (CursoGrupoEntity cursoGrupoEntity){
      cursoGrupoPersistence.create(cursoGrupoEntity); 
      return  cursoGrupoEntity;
    }
    
    /**
     * Actualizar CursoGrupo
     * @param id
     * @param cursoGrupoEntity
     * @return 
     */
    
    public CursoGrupoEntity updateCursoGrupo(int id, CursoGrupoEntity cursoGrupoEntity){
     CursoGrupoEntity cursoGrupo = cursoGrupoPersistence.update(cursoGrupoEntity); 
     return cursoGrupo;
    }
    
    /**
     * metodo para eliminar CursoGrupo de la tabla
     * @param id 
     */
    
    public void removeCursoGrupo(Long id){
        cursoGrupoPersistence.delete(id);
    }
}
