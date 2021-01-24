package entities;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PersonController {
    private final PersonRepository repository;
    private final PersonModelAssembler assembler;

    PersonController(PersonRepository repository,
                     PersonModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/people")
    CollectionModel<EntityModel<Person>> getAll() {
        List<EntityModel<Person>> people = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(people,
                linkTo(methodOn(PersonController.class).getAll()).withSelfRel());
    }

    @PostMapping("/people")
    ResponseEntity<?> addPerson(@RequestBody Person person) {
        EntityModel<Person> entityModel = assembler.toModel(repository.save(person));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @GetMapping("/people/{id}")
    EntityModel<Person> getById(@PathVariable Long id) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        return assembler.toModel(person);
    }

    @DeleteMapping("/people/{id}")
    ResponseEntity<?> deletePersonById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // ============================================ //
    @RequestMapping
    public String mainPage() {
        return "Hello, this is the main page of a app!";
    }
    @RequestMapping("/hello")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "Noname") String name) {
        return "Hello, it's Spring! \nHow are you, " + name + "?";
    }
}
