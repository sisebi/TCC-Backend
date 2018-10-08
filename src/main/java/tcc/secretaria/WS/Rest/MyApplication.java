
package tcc.secretaria.WS.Rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("tcc.sercretaria.WS.Rest.Controle");
    }
}
    
