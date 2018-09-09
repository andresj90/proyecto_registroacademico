package registro.registroacademico.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase encargada de modelar la tabla Programa
 * @author Uriel Rodríguez Vallarta
 */

@Entity (name = "Programa")
public class ProgramaEntity implements Serializable{
    
     /**
     * LLave primaria de la tabla Programa
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_programa;
    
     /**
     * Atributo que maneja nombre de programa
     */
    @Column(name = "nombre_programa", nullable = false)
    private String nombre_programa;
    
    /**
     * Atributo que maneja los créditos del programa a cursar
     */
    @Column(name = "creditos_programa", nullable = false)
    private int creditos_programa;
    
    /**
     * Atributo tipo_programa_id, este es una llave foranea la cual conecta con 
     * la tabla que maneja los tipos de programa
     */
    @ManyToOne
    @JoinColumn(name = "tipo_programa_id", nullable = false)
    private int tipo_programa_id;
    
    /**
     * Atributo facultad_id_facultad, este es una llave foranea la cual conecta con 
     * la tabla de facultad
     */    
    @ManyToOne
    @JoinColumn (name = "facultad_id_facultad", nullable = false)
    private int facultad_id_facultad; 
    
    /**
     * Atributo coordinador_id_coor, este es una llave foranea la cual conecta con 
     * la tabla de coordinador
     */    
    @ManyToOne
    @JoinColumn (name = "coordinador_id_coor", nullable = false)
    private int coordinador_id_coor; 
    
    /**
     * Constructor por defecto
     */
    public ProgramaEntity() {
    }

    /**
     * ------------- METODOS GET Y SET -------------- 
     */
    
    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }

    public String getNombre_programa() {
        return nombre_programa;
    }

    public void setNombre_programa(String nombre_programa) {
        this.nombre_programa = nombre_programa;
    }

    public int getCreditos_programa() {
        return creditos_programa;
    }

    public void setCreditos_programa(int creditos_programa) {
        this.creditos_programa = creditos_programa;
    }

    public int getTipo_programa_id() {
        return tipo_programa_id;
    }

    public void setTipo_programa_id(int tipo_programa_id) {
        this.tipo_programa_id = tipo_programa_id;
    }

    public int getFacultad_id_facultad() {
        return facultad_id_facultad;
    }

    public void setFacultad_id_facultad(int facultad_id_facultad) {
        this.facultad_id_facultad = facultad_id_facultad;
    }

    public int getCoordinador_id_coor() {
        return coordinador_id_coor;
    }

    public void setCoordinador_id_coor(int coordinador_id_coor) {
        this.coordinador_id_coor = coordinador_id_coor;
    }
}//clase
