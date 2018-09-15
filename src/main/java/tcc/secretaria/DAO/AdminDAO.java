
package tcc.secretaria.DAO;

import java.util.List;
import javax.persistence.*;
import tcc.secretaria.DATA.AdminDATA;


public class AdminDAO {
    private final EntityManagerFactory factory;
    private final EntityManager manager;

    public AdminDAO() {
        this.factory = Persistence.createEntityManagerFactory("SECRE_PU");
        this.manager = this.factory.createEntityManager();
    }
    
    public void inserir(AdminDATA adata){
        this.manager.getTransaction().begin();
        this.manager.persist(adata);
        this.manager.getTransaction().commit();
    }
    public void salvar(AdminDATA adata){
        this.manager.getTransaction().begin();
        this.manager.merge(adata);
        this.manager.getTransaction().commit();
    }
    public void deletar(Integer codigo){
        this.manager.getTransaction().begin();
        AdminDATA adata = this.manager.find(AdminDATA.class, codigo);
        this.manager.remove(adata);
        this.manager.getTransaction().commit();
    }
    public AdminDATA buscaID(Integer codigo){
        return this.manager.find(AdminDATA.class, codigo);
    }
    public AdminDATA buscaUserName(String usr){
        return (AdminDATA) this.manager.createQuery("select a from AdminDATA a "
                + "where a.userName ='"+usr+"'").getSingleResult();
    }
    public AdminDATA validarSenha(String usr,String sh){
        AdminDATA a = buscaUserName(usr);
        if (a.getUserName().equals(usr) && a.getSenha().equals(sh)){
            return a;
        }else{
            return null;
        }
    }
    public List<AdminDATA> lista(){
        return this.manager.createQuery("select a from AdminDATA a ").getResultList();
    }
    
    
}
