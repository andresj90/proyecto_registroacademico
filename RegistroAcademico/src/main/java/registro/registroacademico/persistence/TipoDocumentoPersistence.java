package registro.registroacademico.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import registro.registroacademico.entities.TipoDocumentoEntity;

/**
 * Clase creada para maneejar la transaccionalidad de la entidad TipoDocumento
 * @author AndresJ90
 */
@Stateless
public class TipoDocumentoPersistence {
    
     //personalizamos el entity manager
    
    @PersistenceContext(unitName = "registroacademicoPU")
    private EntityManager entityManager; 
    
    /**
     * Metodo que lista todos los elementos que se encuentran en la clase TipoDocumento
     * @return 
     */
    
    public List<TipoDocumentoEntity> findAll(){
        
        Query todos = entityManager.createQuery("Select t from Tipo_Documento t");
        return todos.getResultList();
    }
    
    /**
     * Metodo que retorna el TipoDocumento que contiene el id ingresado
     * @para id
     * @return tipoDocumentoEncontrado
     */
    
    public TipoDocumentoEntity find (int id){
        
        TipoDocumentoEntity tipoDocumentoEncontrado =entityManager.find(TipoDocumentoEntity.class, id); 
        return tipoDocumentoEncontrado; 
    }
    
    /**
     * Metodo que nos permite crear un usuario TipoDocumento
     * @para tipoDocumentoCrear
     * @return 
     */
    
    public TipoDocumentoEntity create(TipoDocumentoEntity tipoDocumentoCrear){
        entityManager.persist(tipoDocumentoCrear);
        return tipoDocumentoCrear;
    }
    
    /**
     * Metodo que nos permite actualizar la informacion de un TipoDocumento
     * @param tipoDocumentoActualizar
     * @return 
     */
    
    public TipoDocumentoEntity update(TipoDocumentoEntity tipoDocumentoActualizar){
        entityManager.merge(tipoDocumentoActualizar);
        return tipoDocumentoActualizar;
    }
    
    /**
     * Metodo que nos permite remover una entidad TipoDocumento
     * @param id
     */
    
     public void remove(int id){
         TipoDocumentoEntity tipoDocumentoEliminar = entityManager.find(TipoDocumentoEntity.class, id);
         entityManager.remove(tipoDocumentoEliminar);
     }
}
