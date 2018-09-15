package tcc.secretaria.DAO;

import java.util.List;
import javax.persistence.*;
import tcc.secretaria.DATA.AlunoDATA;

public class AlunoDAO {

    private final EntityManagerFactory factory;
    private final EntityManager manager;

    public AlunoDAO() {
        this.factory = Persistence.createEntityManagerFactory("SECRE_PU");
        this.manager = factory.createEntityManager();
    }
    public void inserir(AlunoDATA adata){
        System.out.println("TIPO - "+adata.getTipo());
        System.out.println("USERNAME - "+adata.getUserName());
        System.out.println("HORA - "+adata.getHr_acesso());
        System.out.println("DATA - "+adata.getDt_acesso());
        this.manager.getTransaction().begin();
        this.manager.persist(adata);
        this.manager.getTransaction().commit();
    }
    public void salvar(AlunoDATA adata){
        this.manager.getTransaction().begin();
        this.manager.merge(adata);
        this.manager.getTransaction().commit();
    }
    public void deletar(Integer codigo){
        AlunoDATA adata = buscaID(codigo);
        this.manager.getTransaction().begin();
        this.manager.remove(adata);
        this.manager.getTransaction().commit();
    }
    public AlunoDATA buscaID(Integer codigo){
        return this.manager.find(AlunoDATA.class, codigo);
    }
    public AlunoDATA buscaUserName(String usr){
        return (AlunoDATA) this.manager.createQuery("select a from AlunoDATA a "
                + "where a.userName ='"+usr+"'").getSingleResult();
    }
    public AlunoDATA validarSenha(String usr,String sh){
        AlunoDATA a = buscaUserName(usr);
        if (a.getUserName().equals(usr) && a.getSenha().equals(sh)){
            return a;
        }else{
            return null;
        }
        
    }
    public List<AlunoDATA> lista(){
        return this.manager.createQuery("select a from AlunoDATA a").getResultList();
    }

}
