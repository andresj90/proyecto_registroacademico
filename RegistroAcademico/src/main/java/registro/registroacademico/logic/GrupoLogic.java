
package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.GrupoEntity;
import registro.registroacademico.persistence.GrupoPersistence;

/**
 * Logica de negocio Grupo
 * @author DavidC
 */

@Stateless
public class GrupoLogic {
    
    @Inject 
    private GrupoPersistence grupoPersistence; 
    
    /**
     * Obtener todos los Grupo
     * @return Grupo; 
     */
    public List<GrupoEntity> getGrupo(){
      List<GrupoEntity> grupo = grupoPersistence.findAll();
      return grupo;
    }
    
    /**
     * Obtener un Grupo a través del id
     * @param id
     * @return 
     */
    
    public  GrupoEntity getGrupo(Long id){
     GrupoEntity grupo = grupoPersistence.find(id);
     return grupo;
    }
    
    /**
     * Crear un nuevo Grupo
     * @param grupoEntity
     * @return 
     */
    
    public GrupoEntity crearGrupo(GrupoEntity grupoEntity){
      grupoPersistence.create(grupoEntity); 
      return  grupoEntity;
    }
    
    /**
     * Actualizar Grupo
     * @param id
     * @param grupoEntity
     * @return 
     */
    
    public GrupoEntity updateGrupo(int id, GrupoEntity grupoEntity){
     GrupoEntity grupo = grupoPersistence.update(grupoEntity); 
     return grupo;
    }
    
    /**
     * metodo para eliminar Grupo de la tabla
     * @param id 
     */
    
    public void removeGrupo(Long id){
        grupoPersistence.delete(id);
    }
}