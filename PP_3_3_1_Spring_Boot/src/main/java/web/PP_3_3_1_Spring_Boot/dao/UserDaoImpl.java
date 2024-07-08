package web.PP_3_3_1_Spring_Boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import web.PP_3_3_1_Spring_Boot.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public void newUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user, Long id) {
        Query query = entityManager.createQuery("UPDATE User u SET u.name = :name, u.age = :age, u.email = :email WHERE u.id = :id");

        query.setParameter("name", user.getName() );
        query.setParameter("age", user.getAge() );
        query.setParameter("email", user.getEmail() );
        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public void deleteUser(Long id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
