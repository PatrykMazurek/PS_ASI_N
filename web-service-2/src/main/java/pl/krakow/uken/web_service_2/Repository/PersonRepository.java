package pl.krakow.uken.web_service_2.Repository;

import java.util.List;

import pl.krakow.uken.web_service_2.Model.Person;

public interface PersonRepository {
    
    int countPerson();
    int save(Person person);
    int update(Person person);
    int deleteById(int id);
    Person getPerson(int id);
    List<Person> findAll();
    // i wiele więcej w zależności od wymogów wyszukiwania lub zapisu danych


}
