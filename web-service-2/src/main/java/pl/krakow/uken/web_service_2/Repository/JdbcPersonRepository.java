package pl.krakow.uken.web_service_2.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pl.krakow.uken.web_service_2.Model.Person;

@Repository
public class JdbcPersonRepository implements PersonRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public int countPerson() {
        return jdbc.queryForObject("SELECT COUNT(*) FROM person", Integer.class);
    }

    @Override
    public int save(Person person) {
        return jdbc.update(
            "INSERT INTO person (first_name, last_name, city, age) VALUES (?,?,?,?)", 
            person.getFirstName(), person.getLastName(), person.getCity(), person.getAge());
    }

    @Override
    public int update(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int deleteById(int id) {
        return jdbc.update("DELETE FROM person WHERE id = ?", id);
    }

    @Override
    public Person getPerson(int id){
        return jdbc.queryForObject("SELECT * FROM person WHERE id = ?",
                    (rs, rowNum) -> new Person(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getString("city"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                    ), id);
    }

    @Override
    public List<Person> findAll() {
        return jdbc.query("SELECT * FROM person", 
            (rs, rowNum) -> new Person(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("age"),
                rs.getString("city"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                rs.getTimestamp("updated_at").toLocalDateTime()
            ));
    }
}
