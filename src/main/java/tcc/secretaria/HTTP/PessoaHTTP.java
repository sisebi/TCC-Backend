
package tcc.secretaria.HTTP;

import java.util.Date;
import java.util.Objects;


public class PessoaHTTP {
    private Integer re;   
    private String cpf;    
    private String nome;   
    private String email;  
    private String telefone;   
    private String celular;          
    private Date dt_cadastro;   
    private String hr_cadastro; 

    public PessoaHTTP() {
    }

    public PessoaHTTP(String cpf, String nome, String email, String telefone, String celular) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }    

    public PessoaHTTP(Integer re, String cpf, String nome, String email, String telefone, String celular, Date dt_cadastro, String hr_cadastro) {
        this.re = re;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.dt_cadastro = dt_cadastro;
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

    public String getHr_cadastro() {
        return hr_cadastro;
    }

    public void setHr_cadastro(String hr_cadastro) {
        this.hr_cadastro = hr_cadastro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.re);
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
        final PessoaHTTP other = (PessoaHTTP) obj;
        if (!Objects.equals(this.re, other.re)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PessoaHTTP{" + "re=" + re + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", celular=" + celular + ", dt_cadastro=" + dt_cadastro + ", hr_cadastro=" + hr_cadastro + '}';
    }
    
    
}
