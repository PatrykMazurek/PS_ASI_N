package pl.uken.krakow.web_service.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    String accusativeName; 
    boolean active;
    String birthDate;
    String birthLocation;
    String club;
    String districtName;
    int districtNum;
    String educationLevel;
    String email;
    String firstLastName;
    String firstName;
    String genitiveName;
    int id;
    String lastFirstName;
    String lastName;
    int numberOfVotes;
    String profession;
    String secondName;
    String voivodeship;
    
}
