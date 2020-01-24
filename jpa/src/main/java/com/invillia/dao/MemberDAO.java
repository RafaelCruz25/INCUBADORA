package com.invillia.dao;

import com.invillia.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class MemberDAO {
    private final EntityManager entityManager;


    public MemberDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(final Member member){
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(member);
        transaction.commit();
    }

    public List<Member> findAll(){
        final TypedQuery<Member> member = entityManager.createQuery(
                "SELECT m FROM Member m JOIN FETCH m.team",
                Member.class
        );
        return member.getResultList();
    }

    public Member findById(final Long id){
        return entityManager.find(Member.class, id);
    }

    public void update(final Member member){
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(member);
        transaction.commit();
    }

    public void deleteFromId(final Long id){
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        final Member member = findById(id);
        entityManager.remove(member);
        transaction.commit();
    }

    public List<Member> findAllByTeamId(final Long idTeam){
        final TypedQuery<Member> member = entityManager.createQuery(
                "SELECT m FROM Member m JOIN FETCH m.team t where t.id = :idTeam",
                Member.class
        );

        member.setParameter("idTeam", idTeam);
        return member.getResultList();
    }
}
