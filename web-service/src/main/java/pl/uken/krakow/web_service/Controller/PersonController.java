package pl.uken.krakow.web_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.uken.krakow.web_service.Model.Person;
import pl.uken.krakow.web_service.Repository.PersonRepository;

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
            return "redirect:list";
        }
        model.addAttribute("person", personRepository.getPerson(id));
        return "del_person";
    }
}
