package tcc.secretaria.MAIN;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import tcc.secretaria.DAO.AdminDAO;
import tcc.secretaria.DAO.AlunoDAO;
import tcc.secretaria.DAO.ConteudoDAO;
import tcc.secretaria.DAO.CursoDAO;
import tcc.secretaria.DAO.DiciplinaDAO;
import tcc.secretaria.DAO.MatriculaDAO;
import tcc.secretaria.DAO.PessoaDAO;
import tcc.secretaria.DAO.ProfessorDAO;
import tcc.secretaria.DAO.SecretariaDAO;
import tcc.secretaria.DAO.UsuarioDAO;
import tcc.secretaria.DATA.AdminDATA;
import tcc.secretaria.DATA.AlunoDATA;
import tcc.secretaria.DATA.ConteudoDATA;
import tcc.secretaria.DATA.CursoDATA;
import tcc.secretaria.DATA.DiciplinaDATA;
import tcc.secretaria.DATA.MatriculaDATA;
import tcc.secretaria.DATA.PessoaDATA;
import tcc.secretaria.DATA.ProfessorDATA;
import tcc.secretaria.DATA.SecretariaDATA;
import tcc.secretaria.DATA.UsuarioDATA;
import tcc.secretaria.UTIL.ErroSistema;
import tcc.sercretaria.ENUM.CategoriaENUM;
import tcc.sercretaria.ENUM.TipoENUM;

public class Main {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("SECRE_PU");
    private static final EntityManager em = factory.createEntityManager();

    public Main() {

    }

    public static void main(String[] args) {
        try {
          addConteudo();
          
            System.out.println("DEU CERTO ESTÁ MERDA :");
        } catch (Exception e) {
            System.out.println("ERRO DO CARALHO : " + e);
        }
    }
    
    public static void addConteudo(){
        DiciplinaDAO ddao = new DiciplinaDAO();
        DiciplinaDATA d = ddao.buscaID(2);
        d.getConteudos().add(em.find(ConteudoDATA.class, 1));
        d.getConteudos().add(em.find(ConteudoDATA.class, 3));
        d.getConteudos().add(em.find(ConteudoDATA.class, 5));
        d.getConteudos().add(em.find(ConteudoDATA.class, 7));
        ddao.inserir(d);
    }
    
    public static void addDiciplina(){       
        CursoDATA c = em.find(CursoDATA.class, 8);
//        DiciplinaDATA d = em.find(DiciplinaDATA.class, 3);
        c.getDiciplinas().add(em.find(DiciplinaDATA.class, 1));
        c.getDiciplinas().add(em.find(DiciplinaDATA.class, 3));
        c.getDiciplinas().add(em.find(DiciplinaDATA.class, 4));
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    public static void criarProfessor() {
        ProfessorDAO pdao = new ProfessorDAO();
        ProfessorDATA p = new ProfessorDATA();
        p.setAtivo(Boolean.TRUE);
        p.setSenha("123");
        p.setPessoa(em.find(PessoaDATA.class, 3));
        pdao.inserir(p);
    }

    public static void criarAluno() {
        PessoaDAO pdao = new PessoaDAO();
        PessoaDATA p = pdao.buscarID(6);
        AlunoDAO adao = new AlunoDAO();
        AlunoDATA a = new AlunoDATA();
        a.setAtivo(Boolean.TRUE);
//        a.setEscolaridade("2º Grau");
        a.setSenha("123");
        a.setPessoa(p);

        adao.inserir(a);
    }
    public static void criarAdmin(){
        AdminDAO pdao = new AdminDAO();
        AdminDATA p = new AdminDATA();
        p.setAtivo(Boolean.TRUE);
        p.setSenha("123");
        p.setPessoa(em.find(PessoaDATA.class, 4));
        pdao.inserir(p);
        
    }
    public static void criarSecretaria(){
        SecretariaDAO pdao = new SecretariaDAO();
        SecretariaDATA p = new SecretariaDATA();
        p.setAtivo(Boolean.TRUE);
        p.setSenha("123");
        p.setPessoa(em.find(PessoaDATA.class, 2));
        pdao.inserir(p);
        
    }

    public static void salvarAluno(Integer codigo) {
        PessoaDAO pdao = new PessoaDAO();
        PessoaDATA p = pdao.buscarID(5);
        AlunoDAO adao = new AlunoDAO();
        AlunoDATA a = adao.buscaID(codigo);
        a.setPessoa(p);
        adao.salvar(a);

    }

    public static void criarMatricula() throws ErroSistema {
        MatriculaDAO mdao = new MatriculaDAO();
        MatriculaDATA m = new MatriculaDATA();
        m.setAno(2018);
        m.setAluno(em.find(AlunoDATA.class, 2));
        m.setCurso(em.find(CursoDATA.class, 2));
        
        mdao.inserir(m);
        
    }
    
    public static void criarDiciplina(){
        DiciplinaDAO ddao = new DiciplinaDAO();
        DiciplinaDATA ddata = new DiciplinaDATA();
        
        ddata.setNome("Matematica");
        ddata.setDescricao("Calculos Matematicos");
        ddao.inserir(ddata);
    }

    public static void criarCurso() {
        CursoDAO cdao = new CursoDAO();
        CursoDATA c = new CursoDATA();
        c.setNome("Tecnico em Infermagem");
        c.setDescricao("Corpo Humano");
        cdao.salvar(c);
    }

    public static void listarConteudo() {
        ConteudoDAO cdao = new ConteudoDAO();
        List<ConteudoDATA> lista = cdao.lista();
        for (ConteudoDATA c : lista) {

            System.out.println("TESTE CONTEUDO :" + c.getTitulo());
        }

    }

    public static void criarConteudo() throws ErroSistema {
        ConteudoDAO cdao = new ConteudoDAO();
        ConteudoDATA c = new ConteudoDATA();
        c.setTitulo("PHP com banco de dados");
        c.setDescricao("Criação de Web com linguagem PHP");
        c.setCategoria(CategoriaENUM.VIDEO);
        c.setLink("https://www.google.com.br/search?q");
        cdao.inserir(c);
        
        ConteudoDAO cdao1 = new ConteudoDAO();
        ConteudoDATA c1 = new ConteudoDATA();
        c1.setTitulo("AngulatJS javaScript");
        c1.setDescricao("Criação de Web com linguagem Angular");
        c1.setCategoria(CategoriaENUM.PDF);
        c1.setLink("https://www.google.com.br/search?q");
        cdao1.inserir(c1);
        
        ConteudoDAO cdao2 = new ConteudoDAO();
        ConteudoDATA c2 = new ConteudoDATA();
        c2.setTitulo("JSF com banco de dados");
        c2.setDescricao("Criação de Web com linguagem JSF");
        c2.setCategoria(CategoriaENUM.OFICCE);
        c2.setLink("https://www.google.com.br/search?q");
        cdao2.inserir(c2);
        
        ConteudoDAO cdao3 = new ConteudoDAO();
        ConteudoDATA c3 = new ConteudoDATA();
        c3.setTitulo("JSP com banco de dados");
        c3.setDescricao("Criação de Web com linguagem JSP");
        c3.setCategoria(CategoriaENUM.VIDEO);
        c3.setLink("https://www.google.com.br/search?q");
        cdao3.inserir(c3);
        
        ConteudoDAO cdao4 = new ConteudoDAO();
        ConteudoDATA c4 = new ConteudoDATA();
        c4.setTitulo("AspNet com banco de dados");
        c4.setDescricao("Criação de Web com linguagem AspNet");
        c4.setCategoria(CategoriaENUM.VIDEO);
        c4.setLink("https://www.google.com.br/search?q");
        cdao4.inserir(c4);
    }

    public static void conectar() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SECRE_PU");
        factory.close();
    }

