
package tcc.secretaria.WS.Rest.Controle;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tcc.secretaria.DAO.DiciplinaDAO;
import tcc.secretaria.DATA.DiciplinaDATA;

@Path("/diciplina")
public class DiciplinaREST {
    private final DiciplinaDAO cdao = new DiciplinaDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<DiciplinaDATA> lista() {
        try {
            return this.cdao.lista();
        } catch (Exception e) {
            Logger.getLogger(DiciplinaDATA.class.getName()).log(Level.SEVERE, null, e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public DiciplinaDATA getConteudo(@PathParam("id")Integer codigo) {
        try {
            return this.cdao.buscaID(codigo);
        } catch (Exception e) {
            Logger.getLogger(DiciplinaDATA.class.getName()).log(Level.SEVERE, null, e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response inserir(DiciplinaDATA cdata) {
        try {
            this.cdao.inserir(cdata);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            Logger.getLogger(DiciplinaDATA.class.getName()).log(Level.SEVERE, null, e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response salvar(DiciplinaDATA cdata) {
        try {
            this.cdao.salvar(cdata);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            Logger.getLogger(DiciplinaDATA.class.getName()).log(Level.SEVERE, null, e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id")Integer codigo) {
        try {
            this.cdao.deletar(codigo);
            return Response.status(Response.Status.OK).build();            
        } catch (Exception e) {
            Logger.getLogger(DiciplinaDATA.class.getName()).log(Level.SEVERE, null, e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
}
