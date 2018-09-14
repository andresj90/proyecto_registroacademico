
package registro.registroacademico.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import registro.registroacademico.entities.CursoGrupoEntity;

/**
 *Manejador de la entidad CursoGrupo
 * @author David Cañon
 */
@Stateless
public class CursoGrupoPersistence {
    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla CursoGrupo
     *
     * @return Lista de datos de la tabla CursoGrupo
     */
    public List<CursoGrupoEntity> findAll() {
        Query todos = em.createQuery("select e from CursoGrupoEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla cursoGrupo
     *
     * @param id que se desea buscar
     * @return cursoGrupo
     */
    public CursoGrupoEntity find(Long id) {
        CursoGrupoEntity cursoGrupo = em.find(CursoGrupoEntity.class, id);
        return cursoGrupo;
    }

    /**
     * Creacion de un nuevo cursoGrupo
     *
     * @param cursoGrupo
     * @return nuevo cursoGrupo creado
     */
    public CursoGrupoEntity create(CursoGrupoEntity cursoGrupo) {
        em.persist(cursoGrupo);
        return cursoGrupo;
    }

    /**
     * Actualizacion de una tupla de la tabla cursoGrupo
     *
     * @param cursoGrupoActualizar
     * @return cursoGrupo actualizado
     */
    public CursoGrupoEntity update(CursoGrupoEntity cursoGrupoActualizar) {
        return em.merge(cursoGrupoActualizar);
    }

    /**
     * Elimina una tupla cursoGrupo de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        CursoGrupoEntity cursoGrupoDelete = em.find(CursoGrupoEntity.class, id);
        em.remove(cursoGrupoDelete);
    }
}
