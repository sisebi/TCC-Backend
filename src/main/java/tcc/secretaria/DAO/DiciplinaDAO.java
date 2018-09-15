
package tcc.secretaria.DAO;

import java.util.List;
import javax.persistence.*;
import tcc.secretaria.DATA.DiciplinaDATA;


public class DiciplinaDAO {
    private final EntityManagerFactory factory;
    private final EntityManager manager;

    public DiciplinaDAO() {
        this.factory = Persistence.createEntityManagerFactory("SECRE_PU");
        this.manager = factory.createEntityManager();
    }
    
    public void inserir(DiciplinaDATA ddata){
        this.manager.getTransaction().begin();
        this.manager.persist(ddata);
        this.manager.getTransaction().commit();
    }
    
    public void salvar(DiciplinaDATA ddata){
        this.manager.getTransaction().begin();
        this.manager.merge(ddata);
        this.manager.getTransaction().commit();
    }
    
    public void deletar(Integer codigo){
        DiciplinaDATA d = this.manager.find(DiciplinaDATA.class, codigo);
        this.manager.getTransaction().begin();
        this.manager.remove(d);
        this.manager.getTransaction().commit();
    }
    
    public DiciplinaDATA buscaID(Integer codigo){
        return this.manager.find(DiciplinaDATA.class, codigo);
    }
    
    public List<DiciplinaDATA> lista(){
        return this.manager.createQuery("select d from DiciplinaDATA d").getResultList();
    }
    
}
