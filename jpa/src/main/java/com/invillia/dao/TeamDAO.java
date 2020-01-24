package com.invillia.dao;

import com.invillia.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class TeamDAO {

    private final EntityManager entityManager;

    public TeamDAO(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(final Team team){
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(team);
        transaction.commit();

    }

    public List<Team> findAll(){
        final TypedQuery<Team> team = entityManager.createQuery(
                "from Team",
                Team.class
        );
        return team.getResultList();
    }

    public Team findById(final Long id){
        return entityManager.find(Team.class, id);
    }

    public void update(final Team team){
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(team);
        transaction.commit();
    }

    public void deleteFromId(final Long id){
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        final Team team = findById(id);
        entityManager.remove(team);
        transaction.commit();
    }
}
