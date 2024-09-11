package MenuLogin;



import MenuLogin.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class SistemaBd {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema-saudePU"); // Cria um entity manager factory
        EntityManager em = emf.createEntityManager(); // Cria um entity manager
        Login telaInicial = new Login(em);  // Cria a tela de login
        telaInicial.setVisible(true);
    }
}
