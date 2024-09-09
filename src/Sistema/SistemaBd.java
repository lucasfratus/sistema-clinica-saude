package Sistema;

import Menu.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class SistemaBd {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema-saudePU");
        EntityManager em = emf.createEntityManager();
        Login telaInicial = new Login(em);
        telaInicial.setVisible(true);
    }
    
}
