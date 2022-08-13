package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDao {

    @Autowired
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void createUser(User user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public User readUser(int id) {
        User u = em.find(User.class, id);
        return u;
    }

    @Transactional
    @Override
    public void updateUser(int id, String name, String lastname, int age) {
        User u = em.find(User.class, id);
        u.setName(name);
        u.setLastName(lastname);
        u.setAge(age);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        em.remove(em.find(User.class, id));
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}
