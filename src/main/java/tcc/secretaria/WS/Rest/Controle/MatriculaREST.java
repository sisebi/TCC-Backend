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
import tcc.secretaria.DAO.MatriculaDAO;
import tcc.secretaria.DATA.MatriculaDATA;
import tcc.secretaria.UTIL.ErroWEB;

@Path("/matricula")
public class MatriculaREST {

    private final MatriculaDAO mdao = new MatriculaDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<MatriculaDATA> lista() {
        return this.mdao.lista();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/aln/{id}")
    public List<MatriculaDATA> listaAln(@PathParam("id")Integer codigo) {
        return this.mdao.listaAln(codigo);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public MatriculaDATA buscaID(@PathParam("id") Integer codigo) {
        return this.mdao.buscaID(codigo);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public String inserir(MatriculaDATA mdata) {
        try {
            this.mdao.inserir(mdata);
            return "Inserido com sucesso !";
        } catch (Exception e) {
            throw new ErroWEB("erro ao inserir.");
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public String salvar(MatriculaDATA mdata) {
        try {
            this.mdao.salvar(mdata);
            return "Salvo com sucesso !";
        } catch (Exception e) {
            throw new ErroWEB("erro ao salvar .");
        }
    }

    @DELETE
    @Path("/{id}")
    public String deletar(@PathParam("id") Integer codigo) {
        try {
            this.mdao.deletar(codigo);
            return "Deletado com sucesso !";
        } catch (Exception e) {
            throw new ErroWEB("erro ao deletar .");
        }
    }

}
