package pl.uken.krakow.rest_service.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="person")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    
    @Id
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="age")
    private int age;
    @Column(name="city")
    private String city;
    @Column(name="created_at")
    private LocalDateTime created_at;
    @Column(name="updated_at")
    private LocalDateTime updated_at;
}
