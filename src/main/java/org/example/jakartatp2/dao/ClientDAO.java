package org.example.jakartatp2.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.jakartatp2.entities.Client;

import java.util.List;

@ApplicationScoped
public class ClientDAO {

    @PersistenceContext(unitName = "clients")
    private EntityManager em;

    // create
    @Transactional
    public void create(Client client) {
        em.persist(client);
    }

    // find by id
    public Client find(Long id) {
        return em.find(Client.class, id);
    }

    // find all
    public List<Client> findAll() {
        return em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    // update
    @Transactional
    public void update(Client client) {
        em.merge(client);
    }

    // delete
    @Transactional
    public void delete(Long id) {
        Client c = find(id);
        if (c != null) {
            // em.remove requires managed entity
            if (!em.contains(c)) {
                c = em.merge(c);
            }
            em.remove(c);
        }
    }
}
