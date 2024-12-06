package pl.uken.krakow.rest_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.uken.krakow.rest_service.Model.Person;
import pl.uken.krakow.rest_service.Repository.RestPersonRepository;

@Service
public class RestPersonService {

    @Autowired
    RestPersonRepository repository;

    public List<Person> getAllPerson(){
        return repository.findAll();
    }

    public Person getPerson(int id){
        Person person = repository.findById((long)id).orElse(null);
        return person;
    }

    public Person savePerson(Person person){
        return repository.save(person);
    }

    public boolean findPerson(String token){
        return repository.checkPersonByToken(token);
    }
    
}
