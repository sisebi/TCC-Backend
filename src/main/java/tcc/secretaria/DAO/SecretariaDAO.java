package tcc.secretaria.DAO;

import java.util.List;
import javax.persistence.*;
import tcc.secretaria.DATA.SecretariaDATA;

public class SecretariaDAO {

    private final EntityManagerFactory factory;
    private final EntityManager manager;

    public SecretariaDAO() {
        this.factory = Persistence.createEntityManagerFactory("SECRE_PU");
        this.manager = factory.createEntityManager();
    }

    public void inserir(SecretariaDATA sdata) {
        this.manager.getTransaction().begin();
        this.manager.persist(sdata);
        this.manager.getTransaction().commit();
    }

    public void salvar(SecretariaDATA sdata) {
        this.manager.getTransaction().begin();
        this.manager.merge(sdata);
        this.manager.getTransaction().commit();
    }

    public void deletar(Integer codigo) {
        SecretariaDATA sdata = this.manager.find(SecretariaDATA.class, codigo);
        this.manager.getTransaction().begin();
        this.manager.remove(sdata);
        this.manager.getTransaction().commit();
    }

    public SecretariaDATA buscaID(Integer codigo) {
        return this.manager.find(SecretariaDATA.class, codigo);
    }

    public SecretariaDATA buscaUserName(String usr) {
        return (SecretariaDATA) this.manager.createQuery("select s from SecretariaDATA s "
                + "where s.userName = '" + usr + "'").getSingleResult();
    }

    public SecretariaDATA validarSenha(String usr, String sh) {
        SecretariaDATA s = buscaUserName(usr);
        if (s.getUserName().equals(usr) && s.getSenha().equals(sh)) {
            return s;
        } else {
            return null;
        }
    }
    
    public List<SecretariaDATA> lista(){
        return this.manager.createQuery("select s from SecretariaDATA s ").getResultList();
    }

}
