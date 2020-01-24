package com.invillia;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class MembersDAO {

    private final DataSource dataSource;

    public MembersDAO(){

        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("incubadora");
        dataSource.setPassword("123123");
        dataSource.setDatabaseName("incubadora");
        this.dataSource = dataSource;
    }

    public void insert(final Members members){
        try(
                final Connection connection = dataSource.getConnection();
                final PreparedStatement stmt = connection.prepareStatement(
                        "insert into members (name) values (?)"
                );
                ){
            stmt.setString(1, members.getName());
            stmt.executeUpdate();
        }catch (SQLException e){
            System.err.println("ALGO DE ERRADO NAO ESTA CERTO!");
            throw new RuntimeException(e);
        }
    }

    public List<Members> findAll(){
        try (
                final Connection connection = dataSource.getConnection();
                final Statement stmt = connection.createStatement();
                final ResultSet rs = stmt.executeQuery("select id, name from members")
                ){
                final List<Members> member = new ArrayList<>();

                while(rs.next()){
                    final Members members = new Members(
                            rs.getLong("id"),
                            rs.getString("name")
                    );
                    member.add(members);
                }
                return member;
        }
        catch (SQLException e){
            System.err.println("ALGO DE ERRADO NAO ESTA CERTO!");
            throw new RuntimeException(e);
        }
    }

    public void update(final Long id, final UpdateMembersRequest updateMembersRequest){
        try(
                final Connection connection = dataSource.getConnection();
                final PreparedStatement stmt = connection.prepareStatement(
                        "update members set name = ? where id = ?"
                )
                ){
            stmt.setString(1,updateMembersRequest.getName());
            stmt.setLong(2,id);
            stmt.executeUpdate();
        }
        catch (SQLException e ){
            System.err.println("ALGO DE ERRADO NAO ESTA CERTO!");
            throw new RuntimeException(e);
        }
    }

    public void deleteById(final Long id){
        try(
                final Connection connection = dataSource.getConnection();
                final PreparedStatement stmt = connection.prepareStatement(
                        "delete from members where id = ?"
                )
                ){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            System.err.println("ALGO DE ERRADO NAO ESTA CERTO!");
            throw new RuntimeException(e);
        }
    }
}
