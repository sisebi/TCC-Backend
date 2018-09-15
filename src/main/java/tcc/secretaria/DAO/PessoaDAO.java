package tcc.secretaria.DAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import tcc.secretaria.DATA.PessoaDATA;
import tcc.secretaria.UTIL.ErroSistema;

public class PessoaDAO {

    private final EntityManagerFactory factory;
    private final EntityManager manager;

    public PessoaDAO() {
        this.factory = Persistence.createEntityManagerFactory("SECRE_PU");
        this.manager = factory.createEntityManager();
    }

    public void inserir(PessoaDATA p) throws ErroSistema {
        try {
            if (p != null){
                p.setDt_cadastro(new Date());
                p.setHr_cadastro(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
            manager.getTransaction().begin();
            manager.persist(p);
            manager.getTransaction().commit();
        } catch (Exception e) {
            throw new ErroSistema("Erro ao Inserir :", e);
        } finally {
            manager.close();
            factory.close();
        }
    }

    public void salvar(PessoaDATA p) throws ErroSistema {
        try {
            if (p != null){
                p.setDt_cadastro(new Date());
                p.setHr_cadastro(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
            manager.getTransaction().begin();
            manager.merge(p);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new ErroSistema("Erro ao Salvar :", e);
        } finally {
            manager.close();
            factory.close();
        }
    }

    public void deletar(Integer codigo) throws ErroSistema {
        try {
            PessoaDATA p = buscarID(codigo);
            this.manager.getTransaction().begin();
            this.manager.remove(p);
            this.manager.getTransaction().commit();
        } catch (Exception e) {
            throw new ErroSistema("Erro ao deletar :", e);
        } finally {
            this.manager.close();
            this.factory.close();
        }
    }

    public PessoaDATA buscarID(Integer codigo) {
        return this.manager.find(PessoaDATA.class, codigo);
    }

    public PessoaDATA buscaCPF(String cpf){
        return (PessoaDATA) this.manager.createQuery("select p from PessoaDATA p where p.cpf ='"+cpf+"'").getSingleResult();
    }
    
    public List<PessoaDATA> buscaNOME(String nome){
        return this.manager.createQuery("select p from PessoaDATA p where p.nome LIKE '%"+nome+"%'").getResultList();
    }
    
    public List<PessoaDATA> lista() {
        return this.manager.createQuery("select p from PessoaDATA p ORDER BY p.nome").getResultList();
    }
    

}
