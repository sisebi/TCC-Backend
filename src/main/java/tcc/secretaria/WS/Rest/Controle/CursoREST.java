package tcc.secretaria.WS.Rest.Controle;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tcc.secretaria.DAO.CursoDAO;
import tcc.secretaria.DATA.CursoDATA;
import tcc.secretaria.UTIL.ErroWEB;

@Path("/curso")
public class CursoREST {
    
    private final CursoDAO cdao = new CursoDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<CursoDATA> lista() {
        return this.cdao.lista();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public CursoDATA buscaID(@PathParam("id")Integer codigo) {
        return this.cdao.buscaID(codigo);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public String inserir(CursoDATA cdata) {
        try {
            this.cdao.inserir(cdata);
            return "Inserido com sucesso !";
        } catch (Exception e) {
            throw new ErroWEB("erro ao inserir.");
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public String salvar(CursoDATA cdata) {
        try {
            this.cdao.salvar(cdata);
            return "Salvo com sucesso !";
        } catch (Exception e) {
            throw new ErroWEB("erro ao salvar.");
        }
    }

    @DELETE
    @Path("/{id}")
    public String deletar(@PathParam("id")Integer codigo) {
        try {
            this.cdao.deletar(codigo);
            return "Deletado com sucesso !";
        } catch (Exception e) {
            throw new ErroWEB("erro ao deletar.");
        }
    }
    
}
