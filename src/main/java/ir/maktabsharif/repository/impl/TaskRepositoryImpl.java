package ir.maktabsharif.repository.impl;

import ir.maktabsharif.exception.GenerallyNotFoundException;
import ir.maktabsharif.model.Admin;
import ir.maktabsharif.model.Task;
import ir.maktabsharif.repository.TaskRepository;
import ir.maktabsharif.util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class TaskRepositoryImpl implements TaskRepository {
    @Override
    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(EntityManagerProvider.getEntityManager().find(Task.class, id));
    }

    @Override
    public List<Task> getAll() {
        return EntityManagerProvider.getEntityManager().createQuery("from Task ", Task.class).getResultList();
    }

    @Override
    public void saveOrUpdate(Task object) {
        if (object.getId() == null) {
            persist(object);
        } else update(object);

    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Task task = entityManager.find(Task.class, id);
        try {
            transaction.begin();
            entityManager.remove(task);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    public void persist(Task entity) {
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
    public void update(Task entity) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

}
//     try {
//Optional<Task> foundedCourse = this.findById(entity.getId());
//            if (!foundedCourse.isPresent()) {
//        throw new GenerallyNotFoundException("Task not found");
//            }
//                    transaction.begin();
//            foundedCourse.get().setTitle(entity.getTitle());
//        foundedCourse.get().setDescription(entity.getDescription());
//        foundedCourse.get().setAdmin(entity.getAdmin());
//        foundedCourse.get().setSolution(entity.getSolution());
//        foundedCourse.get().setCreateDate(entity.getCreateDate());
//        foundedCourse.get().setDeadLine(entity.getDeadLine());
//        foundedCourse.get().setTaskStates(entity.getTaskStates());
//        foundedCourse.get().setUser(entity.getUser());
//        entityManager.persist(foundedCourse);
//            transaction.commit();

