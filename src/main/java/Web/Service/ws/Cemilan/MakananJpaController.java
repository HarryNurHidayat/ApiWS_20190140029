/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web.Service.ws.Cemilan;

import Web.Service.ws.Cemilan.exceptions.NonexistentEntityException;
import Web.Service.ws.Cemilan.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author harry
 */
public class MakananJpaController implements Serializable {

    public MakananJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Web.Service_ws.Cemilan_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public MakananJpaController() {
    }
    
    

    public void create(Makanan makanan) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(makanan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMakanan(makanan.getId()) != null) {
                throw new PreexistingEntityException("Makanan " + makanan + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Makanan makanan) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            makanan = em.merge(makanan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = makanan.getId();
                if (findMakanan(id) == null) {
                    throw new NonexistentEntityException("The makanan with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Makanan makanan;
            try {
                makanan = em.getReference(Makanan.class, id);
                makanan.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The makanan with id " + id + " no longer exists.", enfe);
            }
            em.remove(makanan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Makanan> findMakananEntities() {
        return findMakananEntities(true, -1, -1);
    }

    public List<Makanan> findMakananEntities(int maxResults, int firstResult) {
        return findMakananEntities(false, maxResults, firstResult);
    }

    private List<Makanan> findMakananEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Makanan.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Makanan findMakanan(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Makanan.class, id);
        } finally {
            em.close();
        }
    }

    public int getMakananCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Makanan> rt = cq.from(Makanan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
