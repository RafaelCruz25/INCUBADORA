package com.invillia.repository;

import com.invillia.account.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class AccountDAOImpl implements AccountDAO {

    private final EntityManager entityManager;

    public AccountDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Account findById(Long id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public List<Account> findAll() {
        final TypedQuery<Account> account = entityManager.createQuery(
                "FROM Account",
                Account.class
        );
        return account.getResultList();
    }

    @Override
    public void insert(final Account account) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(account);
        transaction.commit();
    }

    @Override
    public void update(final Account account) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(account);
        transaction.commit();
    }


    @Override
    public void removeById(Long id) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        final Account account = findById(id);
        entityManager.remove(account);
        transaction.commit();
    }
}
