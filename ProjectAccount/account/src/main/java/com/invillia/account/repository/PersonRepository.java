package com.invillia.account.repository;

import com.invillia.account.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  boolean existsByCpf(final String cpf);
}
