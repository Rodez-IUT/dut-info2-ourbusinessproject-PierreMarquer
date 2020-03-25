package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Object aSave) {
        this.entityManager.persist(aSave);
        this.entityManager.flush();
    }

    public Project findProjectById(Long anId) {
        return this.entityManager.find(Project.class,anId);
    }

    public Enterprise findEnterpriseById(Long anId) {
        return this.entityManager.find(Enterprise.class,anId);
    }

    public List<Project> findAllProjects() {
        return this.entityManager.createQuery("SELECT p FROM Project p ORDER BY p.title", Project.class).getResultList();
    }
}
