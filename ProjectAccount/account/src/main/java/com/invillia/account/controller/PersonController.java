package com.invillia.account.controller;

import com.invillia.account.entity.request.PersonRequest;
import com.invillia.account.entity.request.PersonSaveRequest;
import com.invillia.account.entity.request.PersonUpdateRequest;
import com.invillia.account.entity.response.PersonResponse;
import com.invillia.account.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping
  public ResponseEntity findAll(
          @RequestParam(value = "name", required = false) String name,
          @RequestParam(value = "cpf", required = false) String cpf
  ) {
    PersonRequest personRequest = new PersonRequest();
    personRequest.setName(name);
    personRequest.setCpf(cpf);

    List<PersonResponse> customerResponseList = personService.findAll(personRequest);
    return ResponseEntity.ok(customerResponseList);
  }

  @GetMapping("/{id}")
  public ResponseEntity findById(@PathVariable final Long id) {
    PersonResponse personResponse = personService.findById(id);
    return ResponseEntity.ok(personResponse);
  }


  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable final Long id) {
    personService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@Valid @PathVariable final Long id,
                               @Valid @RequestBody final PersonUpdateRequest personUpdateRequest) {

    personService.update(id, personUpdateRequest);
    return ResponseEntity.noContent().build();
  }

  @PostMapping
  public ResponseEntity save(@Valid @RequestBody final PersonSaveRequest personSaveRequest) {

    Long idPerson = personService.create(personSaveRequest);

    final URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/person/{id}")
            .build(idPerson);
    return ResponseEntity.created(location).build();
  }
}
