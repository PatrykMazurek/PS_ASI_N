package pl.krakow.uken.rest_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.krakow.uken.rest_service.model.Person;
import pl.krakow.uken.rest_service.repository.RestPersonRepository;

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
        // return repository.checkPersonByToken(token);
        throw new UnsupportedOperationException("Unimplemented method 'checkPersonByToken'");
    }

    public boolean checkPersonByToken(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkPersonByToken'");
    }
    
}
