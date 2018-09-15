
package tcc.secretaria.DAO;

import java.util.List;
import javax.persistence.*;
import tcc.secretaria.DATA.CursoDATA;


public class CursoDAO {
    private final EntityManagerFactory factory;
    private final EntityManager manager;

    public CursoDAO() {
        this.factory = Persistence.createEntityManagerFactory("SECRE_PU");
        this.manager = factory.createEntityManager();
    }
    
    public void inserir(CursoDATA cdata){
        this.manager.getTransaction().begin();
        this.manager.persist(cdata);
        this.manager.getTransaction().commit();
    }
    public void salvar(CursoDATA cdata){
        this.manager.getTransaction().begin();
        this.manager.merge(cdata);
        this.manager.getTransaction().commit();
    }
    public void deletar(Integer codigo){
        CursoDATA cdata = this.manager.find(CursoDATA.class, codigo);
        this.manager.getTransaction().begin();
        this.manager.remove(cdata);
        this.manager.getTransaction().commit();
    }
    public CursoDATA buscaID(Integer codigo){
        return this.manager.find(CursoDATA.class, codigo);
    }
    public List<CursoDATA> buscaNome(String nome){
        return this.manager.createQuery("select c from CursoDATA c "
                + "where c.nome like '%"+nome+"%'").getResultList();
    }
    public List<CursoDATA> lista(){
        return this.manager.createQuery("select c from CursoDATA c ").getResultList();
    }
    
    
}
