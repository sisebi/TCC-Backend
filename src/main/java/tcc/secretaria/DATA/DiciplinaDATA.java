
package tcc.secretaria.DATA;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_diciplina")
public class DiciplinaDATA implements Serializable{
    @Id
//    @SequenceGenerator(name = "seq_diciplina",
//            sequenceName = "seq_dic_id",
//            allocationSize = 1)
//    @GeneratedValue(generator = "seq_diciplina",strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false,length = 50)
    private String nome;
    
    @Column(length = 100,nullable = false)
    private String descricao;
    
    public DiciplinaDATA() {
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
    
}
