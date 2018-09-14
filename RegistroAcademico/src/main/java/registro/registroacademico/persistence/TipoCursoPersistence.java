
package registro.registroacademico.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import registro.registroacademico.entities.TipoCursoEntity;

/**
 *Manejador de la entidad TipoCurso
 * @author David Cañon
 */
@Stateless
public class TipoCursoPersistence {
    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla TipoCurso
     *
     * @return Lista de datos de la tabla TipoCurso
     */
    public List<TipoCursoEntity> findAll() {
        Query todos = em.createQuery("select e from TipoCursoEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla tipoCurso
     *
     * @param id que se desea buscar
     * @return tipoCurso
     */
    public TipoCursoEntity find(Long id) {
        TipoCursoEntity tipoCurso = em.find(TipoCursoEntity.class, id);
        return tipoCurso;
    }

    /**
     * Creacion de un nuevo tipoCurso
     *
     * @param tipoCurso
     * @return nuevo tipoCurso creado
     */
    public TipoCursoEntity create(TipoCursoEntity tipoCurso) {
        em.persist(tipoCurso);
        return tipoCurso;
    }

    /**
     * Actualizacion de una tupla de la tabla tipoCurso
     *
     * @param tipoCursoActualizar
     * @return tipoCurso actualizado
     */
    public TipoCursoEntity update(TipoCursoEntity tipoCursoActualizar) {
        return em.merge(tipoCursoActualizar);
    }

    /**
     * Elimina una tupla tipoCurso de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        TipoCursoEntity tipoCursoDelete = em.find(TipoCursoEntity.class, id);
        em.remove(tipoCursoDelete);
    }
}
