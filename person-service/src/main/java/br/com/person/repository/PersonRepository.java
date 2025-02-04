package br.com.person.repository;

import br.com.person.entity.Person;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
    // ... custom queries and methods ...
}
