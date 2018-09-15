
package tcc.secretaria.DATA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_curso")
public class CursoDATA implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 50,nullable = false)
    private String nome;
    
    @Column(length = 100,nullable = false)
    private String descricao;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "diciplinas",
            joinColumns = 
            @JoinColumn(name = "curso_id",referencedColumnName = "id",nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "diciplina_id",referencedColumnName = "id",nullable = false),
            uniqueConstraints = {
            @UniqueConstraint(columnNames = {"curso_id","diciplina_id"})})
    private List<DiciplinaDATA> diciplinas = new ArrayList<>();

    public CursoDATA() {
    }

//    public void addDiciplina(DiciplinaDATA cr_dc){
//        cr_dc.setCurso(this);
//        this.diciplinas.add(cr_dc);
//    }
//    public void removeDiciplina(int index){
//        this.diciplinas.remove(index);
//    }

    public List<DiciplinaDATA> getDiciplinas() {
        return diciplinas;
    }

    public void setDiciplinas(List<DiciplinaDATA> diciplinas) {
        this.diciplinas = diciplinas;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final CursoDATA other = (CursoDATA) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    
}
