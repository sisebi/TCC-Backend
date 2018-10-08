
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
import tcc.secretaria.DAO.SecretariaDAO;
import tcc.secretaria.DATA.SecretariaDATA;
import tcc.secretaria.UTIL.ErroWEB;

@Path("/sec")
public class SecretariaREST {
    private final SecretariaDAO sdao = new SecretariaDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<SecretariaDATA> lista(){
        return this.sdao.lista();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public SecretariaDATA buscaID(@PathParam("id")Integer codigo){
        return this.sdao.buscaID(codigo);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{usr}/{sh}")
    public SecretariaDATA validarSenha(@PathParam("usr")String usr,
            @PathParam("sh")String sh){
        return this.sdao.validarSenha(usr, sh);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public String inserir(SecretariaDATA sdata){
        try {
            this.sdao.inserir(sdata);
            return "Inserido com sucesso!";
        } catch (Exception e) {
            throw new ErroWEB("Erro ao inserir.");
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public String salvar(SecretariaDATA sdata){
        try {
            this.sdao.salvar(sdata);
            return "Salvo com sucesso!";
        } catch (Exception e) {
            throw new ErroWEB("Erro ao salvar.");
        }
    }
    
    @DELETE
    @Path("/{id}")
    public String deletar(@PathParam("id")Integer codigo){
        try {
            this.sdao.deletar(codigo);
            return "Deletado com sucesso!";
        } catch (Exception e) {
            throw new ErroWEB("Erro ao deletar.");
        }
    }
    
}
