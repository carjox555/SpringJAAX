package com.jaax.restFulApi.persistance.repository;

import com.jaax.restFulApi.persistance.entity.Local;
import com.jaax.restFulApi.persistance.entity.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LocalRepositoryTest {
    @Autowired
    private LocalRepository localRepository;

    @Test
    public void saveLocal(){
        Manager manager =Manager.builder()
                .firstName("Jox")
                .lastName("Berro")
                .build();

    Local local =Local.builder()
            .name("Pet")
            .floor("Second")
            .manager(manager)
            .build();
    localRepository.save(local);
}
@Test
    public void findAllLocals(){
        List<Local> localList=localRepository.findAll();
    System.out.println("lista"+ localList);
}
}