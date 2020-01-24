package com.invillia.account.service.serviceImp;

import br.com.caelum.stella.validation.CPFValidator;
import com.invillia.account.entity.Person;
import com.invillia.account.entity.request.PersonRequest;
import com.invillia.account.entity.request.PersonSaveRequest;
import com.invillia.account.entity.request.PersonUpdateRequest;
import com.invillia.account.entity.response.PersonResponse;
import com.invillia.account.exceptions.CpfNotValidException;
import com.invillia.account.exceptions.PersonNotFoundException;
import com.invillia.account.mapper.PersonMapper;
import com.invillia.account.repository.PersonRepository;
import com.invillia.account.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonServiceImp implements PersonService {

  private final PersonRepository personRepository;
  private final PersonMapper personMapper;

  @Autowired
  public PersonServiceImp(PersonRepository personRepository, PersonMapper personMapper) {
    this.personRepository = personRepository;
    this.personMapper = personMapper;
  }


  @Transactional(readOnly = true)
  public List<PersonResponse> findAll(final PersonRequest personRequest) {
    return personRepository.findAll().stream()
            .map(personMapper::personToPersonResponse)
            .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public PersonResponse findById(final Long id) {
    return personRepository.findById(id)
            .map(personMapper::personToPersonResponse)
            .orElseThrow(() -> new PersonNotFoundException("Pessoad com Id " + id + " não encontrado"));
  }

  @Transactional
  public void update(final Long id,final PersonUpdateRequest personUpdateRequest) {
    final  Person person = personRepository.findById(id)
            .orElseThrow(() -> new PersonNotFoundException("Pessoad com Id " + id + " não encontrado"));

    if(!person.getCpf().equals(personUpdateRequest.getCpf())){
      if(!validateCPF(personUpdateRequest.getCpf())){
        throw new CpfNotValidException("CPF Inválido!", HttpStatus.BAD_REQUEST);
      }else {
        if(personRepository.existsByCpf(personUpdateRequest.getCpf())){
          throw new CpfNotValidException("CPF Já Cadastrado!", HttpStatus.CONFLICT);
        }
      }
    }
    personMapper.updatePersonByPersonRequest(person, personUpdateRequest);

    personRepository.save(person);
  }

  @Transactional
  public void delete(final Long id) {
    final  Person person = personRepository.findById(id)
            .orElseThrow(() -> new PersonNotFoundException("Pessoad com Id " + id + " não encontrado"));

    personRepository.delete(person);
  }



  @Transactional
  public Long create(final PersonSaveRequest personSaveRequest) {
    if(!validateCPF(personSaveRequest.getCpf())){
      throw new CpfNotValidException("CPF Inválido", HttpStatus.BAD_REQUEST);
    }
    if(personRepository.existsByCpf(personSaveRequest.getCpf())){
      throw new CpfNotValidException("CPF Já Cadastrado", HttpStatus.CONFLICT);

    }
    Person person = personMapper.personSaveRequestToPerson(personSaveRequest);
    personRepository.save(person);
    return person.getId();
  }

  private boolean validateCPF(final String cpf){
    CPFValidator cpfValidator = new CPFValidator();

    try {
      cpfValidator.assertValid(cpf);
      return true;
    }catch (Exception e){
      return false;
    }
  }
}
