
package tcc.secretaria.DATA;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import tcc.sercretaria.ENUM.CategoriaENUM;

@Entity
@Table(name = "tb_conteudo")
public class ConteudoDATA implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20,nullable = false)
    private CategoriaENUM categoria;
    
    @Column(length = 255,nullable = false)
    private String titulo;
    
    @Column(length = 255,nullable = false)
    private String descricao;
    
    @Column(length = 255,nullable = false)
    private String link;

    public ConteudoDATA() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoriaENUM getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaENUM categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final ConteudoDATA other = (ConteudoDATA) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
