package com.invillia;

import com.invillia.dao.MemberDAO;
import com.invillia.dao.TeamDAO;
import com.invillia.domain.Member;
import com.invillia.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("incubaria");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();


    System.out.println("-----------------------------------------");
        final TeamDAO teamDAO = new TeamDAO(entityManager);
        final MemberDAO memberDAO = new MemberDAO(entityManager);

       /* memberDAO.insert(new Member(
              "Rafael Cruz 2",
                teamDAO.findById(1L)
        ));*/

        /*  teamDAO.insert(new Team(
                "IsaTeam"
        ));

        System.out.println(teamDAO.findAll());
        final Team team = teamDAO.findById(1L);
        System.out.println(team);

        team.setName("Incubadora 2");
        teamDAO.update(team);

        System.out.println(teamDAO.findById(1L));*/

        //teamDAO.deleteFromId(1L);

        memberDAO.deleteFromId(1L);
    }
}
