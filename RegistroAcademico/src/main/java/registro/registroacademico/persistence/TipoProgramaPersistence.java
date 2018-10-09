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
import registro.registroacademico.entities.TipoProgramaEntity;

/**
 * Clase es usada para manejar la transaccionalidad de la entidad Tipo Programa
 * @author Uriel Rodríguez Vallarta
 */
@Stateless
public class TipoProgramaPersistence {
@PersistenceContext(unitName = "registroacademicoPU")
    private EntityManager entityManager;
    /**
     * Metodo que lista todos los elementos que se encuentran en la tabla Tipo Programa
     * @return lista de tipo programa
     */
    public List<TipoProgramaEntity> findAll(){
        Query todos = entityManager.createQuery("select tp from Tipo_Programa tp");
        return todos.getResultList();
    }
    /**
     * Metodo que encuentra un Tipo Programa por su id
     * @param id
     * @return tipoprogramaEncontrado
     */
    public TipoProgramaEntity find(int id){
        TipoProgramaEntity tipoprogramaEncontrado = entityManager.find(TipoProgramaEntity.class, id);
        return tipoprogramaEncontrado;
    }
    /**
     * Metodo que nos permite crear un Tipo Programa
     * @param tipoprogramaCrear
     * @return tipoprogramaCreado
     */
    public TipoProgramaEntity create(TipoProgramaEntity tipoprogramaCrear){
        entityManager.persist(tipoprogramaCrear);
        return tipoprogramaCrear;
    }
    /**
     * Metodo que nos permite actualizar un Tipo Programa
     * @param tipoprogramaActualizar
     * @return tipoprogramaActualizado
     */
    public TipoProgramaEntity update(TipoProgramaEntity tipoprogramaActualizar){
        entityManager.merge(tipoprogramaActualizar);
        return tipoprogramaActualizar;
    }
    /**
     * Metodo que nos permite eliminar un Tipo Programa
     * @param id 
     */
    public void remove(int id){
        TipoProgramaEntity tipoprogramaEliminar = entityManager.find(TipoProgramaEntity.class, id);
        entityManager.remove(tipoprogramaEliminar);
    }         
}