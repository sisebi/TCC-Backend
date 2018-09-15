
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
import tcc.secretaria.DAO.ProfessorDAO;
import tcc.secretaria.DATA.ProfessorDATA;
import tcc.secretaria.UTIL.ErroWEB;

@Path("/pfr")
public class ProfessorREST {
    private final ProfessorDAO pdao = new ProfessorDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<ProfessorDATA> lista(){
        return this.pdao.lista();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProfessorDATA buscaID(@PathParam("id")Integer codigo){
        return this.pdao.buscaID(codigo);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{usr}/{sh}")
    public ProfessorDATA validarSenha(@PathParam("usr")String usr,
            @PathParam("sh")String sh){
        return this.pdao.validarSenha(usr, sh);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public String inserir(ProfessorDATA pdata){
        try {
            this.pdao.inserir(pdata);
            return "Inserido com sucesso!";
        } catch (Exception e) {
            throw new ErroWEB("Erro ao inserir.");
        }
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public String salvar(ProfessorDATA dATA){
        try {
            this.pdao.salvar(dATA);
            return "Salvo com sucesso!";
        } catch (Exception e) {
            throw new ErroWEB("Erro ao salvar.");
        }
    }
    @DELETE
    @Path("/{id}")
    public String deletar(@PathParam("id")Integer codigo){
        try {
            this.pdao.deletar(codigo);
            return "Deletado com sucesso!";
        } catch (Exception e) {
            throw new ErroWEB("Erro ao deletar.");
        }
    }
    
}
