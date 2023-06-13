package com.jaax.restFulApi.persistance.service;

import com.jaax.restFulApi.error.LocalNotFoundException;
import com.jaax.restFulApi.persistance.entity.Local;

import java.util.List;
import java.util.Optional;

public interface IntLocalService {
    List<Local>findAllLocals();
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    void deleteLocal(Long id);
    Optional<Local> findLocalByNameWithJPQL(String name);
    Optional<Local>findByName(String name);
    Local findLocalById(Long id)throws LocalNotFoundException;

    }

