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
import tcc.secretaria.DAO.PessoaDAO;
import tcc.secretaria.DATA.PessoaDATA;

@Path("/pessoa")
public class PessoaREST {

    private final PessoaDAO pdao = new PessoaDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<PessoaDATA> lista() {
        try {
            return this.pdao.lista();
        } catch (Exception ex) {
            Logger.getLogger(PessoaDATA.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public PessoaDATA getPessoa(@PathParam("id") Integer codigo) {
        try {
            if (codigo < 1) {               
                throw new WebApplicationException(Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("é obrigatório passar um valor !").build());//Cliente error 400 - bad request
                
            } else {
                return this.pdao.buscarID(codigo);
            }
        } catch (Exception ex) {
            Logger.getLogger(PessoaDATA.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response inserir(PessoaDATA p) {
        if (PessoaDATA.class.getName() == null || PessoaDATA.class.getName().trim().equals("")) {
            throw new WebApplicationException(Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("é obrigatório passar um valor !").build());
        }
        try {
            this.pdao.inserir(p);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            Logger.getLogger(PessoaDATA.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response salvar(PessoaDATA p) {
        if (PessoaDATA.class.getName() == null || PessoaDATA.class.getName().trim().equals("")) {
            throw new WebApplicationException(Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("é obrigatório passar um valor !").build());
        }
        try {
            this.pdao.salvar(p);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            Logger.getLogger(PessoaDATA.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer codigo) {
        try {
            this.pdao.deletar(codigo);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            Logger.getLogger(PessoaDATA.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}
