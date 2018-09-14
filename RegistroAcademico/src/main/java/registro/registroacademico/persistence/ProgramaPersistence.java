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
import registro.registroacademico.entities.ProgramaEntity;

/**
 * Clase es usada para manejar la transaccionalidad de la entidad Programa
 * @author Uriel Rodríguez Vallarta
 */
@Stateless
public class ProgramaPersistence {
@PersistenceContext(unitName = "registroAcademicoPU")
    private EntityManager entityManager;
    /**
     * Metodo que lista todos los elementos que se encuentran en la tabla Programa
     * @return lista de programas
     */
    public List<ProgramaEntity> findAll(){
        Query todos = entityManager.createQuery("select p from ProgramaEntity p");
        return todos.getResultList();
    }
    /**
     * Metodo que encuentra un Programa por su id
     * @param id
     * @return programaEncontrado
     */
    public ProgramaEntity find(int id){
        ProgramaEntity programaEncontrado = entityManager.find(ProgramaEntity.class, id);
        return programaEncontrado;
    }
    /**
     * Metodo que nos permite crear un Programa
     * @param programaCrear
     * @return programaCreado
     */
    public ProgramaEntity create(ProgramaEntity programaCrear){
        entityManager.persist(programaCrear);
        return programaCrear;
    }
    /**
     * Metodo que nos permite actualizar un Programa
     * @param programaActualizar
     * @return programaActualizado
     */
    public ProgramaEntity update(ProgramaEntity programaActualizar){
        entityManager.merge(programaActualizar);
        return programaActualizar;
    }
    /**
     * Metodo que nos permite eliminar una Programa
     * @param id 
     */
    public void remove(int id){
        ProgramaEntity programaEliminar = entityManager.find(ProgramaEntity.class, id);
        entityManager.remove(programaEliminar);
    }         
}