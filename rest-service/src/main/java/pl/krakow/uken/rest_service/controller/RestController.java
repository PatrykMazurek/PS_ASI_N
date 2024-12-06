package pl.krakow.uken.rest_service.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.krakow.uken.rest_service.model.Person;
import pl.krakow.uken.rest_service.service.RestPersonService;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("api/v1/")
public class RestController {
    
    @Autowired
    private RestPersonService restService;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> listAllperson(){
        return ResponseEntity.ok().body(restService.getAllPerson());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id")int id ){
        return ResponseEntity.ok().body(restService.getPerson(id));
    }

    @PostMapping("/add")
    public ResponseEntity<String> savePerson(
                                @RequestHeader("api-key") String key,
                                @RequestBody Person person){
        if (restService.checkPersonByToken(key)){
            System.out.println(person.getFirstName());
            person.setCreated_at(LocalDateTime.now());
            person.setUpdated_at(LocalDateTime.now());
            Person p = restService.savePerson(person);
            if (p != null){
                return ResponseEntity.ok().body("akcept");
            }else{
                return ResponseEntity.ok().body("not akcept");
            }    
        }
        return ResponseEntity.ok().body("not akcept");
    }
}