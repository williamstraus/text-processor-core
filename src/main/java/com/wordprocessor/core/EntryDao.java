package com.wordprocessor.core;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public class EntryDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public EntryDTO getEntryForId(UUID id) {

        TypedQuery<EntryDTO> query = em.createQuery(
                "select e from EntryDTO e where e.id = :id",
                EntryDTO.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

}
