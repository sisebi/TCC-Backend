
package tcc.secretaria.DATA;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;
import tcc.secretaria.ENUM.TipoENUM;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_usuario" )
public class UsuarioDATA implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    private Integer id;
    
    @Column(length = 8)
    private String senha;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)        
    private TipoENUM tipo;
    
    private Boolean ativo;
    @Column(length = 8,unique = true)
    private String userName;
    
    @OneToOne
    @JoinColumn(name = "pessoa_re", nullable = false,unique = true )    
    private PessoaDATA pessoa;

    public UsuarioDATA() {
    }
    
    public String getUserName() {
        return userName;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoENUM getTipo() {
        return tipo;
    }

    public void setTipo(TipoENUM tipo) {
        this.tipo = tipo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public PessoaDATA getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaDATA pessoa) {
        if (pessoa != null){
            this.userName = pessoa.getNome().substring(0,3)  + pessoa.getCpf().substring(0,3);
        }
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final UsuarioDATA other = (UsuarioDATA) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    

   

            
    
    
}
