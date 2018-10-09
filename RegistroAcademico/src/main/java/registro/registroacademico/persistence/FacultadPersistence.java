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
import registro.registroacademico.entities.FacultadEntity;

/**
 * Clase es usada para manejar la transaccionalidad de la entidad Facultad
 * @author Uriel Rodríguez Vallarta
 */
@Stateless
public class FacultadPersistence {
@PersistenceContext(unitName = "registroacademicoPU")
    private EntityManager entityManager;
    /**
     * Metodo que lista todos los elementos que se encuentran en la tabla Facultad
     * @return lista de facultades
     */
    public List<FacultadEntity> findAll(){
        Query todos = entityManager.createQuery("select f from Facultad f");
        return todos.getResultList();
    }
    /**
     * Metodo que encuentra una Facultad por su id
     * @param id
     * @return facultadEncontrado
     */
    public FacultadEntity find(int id){
        FacultadEntity facultadEncontrado = entityManager.find(FacultadEntity.class, id);
        return facultadEncontrado;
    }
    /**
     * Metodo que nos permite crear una facultad
     * @param facultadCrear
     * @return facultadCreado
     */
    public FacultadEntity create(FacultadEntity facultadCrear){
        entityManager.persist(facultadCrear);
        return facultadCrear;
    }
    /**
     * Metodo que nos permite actualizar una Facultad
     * @param facultadActualizar
     * @return facultadActualizado
     */
    public FacultadEntity update(FacultadEntity facultadActualizar){
        entityManager.merge(facultadActualizar);
        return facultadActualizar;
    }
    /**
     * Metodo que nos permite eliminar una Facultad
     * @param id 
     */
    public void remove(int id){
        FacultadEntity facultadEliminar = entityManager.find(FacultadEntity.class, id);
        entityManager.remove(facultadEliminar);
    }         
}
