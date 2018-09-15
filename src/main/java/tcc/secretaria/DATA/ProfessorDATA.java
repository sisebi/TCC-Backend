package tcc.secretaria.DATA;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;
import tcc.sercretaria.ENUM.TipoENUM;

@Entity
@Table(name = "tb_professor")
public class ProfessorDATA extends UsuarioDATA implements Serializable {
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dt_acesso;
    
    @Column(length = 8,nullable = false)
    private String hr_acesso;

    public ProfessorDATA() {
        super.setTipo(TipoENUM.PFR);
        this.hr_acesso = new SimpleDateFormat("HH:mm:ss").format(new Date());
        this.dt_acesso = new Date();                
    }

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
