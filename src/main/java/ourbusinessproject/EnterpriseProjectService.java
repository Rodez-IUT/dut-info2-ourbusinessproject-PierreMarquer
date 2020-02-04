package ourbusinessproject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
