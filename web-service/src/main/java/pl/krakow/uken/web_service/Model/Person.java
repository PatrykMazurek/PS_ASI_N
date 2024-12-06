package pl.krakow.uken.web_service.Model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("person")
public class Person {
    @Id
    @Column("id")
    private int id;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("age")
    private int age;
    @Column("city")
    private String city;
    @Column("created_at")
    private LocalDateTime created_at;
    @Column("updated_at")
    private LocalDateTime updated_at;
}
