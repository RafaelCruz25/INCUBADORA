package com.invillia;

public class Application {
    public static void main(String[] args) {
        final MembersDAO membersDAO = new MembersDAO();

        System.out.println(membersDAO.findAll());

        //membersDAO.insert(new Members((long) 2, "invillia"));

        //membersDAO.deleteById((long) 5);

        //System.out.println(membersDAO);
    }
}
