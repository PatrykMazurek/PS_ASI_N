package pl.krakow.uken.web_service_2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.krakow.uken.web_service_2.Model.Member;
import pl.krakow.uken.web_service_2.Model.Person;
import pl.krakow.uken.web_service_2.Repository.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/")
    public String homeView(Model model){
        return "index";
    }

    @GetMapping("/new")
    public String newPersonView(Model model){
        model.addAttribute("person", new Person());
        return "new_person";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute("person") Person p, 
                            BindingResult bindResult){
        if (bindResult.hasErrors()){
            return "new_person";
        }        
        personRepository.save(p);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String listAllPersonView(Model model){
        model.addAttribute("persons", personRepository.findAll());
        return "list";
    }

    @GetMapping("/del")
    public String deletePersonView(@RequestParam("id") int id, 
                                    @RequestParam(name="action", defaultValue="false") boolean action, 
                                    Model model){
        if (action){
            System.out.println("id:"+id+" action:"+action);
            personRepository.deleteById(id);
            return "redirect:localhost:8080/person/list";
        }
        model.addAttribute("person", personRepository.getPerson(id));
        return "del_person";
    }

    @GetMapping("/poslowie")
    public String poslowieView(Model model){
        String url = "https://api.sejm.gov.pl/sejm/term10/MP";
        RestTemplate rest = new RestTemplate();
        String result = rest.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        Member[] members = null;
        System.out.println(result);
        try {
            members = mapper.readValue(result, Member[].class);
            System.out.println(members[0].getClub());
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("members", members);
        return "list_poslowie";
    }
}
