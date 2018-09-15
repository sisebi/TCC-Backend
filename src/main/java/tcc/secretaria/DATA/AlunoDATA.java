package tcc.secretaria.DATA;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import tcc.sercretaria.ENUM.TipoENUM;

@Entity
@Table(name = "tb_aluno")
public class AlunoDATA extends UsuarioDATA implements Serializable {

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dt_acesso;
    
    @Column(length = 8, nullable = false)
    private String hr_acesso;
    
//    @OneToMany(mappedBy = "aluno" , 
//    cascade = CascadeType.ALL,
//    orphanRemoval = true,
//    fetch = FetchType.LAZY)
//    private List<MatriculaDATA> matriculas = new ArrayList<>();

    public AlunoDATA() {
        super.setTipo(TipoENUM.ALN);
        this.hr_acesso = new SimpleDateFormat("HH:mm:ss").format(new Date());
        this.dt_acesso = new Date();
    }
    
//    public void addMatricula(MatriculaDATA obj){
//        obj.setAluno(this);
//        this.matriculas.add(obj);
//    }
//    public void removeMatricula(int index){
//        this.matriculas.remove(index);
//    }
//
//    public List<MatriculaDATA> getMatriculas() {
//        return matriculas;
//    }
//
//    public void setMatriculas(List<MatriculaDATA> matriculas) {
//        this.matriculas = matriculas;
//    }
    
    

    public Date getDt_acesso() {
        return dt_acesso;
    }

    public void setDt_acesso(Date dt_acesso) {
        this.dt_acesso = dt_acesso;
    }

    public String getHr_acesso() {
        return hr_acesso;
    }

    public void setHr_acesso(String hr_acesso) {
        this.hr_acesso = hr_acesso;
    }

}
