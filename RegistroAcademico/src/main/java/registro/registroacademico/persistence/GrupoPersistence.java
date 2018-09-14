
package registro.registroacademico.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import registro.registroacademico.entities.GrupoEntity;

/**
 * Manejador de la entidad Grupo
 *
 * @author David Cañon
 */
@Stateless
public class GrupoPersistence {
    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla Grupo
     *
     * @return Lista de datos de la tabla Grupo
     */
    public List<GrupoEntity> findAll() {
        Query todos = em.createQuery("select e from GrupoEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla grupo
     *
     * @param id que se desea buscar
     * @return grupo
     */
    public GrupoEntity find(Long id) {
        GrupoEntity grupo = em.find(GrupoEntity.class, id);
        return grupo;
    }

    /**
     * Creacion de un nuevo grupo
     *
     * @param grupo
     * @return nuevo grupo creado
     */
    public GrupoEntity create(GrupoEntity grupo) {
        em.persist(grupo);
        return grupo;
    }

    /**
     * Actualizacion de una tupla de la tabla grupo
     *
     * @param grupoActualizar
     * @return grupo actualizado
     */
    public GrupoEntity update(GrupoEntity grupoActualizar) {
        return em.merge(grupoActualizar);
    }

    /**
     * Elimina una tupla grupo de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        GrupoEntity grupoDelete = em.find(GrupoEntity.class, id);
        em.remove(grupoDelete);
    }
}
