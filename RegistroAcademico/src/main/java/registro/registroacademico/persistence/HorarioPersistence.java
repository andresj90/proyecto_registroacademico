/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro.registroacademico.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import registro.registroacademico.entities.HorarioEntity;

/**
 * Manejador de la entidad Horario
 *
 * @author David Cañon
 */
@Stateless
public class HorarioPersistence {
    @PersistenceContext(unitName = "koloPU")
    protected EntityManager em;

    /**
     * Obtener la lista con los datos de la tabla Horario
     *
     * @return Lista de datos de la tabla Horario
     */
    public List<HorarioEntity> findAll() {
        Query todos = em.createQuery("select e from HorarioEntity e");
        return todos.getResultList();
    }

    /**
     * Encontrar una tupla especifica de la tabla horario
     *
     * @param id que se desea buscar
     * @return horario
     */
    public HorarioEntity find(Long id) {
        HorarioEntity horario = em.find(HorarioEntity.class, id);
        return horario;
    }

    /**
     * Creacion de un nuevo horario
     *
     * @param horario
     * @return nuevo horario creado
     */
    public HorarioEntity create(HorarioEntity horario) {
        em.persist(horario);
        return horario;
    }

    /**
     * Actualizacion de una tupla de la tabla horario
     *
     * @param horarioActualizar
     * @return horario actualizado
     */
    public HorarioEntity update(HorarioEntity horarioActualizar) {
        return em.merge(horarioActualizar);
    }

    /**
     * Elimina una tupla horario de la tabla
     *
     * @param id
     */
    public void delete(Long id) {
        HorarioEntity horarioDelete = em.find(HorarioEntity.class, id);
        em.remove(horarioDelete);
    }
}
