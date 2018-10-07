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
 * Clase encargada de modelar la tabla Curso
 * @author Uriel Rodríguez Vallarta
 */
@Entity (name = "Curso")
public class CursoEntity implements Serializable{

    /**
     * LLave primaria de la tabla Curso
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_curso; 
   
    /**
     * Atributo nombre de curso
     */
    @Column (name = "nom_curso", nullable = false)
    private String nom_curso;
    
    /**
     * Atributo programa_id_pr la cual es una llave foranea de la tabla programa
     * y nos ayudará a construir el curso.
     */
    
    @ManyToOne
    @JoinColumn (name = "programa_id_pr", nullable = false)
    private ProgramaEntity programa;
    
    /**
     * Constructor de la clase Curso
     */
    public CursoEntity() {
    }

    /**
     * Metodos Getter Y Setter 
     */  
    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNom_curso() {
        return nom_curso;
    }

    public void setNom_curso(String nom_curso) {
        this.nom_curso = nom_curso;
    }

    public ProgramaEntity getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaEntity programa) {
        this.programa = programa;
    }
}//class