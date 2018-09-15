
package tcc.secretaria.DATA;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "tb_matricula",
        uniqueConstraints = {@UniqueConstraint(name = "uk_cr_al_an",
                columnNames = {"aluno_id","curso_id","ano"})})
public class MatriculaDATA implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "curso_id",
            referencedColumnName = "id",
            nullable = false)
    @ForeignKey(name = "fk_curso_id")
    private CursoDATA curso;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id",
            referencedColumnName = "id",
            nullable = false)
    @ForeignKey(name = "fk_aluno_id")
    private AlunoDATA aluno;
    
    @Column(nullable = false)
    private Integer ano;

    public MatriculaDATA() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CursoDATA getCurso() {
        return curso;
    }

    public void setCurso(CursoDATA curso) {
        this.curso = curso;
    }

    public AlunoDATA getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDATA aluno) {
        this.aluno = aluno;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MatriculaDATA other = (MatriculaDATA) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
