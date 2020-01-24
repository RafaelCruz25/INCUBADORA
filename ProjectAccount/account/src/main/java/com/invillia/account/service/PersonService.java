package com.invillia.account.service;

import com.invillia.account.entity.request.PersonRequest;
import com.invillia.account.entity.request.PersonSaveRequest;
import com.invillia.account.entity.request.PersonUpdateRequest;
import com.invillia.account.entity.response.PersonResponse;

import java.util.List;


public interface PersonService {

  List<PersonResponse> findAll(final PersonRequest personRequest);

  PersonResponse findById(final Long id);

  void update(final Long id, final PersonUpdateRequest personUpdateRequest);

  void delete(final Long id);

  Long create(final PersonSaveRequest personSaveRequest);
}
