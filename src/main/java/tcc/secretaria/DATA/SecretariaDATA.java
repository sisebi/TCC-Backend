
package tcc.secretaria.DATA;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import tcc.sercretaria.ENUM.TipoENUM;

@Entity
@Table(name = "tb_secretaria")
public class SecretariaDATA extends UsuarioDATA implements Serializable{
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dt_acesso;
    
    @Column(length = 8, nullable = false)
    private String hr_Acesso;

    public SecretariaDATA() {
        super.setTipo(TipoENUM.SEC);
        this.hr_Acesso = new SimpleDateFormat("HH:mm:ss").format(new Date());
        this.dt_acesso = new Date();
    }

    public Date getDt_acesso() {
        return dt_acesso;
    }

    public void setDt_acesso(Date dt_acesso) {
        this.dt_acesso = dt_acesso;
    }

    public String getHr_Acesso() {
        return hr_Acesso;
    }

    public void setHr_Acesso(String hr_Acesso) {
        this.hr_Acesso = hr_Acesso;
    }
    
    
    
}
