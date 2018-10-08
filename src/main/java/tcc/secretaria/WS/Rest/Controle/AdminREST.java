
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
import tcc.secretaria.DAO.AdminDAO;
import tcc.secretaria.DATA.AdminDATA;
import tcc.secretaria.UTIL.ErroWEB;

@Path("/adm")
public class AdminREST {
    
    private final AdminDAO adm = new AdminDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<AdminDATA> lista() {
        return this.adm.lista();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public AdminDATA buscaID(@PathParam("id")Integer codigo){
        return this.adm.buscaID(codigo);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{usr}/{sh}")
    public AdminDATA validarSenha(@PathParam("usr")String usr,
            @PathParam("sh")String sh){
        return this.adm.validarSenha(usr, sh);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public String inserir(AdminDATA adata){
        try {
            this.adm.inserir(adata);
            return "Inserido com sucesso !";
        } catch (Exception e) {
            throw new ErroWEB("Erro ao inserir.");
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public String salvar(AdminDATA adata){
        try {
            this.adm.salvar(adata);
            return "Salvo com sucesso !";
        } catch (Exception e) {
            throw new ErroWEB("Erro ao salvar.");
        }
    }
    
    @DELETE
    @Path("/{id}")
    public String deletar(@PathParam("id")Integer codigo){
        try {
            this.adm.deletar(codigo);
            return "Deletado com sucesso!";
        } catch (Exception e) {
            throw new ErroWEB("Erro ao deletar.");
        }
    }
    
}
