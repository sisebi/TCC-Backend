
package tcc.secretaria.UTIL;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


public class ErroWEB extends WebApplicationException{

    public ErroWEB() {
    }

    public ErroWEB(String message) {
        super(message);
    }

    public ErroWEB(Response response) {
        super(response);
    }

    public ErroWEB(String message, Response response) {
        super(message, response);
    }     

    public ErroWEB(String erro_ao_Buscar_id_, Response.Status status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