    public static void criarUsuario() throws ErroSistema {

        PessoaDAO pdao = new PessoaDAO();
        PessoaDATA p = pdao.buscarID(2);
        UsuarioDAO udao = new UsuarioDAO();
        UsuarioDATA u = new UsuarioDATA();
        u.setAtivo(Boolean.TRUE);
        u.setPessoa(p);
        u.setSenha("123");

        udao.inserir(u);
    }

    public static void criarPessoa() throws ErroSistema {
        PessoaDAO pdao = new PessoaDAO();
        PessoaDATA p = new PessoaDATA();
        p.setCpf("111.111.111-11");
        p.setCelular("019-98877-6656");
        p.setEmail("eliezer@gmail.com");
        p.setNome("Eliezer");
        p.setTelefone("019-3345-6678");
        pdao.inserir(p);

        PessoaDAO pdao1 = new PessoaDAO();
        PessoaDATA p1 = new PessoaDATA();
        p1.setCpf("222.222.222-22");
        p1.setCelular("019-98877-6656");
        p1.setEmail("lucas@gmail.com");
        p1.setNome("Lucas");
        p1.setTelefone("019-3345-6678");
        pdao1.inserir(p1);

        PessoaDAO pdao2 = new PessoaDAO();
        PessoaDATA p2 = new PessoaDATA();
        p2.setCpf("333.333.333-33");
        p2.setCelular("019-98877-6656");
        p2.setEmail("anderson@gmail.com");
        p2.setNome("Anderson");
        p2.setTelefone("019-3345-6678");
        pdao2.inserir(p2);

        PessoaDAO pdao3 = new PessoaDAO();
        PessoaDATA p3 = new PessoaDATA();
        p3.setCpf("555.555.555-55");
        p3.setCelular("019-98877-6656");
        p3.setEmail("admin@gmail.com");
        p3.setNome("Admin");
        p3.setTelefone("019-3345-6678");
        pdao3.inserir(p3);

        PessoaDAO pdao4 = new PessoaDAO();
        PessoaDATA p4 = new PessoaDATA();
        p4.setCpf("666.666.666-66");
        p4.setCelular("019-98877-6656");
        p4.setEmail("bruna@gmail.com");
        p4.setNome("Bruna");
        p4.setTelefone("019-3345-6678");
        pdao4.inserir(p4);

    }

}
