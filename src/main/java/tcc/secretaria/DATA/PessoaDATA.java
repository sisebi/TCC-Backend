package tcc.secretaria.DATA;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
//import org.hibernate.bytecode.internal.javassist.;



@Entity
@Table(name = "tb_pessoa")
public class PessoaDATA implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer re;
    
    @Column(length = 14,nullable = false,unique = true)
    private String cpf;
    
    @Column(length = 100,nullable = false)
    private String nome;
    
    @Column(length = 30,nullable = false)
    private String email;
    
    @Column(length = 15)
    private String telefone;
    
    @Column(length = 16)
    private String celular;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)        
    private Date dt_cadastro;
    
    @Column(length = 8,nullable = false)
    private String hr_cadastro; 
    
    @OneToOne(mappedBy = "pessoa",fetch = FetchType.LAZY)  
    private UsuarioDATA usuario;
    
    

    public PessoaDATA() {
    }

    public String getHr_cadastro() {
        return hr_cadastro;
    }

    public void setHr_cadastro(String hr_cadastro) {
        this.hr_cadastro = hr_cadastro;
    }

    public Integer getRe() {
        return re;
    }

    public void setRe(Integer re) {
        this.re = re;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.re);
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
        final PessoaDATA other = (PessoaDATA) obj;
        if (!Objects.equals(this.re, other.re)) {
            return false;
        }
        return true;
    }

     

}
