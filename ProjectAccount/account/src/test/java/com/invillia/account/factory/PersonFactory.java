package com.invillia.account.factory;

import br.com.leonardoferreira.jbacon.JBacon;
import com.invillia.account.entity.Person;
import com.invillia.account.repository.PersonRepository;
import org.springframework.stereotype.Component;

@Component
public class PersonFactory  extends JBacon<Person> {

  private final PersonRepository personRepository;

  public PersonFactory(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  protected Person getDefault() {

    return Person
            .builder()
            .cpf("415.421.168-48")
            .name("Rafael Cruz")
            .build();
  }

  @Override
  protected Person getEmpty() {
    return new Person();
  }

  @Override
  protected void persist(Person person) {
    personRepository.save(person);
  }
}
