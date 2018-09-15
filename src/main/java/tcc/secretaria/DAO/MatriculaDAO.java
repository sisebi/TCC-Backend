package tcc.secretaria.DAO;

import java.util.List;
import javax.persistence.*;
import tcc.secretaria.DATA.MatriculaDATA;
import tcc.secretaria.UTIL.ErroSistema;

public class MatriculaDAO {

    EntityManagerFactory factory;
    EntityManager manager;

    public MatriculaDAO() {
        this.factory = Persistence.createEntityManagerFactory("SECRE_PU");
        this.manager = factory.createEntityManager();
    }

    public void inserir(MatriculaDATA mdata) throws ErroSistema {
//        if (acharCadastro(mdata) == false) {
            this.manager.getTransaction().begin();
            this.manager.persist(mdata);
            this.manager.getTransaction().commit();
//        } else {
//            this.manager.getTransaction().rollback();
//            throw new ErroSistema("Erro ao inserir, já existe este cadastro!");
//        }
    }

    public void salvar(MatriculaDATA mdata) throws ErroSistema {
        this.manager.getTransaction().begin();
//        if (mdata.getId() == null) {
//            if (acharCadastro(mdata) == false) {
//                this.manager.merge(mdata);
//                this.manager.getTransaction().commit();
//            } else {
//                this.manager.getTransaction().rollback();
//                throw new ErroSistema("Erro ao salvar, já existe este cadastro");
//            }
//        } else {
            this.manager.merge(mdata);
            this.manager.getTransaction().commit();
//        }
    }

    public void deletar(Integer codigo) {
        MatriculaDATA m = this.manager.find(MatriculaDATA.class, codigo);
        this.manager.getTransaction().begin();
        this.manager.remove(m);
        this.manager.getTransaction().begin();
    }

    public MatriculaDATA buscaID(Integer codigo) {
        return this.manager.find(MatriculaDATA.class, codigo);
    }
    public List<MatriculaDATA> listaAln(Integer codigo){
        return this.manager.createQuery("select m from MatriculaDATA m "
                + "INNER JOIN m.aluno a "
                + "where a.id ="+codigo).getResultList();
    }

    public List<MatriculaDATA> lista() {
        return this.manager.createQuery("select m from MatriculaDATA m ").getResultList();
    }

    public Boolean acharCadastro(MatriculaDATA mdata) {
        List<MatriculaDATA> lista = this.manager.createQuery(
                "select m from MatriculaDATA m "
                + "INNER JOIN m.aluno a "
                + "INNER JOIN m.curso c "
                + "where m.ano = " + mdata.getAno()
                + "and a.id =" + mdata.getAluno().getId()
                + "and c.id =" + mdata.getCurso().getId()).getResultList();
        if (lista.size() <= 0) {
            return false;
        } else {
            return true;
        }
    }

}
