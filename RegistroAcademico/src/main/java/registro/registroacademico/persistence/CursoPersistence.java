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
import registro.registroacademico.entities.CursoEntity;

/**
 * Clase es usada para manejar la transaccionalidad de la entidad Curso
 * @author Uriel Rodríguez Vallarta
 */
@Stateless
public class CursoPersistence {
    @PersistenceContext(unitName = "registroacademicoPU")
    private EntityManager entityManager;
    /**
     * Metodo que lista todos los elementos que se encuentran en la tabla Curso
     * @return lista de Cursos
     */
    public List<CursoEntity> findAll(){
        Query todos = entityManager.createQuery("select c from CursoEntity c");
        return todos.getResultList();
    }
    /**
     * Metodo que encuentra un Curso por su id
     * @param id
     * @return cursoEncontrado
     */
    public CursoEntity find(int id){
        CursoEntity cursoEncontrado = entityManager.find(CursoEntity.class, id);
        return cursoEncontrado;
    }
    /**
     * Metodo que nos permite crear un Curso
     * @param cursoCrear
     * @return cursoCreado
     */
    public CursoEntity create(CursoEntity cursoCrear){
        entityManager.persist(cursoCrear);
        return cursoCrear;
    }
    /**
     * Metodo que nos permite actualizar un Curso
     * @param cursoActualizar
     * @return cursoActualizado
     */
    public CursoEntity update(CursoEntity cursoActualizar){
        entityManager.merge(cursoActualizar);
        return cursoActualizar;
    }
    /**
     * Metodo que nos permite eliminar un Curso
     * @param id 
     */
    public void remove(int id){
        CursoEntity cursoEliminar = entityManager.find(CursoEntity.class, id);
        entityManager.remove(cursoEliminar);
    }  
}