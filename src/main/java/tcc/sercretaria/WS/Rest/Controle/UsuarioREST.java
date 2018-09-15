
package tcc.sercretaria.WS.Rest.Controle;

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
import tcc.secretaria.DAO.UsuarioDAO;
import tcc.secretaria.DATA.UsuarioDATA;

@Path("/usuario")
public class UsuarioREST {
    private final UsuarioDAO udao = new UsuarioDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<UsuarioDATA> lista(){
        try {
            return udao.lista();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDATA.class.getName()).log(Level.SEVERE,null,e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public UsuarioDATA getUsuario(@PathParam("id")Integer codigo){
        try {            
            return this.udao.buscaID(codigo);
        } catch (Exception e) {
            Logger.getLogger(UsuarioDATA.class.getName()).log(Level.SEVERE, null,e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{usr}/{sh}")
    public UsuarioDATA validarSenha(@PathParam("usr")String usr,
            @PathParam("sh")String sh){
        return this.udao.validarSenha(usr, sh);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response inserir(UsuarioDATA udata){
        try {
            this.udao.inserir(udata);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDATA.class.getName()).log(Level.SEVERE,null,e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response salvar(UsuarioDATA udata){
        try {
            this.udao.salvar(udata);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDATA.class.getName()).log(Level.SEVERE, null, e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Integer codigo){
        try {
            this.udao.deletar(codigo);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
             Logger.getLogger(UsuarioDATA.class.getName()).log(Level.SEVERE, null, e);
             throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        
    }
}
