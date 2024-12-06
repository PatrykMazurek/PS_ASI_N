package pl.krakow.uken.web_service_2.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    int id;
    String firstName;
    String secondName;
    String lastName;
    String firstLastName;
    String lastFirstName;
    String accusativeName;
    String genitiveName;
    boolean active;
    String email;
    String club;
    String birthDate;
    String birthLocation;
    String profession;
    String districtName;
    int districtNum;
    String educationLevel;
    int numberOfVotes;
    String voivodeship;
    
}
