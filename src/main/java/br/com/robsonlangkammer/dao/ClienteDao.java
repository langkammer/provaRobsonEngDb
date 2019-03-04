//package br.com.robsonlangkammer.dao;
//
//import br.com.robsonlangkammer.model.Cliente;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//@Transactional
//public class ClienteDao {
//
//    @PersistenceContext
//    private EntityManager manager;
//
//
//    public List<Cliente> listar() {
//        return manager.createQuery("select distinct(p) from Cliente p join fetch p.vendedor", Cliente.class)
//                .getResultList();
//    }
//}
