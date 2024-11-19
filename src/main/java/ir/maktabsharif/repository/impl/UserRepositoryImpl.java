package ir.maktabsharif.repository.impl;

import ir.maktabsharif.exception.GenerallyNotFoundException;
import ir.maktabsharif.model.Members;
import ir.maktabsharif.model.Users;
import ir.maktabsharif.repository.UsersRepository;
import ir.maktabsharif.util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UsersRepository {
    public UserRepositoryImpl() {

    }

    @Override
    public Optional<Members> findById(Long id) {
        return Optional.ofNullable(EntityManagerProvider.getEntityManager().find(Members.class, id));
    }

    @Override
    public List<Members> getAll() {
        return EntityManagerProvider.getEntityManager().createQuery("SELECT m FROM Members m", Members.class).getResultList();
    }

    @Override
    public void saveOrUpdate(Members object)  {
        if (object.getId() == null) {
            persist(object);
        } else update(object);
    }

    @Override
    public void delete(Long id)  {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Members course = entityManager.find(Members.class, id);
        try {
            transaction.begin();
            entityManager.remove(course);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }
    public void persist(Members entity) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    //--------------------------------------------------
    public void update(Members entity) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            Optional<Members> foundedCourse = this.findById(entity.getId());
            if (!foundedCourse.isPresent()) {
                throw new GenerallyNotFoundException("User not found");
            }
            transaction.begin();
            foundedCourse.get().setTasks(entity.getTasks());
            foundedCourse.get().setPassword(entity.getPassword());
            foundedCourse.get().setUsername(entity.getUsername());
            foundedCourse.get().setRole(entity.getRole());
            entityManager.persist(foundedCourse);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

    }

    @Override
    public Optional<Users> login(String username, String password) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        TypedQuery<Users> query = entityManager.createNamedQuery("User.findByUsernameAndPassword", Users.class);
        query.setParameter(1, username);
        query.setParameter(2, password);
        return Optional.ofNullable(query.getSingleResult());
    }
}
