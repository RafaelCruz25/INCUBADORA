package com.invillia.account.mapper;

import com.invillia.account.entity.Person;
import com.invillia.account.entity.request.PersonSaveRequest;
import com.invillia.account.entity.request.PersonUpdateRequest;
import com.invillia.account.entity.response.PersonResponse;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

  public PersonResponse personToPersonResponse(final Person person){
    return PersonResponse.builder()
            .id(person.getId())
            .cpf(person.getCpf())
            .name(person.getName())
            .accountList(person.getAccountList())
            .createdAt(person.getCreatedAt().format(formatter))
            .updatedAt(person.getUpdatedAt().format(formatter))
            .build();
  }

  public List<PersonResponse> personToPersonResponse(final List<Person> personList){
    return personList.stream()
            .map(this::personToPersonResponse)
            .collect(Collectors.toList());
  }

  public Person personSaveRequestToPerson(final PersonSaveRequest personSaveRequest){
    Person person = new Person();
    person.setCpf(personSaveRequest.getCpf());
    person.setName(personSaveRequest.getName());

    return person;
  }

  public void updatePersonByPersonRequest(final Person person, final PersonUpdateRequest personUpdateRequest){
    person.setName(personUpdateRequest.getName());
    person.setCpf(personUpdateRequest.getCpf());
  }
}
