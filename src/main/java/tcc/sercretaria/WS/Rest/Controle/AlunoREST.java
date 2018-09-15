package tcc.sercretaria.WS.Rest.Controle;

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
import tcc.secretaria.DAO.AlunoDAO;
import tcc.secretaria.DATA.AlunoDATA;
import tcc.secretaria.UTIL.ErroWEB;

@Path("/aln")
public class AlunoREST {

    private final AlunoDAO adao = new AlunoDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<AlunoDATA> lista() {
        return this.adao.lista();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public AlunoDATA buscaID(@PathParam("id") Integer codigo) {
        return this.adao.buscaID(codigo);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{usr}/{sh}")
    public AlunoDATA validarSenha(@PathParam("usr") String usr,
            @PathParam("sh") String sh) {
        return this.adao.validarSenha(usr, sh);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public String inserir(AlunoDATA adata) {
        try {
            this.adao.inserir(adata);
            return "Inserido com sucesso!";
        } catch (Exception e) {
            throw new ErroWEB("Erro ao inserir");
        }
    }

    @PUT
    @Consumes
    @Path("/")
    public String salvar(AlunoDATA adata) {
        try {
            this.adao.salvar(adata);
            return "Salvo com sucesso!";
        } catch (Exception e) {
            throw new ErroWEB("Erro ao salvar");
        }
    }

    @DELETE
    @Path("/{id}")
    public String deletar(@PathParam("id") Integer codigo) {
        try {
            this.adao.deletar(codigo);
            return "Deletado com sucesso!";
        } catch (Exception e) {
            throw new ErroWEB("Erro ao deletar");
        }
    }

}
