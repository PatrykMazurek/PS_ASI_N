package pl.uken.krakow.rest_service.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.uken.krakow.rest_service.Model.Person;
import pl.uken.krakow.rest_service.Service.RestPersonService;


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
    public ResponseEntity<String> savePerson(@RequestBody Person person){
        System.out.println(person.getFirstName());
        person.setCreated_at(LocalDateTime.now());
        person.setUpdated_at(LocalDateTime.now());
        Person p = restService.savePerson(person);
        if (p != null){
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        }else{
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }
}