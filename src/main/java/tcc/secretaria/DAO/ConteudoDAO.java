
package tcc.secretaria.DAO;

import java.util.List;
import javax.persistence.*;
import tcc.secretaria.DATA.ConteudoDATA;
import tcc.secretaria.UTIL.ErroSistema;


public class ConteudoDAO {
    private final EntityManagerFactory factory;
    private final EntityManager manager;

    public ConteudoDAO() {
        this.factory = Persistence.createEntityManagerFactory("SECRE_PU");
        this.manager = factory.createEntityManager();
    }
    
    public void inserir(ConteudoDATA cdata) throws ErroSistema{
        try {
            this.manager.getTransaction().begin();
            this.manager.persist(cdata);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            this.manager.getTransaction().rollback();
            throw new ErroSistema("Erro ao inserir :", e);
        }finally{
            this.manager.close();
            this.factory.close();
        }
        
    }
    public void salvar(ConteudoDATA cdata) throws ErroSistema{
        try {
            this.manager.getTransaction().begin();
            this.manager.merge(cdata);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            this.manager.getTransaction().rollback();
            throw new ErroSistema("Erro ao salvar :", e);
        }finally{
            this.manager.close();
            this.factory.close();
        }
        
    }
    public void deletar(Integer codigo) throws ErroSistema{
        try {
            ConteudoDATA c = buscaID(codigo);
            this.manager.getTransaction().begin();
            this.manager.remove(c);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            this.manager.getTransaction().rollback();
            throw new ErroSistema("Erro ao deletar :", e);
        }finally{
            this.manager.close();
            this.factory.close();
        }
    }
    public ConteudoDATA buscaID(Integer codigo){
        return this.manager.find(ConteudoDATA.class, codigo);
    }
    public List<ConteudoDATA> buscaTitulo(){
        return this.manager.createQuery("select c from ConteudoDATA c order by c.titulo").getResultList();
    }
    public List<ConteudoDATA> lista(){
        return this.manager.createQuery("select c from ConteudoDATA c order by c.titulo").getResultList();
    }
    
    
    
}
