package com.invillia.application;


import com.invillia.dao.AccountDAO;
import com.invillia.entities.Account;
import com.invillia.entities.TypeAccount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("account");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("------===============================================------");

        AccountDAO accountDAO = new AccountDAO(entityManager);
        Account account = new Account();

//        BUSCAR PELO ID DO CLIENTE QUE DESEJA FAZER O DEPOSITO OU SAQUE
//        account = accountDAO.findById(19L);
//        Double balance = account.getBalance();


//        DEPOSITAR E ATUALIZAR A CONTA
//           account.deposit(2300.0);
//            accountDAO.update(account);

//        SACAR E ATUALIZAR A CONTA
//          account.withdraw(2300.0);
//          accountDAO.update(account);


        //INSERIR NOVO CLIENTE
//        accountDAO.insert(new Account("Teste 2",
//                0.0,
//                TypeAccount.CHECKINGACCOUNT
//                ));

        //PESQUISAR TODOS OS CADASTRADOS
//        System.out.println(accountDAO.findAll());

        //DELETAR CLIENTE PELO ID
//        accountDAO.deleteFromId(12L);

        //PESQUISAR PELO ID
//        System.out.println(accountDAO.findById(12L));

    }
}
