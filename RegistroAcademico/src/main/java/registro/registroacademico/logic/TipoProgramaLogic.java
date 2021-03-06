/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro.registroacademico.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import registro.registroacademico.entities.TipoProgramaEntity;
import registro.registroacademico.persistence.TipoProgramaPersistence;

/**
 * Logica de negocio tipo de programa
 * @author Uriel Rodríguez Vallarta
 */

@Stateless
public class TipoProgramaLogic {
    
    @Inject 
    private TipoProgramaPersistence tipoProgramaPersistance; 
    
    /**
     * Obtener todos los tipos de programas
     * @return tipoPrograma 
     */
    public List<TipoProgramaEntity> getTipoProgramas(){
      List<TipoProgramaEntity> tipoProgramas = tipoProgramaPersistance.findAll();
      return tipoProgramas;
    }
    
    /**
     * Obtener un tipo de programa a través del id
     * @param id
     * @return 
     */
    
    public  TipoProgramaEntity getTipoPrograma(int id){
     TipoProgramaEntity tipoPrograma = tipoProgramaPersistance.find(id);
     if (tipoPrograma == null) {
            throw new IllegalArgumentException("El tipo de programa solicitado no existe");
        }
     return tipoPrograma;
    }
    
    /**
     * Crear un nuevo tipo de programa
     * @param tipoProgramaEntity
     * @return 
     */
    
    public TipoProgramaEntity createTipoPrograma(TipoProgramaEntity tipoProgramaEntity){
      tipoProgramaPersistance.create(tipoProgramaEntity); 
      return  tipoProgramaEntity;
    }
    
    /**
     * Actualizar tipo programa
     * @param id
     * @param tipoProgramaEntity
     * @return 
     */
    
    public TipoProgramaEntity updateTipoPrograma(int id, TipoProgramaEntity tipoProgramaEntity){
     TipoProgramaEntity tipoPrograma = tipoProgramaPersistance.update(tipoProgramaEntity); 
     return tipoPrograma;
    }
    
    /**
     * metodo para eliminar tipo programa de la tabla
     * @param id 
     */
    
    public void deleteTipoPrograma(int id){
        tipoProgramaPersistance.remove(id);
    }
}//class
