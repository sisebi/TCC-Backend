
package tcc.secretaria.DATA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

//@Entity
//@Table(name = "tb_Curso_Diciplinas",
//        uniqueConstraints ={@UniqueConstraint(name = "uk_cr_dc",
//                columnNames ={"curso_id","diciplina_id"} )})
public class Curso_Diciplinas implements Serializable{
    @Id
//    @SequenceGenerator(name = "seq_cr_dc",
//            sequenceName = "seq_cr_dc_id",
//            allocationSize = 1)
//    @GeneratedValue(generator = "seq_cr_dc",strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "diciplina_id",
            referencedColumnName = "id",
            nullable = false)
    @ForeignKey(name = "fk_diciplina_id")
    private DiciplinaDATA diciplina;
    
    @ManyToOne
    @JoinColumn(name = "curso_id",
            referencedColumnName = "id",
            nullable = false)
    @ForeignKey(name = "fk_curso_id")
    private CursoDATA curso;

    public Curso_Diciplinas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DiciplinaDATA getDiciplina() {
        return diciplina;
    }

    public void setDiciplina(DiciplinaDATA diciplina) {
        this.diciplina = diciplina;
    }

    public CursoDATA getCurso() {
        return curso;
    }

    public void setCurso(CursoDATA curso) {
        this.curso = curso;
    }

            
    
    
}
