package com.jaax.restFulApi.contoller;

import com.jaax.restFulApi.error.LocalNotFoundException;
import com.jaax.restFulApi.persistance.entity.Local;
import com.jaax.restFulApi.persistance.repository.LocalRepository;
import com.jaax.restFulApi.persistance.service.IntLocalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class LocalController {
    @Autowired
    IntLocalService intLocalService;
    @Autowired
    private LocalRepository localRepository;

    @GetMapping()
    public List<Local> findAllLocals(){
        return intLocalService.findAllLocals();
    }

    @GetMapping("/findLocalById/{id}")
    Local findLocalById(@PathVariable Long id) throws LocalNotFoundException {
        return intLocalService.findLocalById(id);
    }

    @GetMapping("/findName/{name}")
    Optional<Local> findByName(@RequestBody String name){
        return intLocalService.findByName(name);
    }

    @PostMapping("/saveLocal")
    public Local saveLocal(@Valid @RequestBody Local local){
        return intLocalService.saveLocal(local);
    }

    @PutMapping("/{id}")
    public Local updateLocal(@PathVariable Long id, @RequestBody Local local){
        return intLocalService.updateLocal(id, local);

    }
    @DeleteMapping("/delete/{id}")
    public String deleteLocal(@PathVariable long id){
        intLocalService.deleteLocal(id);
        return "Succes deleted";
    }
    @GetMapping("/withName/{name}")
    Optional<Local>findLocalByNameWithNameJPQL(@PathVariable String name){
        return intLocalService.findLocalByNameWithJPQL(name);
    }
}
