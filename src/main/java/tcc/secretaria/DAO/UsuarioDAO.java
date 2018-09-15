
package tcc.secretaria.DAO;

import java.util.List;
import javax.persistence.*;
import tcc.secretaria.DATA.UsuarioDATA;
import tcc.secretaria.UTIL.ErroSistema;


public class UsuarioDAO {
    private final EntityManagerFactory factory;
    private final EntityManager manager;

    public UsuarioDAO() {
        this.factory = Persistence.createEntityManagerFactory("SECRE_PU");
        this.manager = factory.createEntityManager();
    }
    
    public void inserir(UsuarioDATA udata) throws ErroSistema{
        try {
            this.manager.getTransaction().begin();
            this.manager.persist(udata);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            this.manager.getTransaction().rollback();
            throw new ErroSistema("Erro ao inserir :", e);
        }finally{
            manager.close();
            factory.close();
        }
        
    }
    public void salvar(UsuarioDATA udata) throws ErroSistema{
        try {
            this.manager.getTransaction().begin();
            this.manager.merge(udata);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            this.manager.getTransaction().rollback();
            throw new ErroSistema("Erro ao salvar :", e);
        }finally{
            manager.close();
            factory.close();
        }
        
    }
    public void deletar(Integer codigo) throws ErroSistema{
        try {
            UsuarioDATA u = buscaID(codigo);
            this.manager.getTransaction().begin();
            this.manager.remove(u);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            throw new ErroSistema("Erro ao remover :",e);
        }finally{
            manager.close();
            factory.close();
        }
        
    }
    
    public UsuarioDATA buscaID(Integer codigo){
        return this.manager.find(UsuarioDATA.class, codigo);
    }
    
    public UsuarioDATA buscaCPF(String cpf){
        return (UsuarioDATA) this.manager.createQuery("select u from UsuarioDATA u "
                                                    + "INNER JOIN u.pessoa p "
                                                    + "where p.cpf ='"+cpf+"'").getSingleResult();
    }
    public UsuarioDATA buscaUserName(String usr){
        return (UsuarioDATA) this.manager.createQuery("select u from UsuarioDATA u "
                + "where u.userName = '"+usr+"'").getSingleResult();
    }
    
    public UsuarioDATA validarSenha(String usr,String sh){
        UsuarioDATA u = buscaUserName(usr);
        if (u.getUserName().equals(usr) && u.getSenha().equals(sh)){
            return u; 
        }else{
            return null;
        }
    }
    
    public List<UsuarioDATA> lista(){
        return this.manager.createQuery("select u from UsuarioDATA u ORDER BY u.id").getResultList();
    }
    
    
    
}
