package tcc.secretaria.DAO;

import java.util.List;
import javax.persistence.*;
import tcc.secretaria.DATA.ProfessorDATA;

/**
 *
 * @author PC
 */
public class ProfessorDAO {

    EntityManagerFactory factory;
    EntityManager manager;

    public ProfessorDAO() {
        this.factory = Persistence.createEntityManagerFactory("SECRE_PU");
        this.manager = factory.createEntityManager();
    }

    public void inserir(ProfessorDATA pdata) {
        this.manager.getTransaction().begin();
        this.manager.persist(pdata);
        this.manager.getTransaction().commit();
    }

    public void salvar(ProfessorDATA pdata) {
        this.manager.getTransaction().begin();
        this.manager.merge(pdata);
        this.manager.getTransaction().commit();
    }

    public void deletar(Integer codigo) {
        ProfessorDATA p = buscaID(codigo);
        this.manager.getTransaction().begin();
        this.manager.remove(p);
        this.manager.getTransaction().commit();
    }

    public ProfessorDATA buscaID(Integer codigo) {
        return this.manager.find(ProfessorDATA.class, codigo);
    }

    public ProfessorDATA buscaUserName(String usr) {
        return (ProfessorDATA) this.manager.createQuery("select p from ProfessorDATA p "
                + "where p.userName = '" + usr + "'").getSingleResult();
    }

    public ProfessorDATA validarSenha(String usr, String sh) {
        ProfessorDATA p = buscaUserName(usr);
        if (p.getUserName().equals(usr) && p.getSenha().equals(sh)) {
            return p;
        }else{
            return null;
        }       
    }

    public List<ProfessorDATA> lista() {
        return this.manager.createQuery("select p from ProfessorDATA p").getResultList();
    }

}
