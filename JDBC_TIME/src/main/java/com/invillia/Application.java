package com.invillia;

public class Application {
    public static void main(String[] args) {
        final TeamDAO teamDAO = new TeamDAO();

        System.out.println(teamDAO.findAll());

        teamDAO.findById(4L)
                .ifPresent(System.out::println);

        teamDAO.insert(new Team ((long) 2, "invillia"));

        teamDAO.findById(4L)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("nao encontrado")
                );

    }

}
