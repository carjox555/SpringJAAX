package com.jaax.restFulApi.persistance.repository;

import com.jaax.restFulApi.persistance.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocalRepository extends JpaRepository<Local, Long> {
    //consulta con jpql
    @Query("SELECT l FROM Local l WHERE l.name= :name")
    Optional<Local> findLocalByNameWithJPQL(String name);

    Optional<Local> findByName(String name);

}
