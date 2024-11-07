package pl.uken.krakow.rest_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.uken.krakow.rest_service.Model.Person;

public interface RestPersonRepository extends JpaRepository<Person, Long> {
}