
package registro.registroacademico.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import registro.registroacademico.entities.HorarioGrupoCursoEntity;

/**
 *Manejador de la entidad HorarioGrupoCurso
 * @author David Cañon
 */
@Stateless
public class HorarioGrupoCursoPersistence {
    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla HorarioGrupoCurso
     *
     * @return Lista de datos de la tabla HorarioGrupoCurso
     */
    public List<HorarioGrupoCursoEntity> findAll() {
        Query todos = em.createQuery("select e from HorarioGrupoCursoEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla HorarioGrupoCurso
     *
     * @param id que se desea buscar
     * @return HorarioGrupoCurso
     */
    public HorarioGrupoCursoEntity find(Long id) {
        HorarioGrupoCursoEntity HorarioGrupoCurso = em.find(HorarioGrupoCursoEntity.class, id);
        return HorarioGrupoCurso;
    }

    /**
     * Creacion de un nuevo HorarioGrupoCurso
     *
     * @param HorarioGrupoCurso
     * @return nuevo HorarioGrupoCurso creado
     */
    public HorarioGrupoCursoEntity create(HorarioGrupoCursoEntity HorarioGrupoCurso) {
        em.persist(HorarioGrupoCurso);
        return HorarioGrupoCurso;
    }

    /**
     * Actualizacion de una tupla de la tabla HorarioGrupoCurso
     *
     * @param HorarioGrupoCursoActualizar
     * @return HorarioGrupoCurso actualizado
     */
    public HorarioGrupoCursoEntity update(HorarioGrupoCursoEntity HorarioGrupoCursoActualizar) {
        return em.merge(HorarioGrupoCursoActualizar);
    }

    /**
     * Elimina una tupla horario de la HorarioGrupoCurso
     *
     * @param id
     */
    public void delete(Long id) {
        HorarioGrupoCursoEntity HorarioGrupoCursoDelete = em.find(HorarioGrupoCursoEntity.class, id);
        em.remove(HorarioGrupoCursoDelete);
    }
}