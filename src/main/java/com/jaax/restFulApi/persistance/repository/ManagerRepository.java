package com.jaax.restFulApi.persistance.repository;

import com.jaax.restFulApi.persistance.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
