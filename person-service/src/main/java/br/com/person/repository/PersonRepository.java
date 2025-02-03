package br.com.person.repository;

import br.com.person.entity.Person;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

import static org.jboss.resteasy.reactive.RestResponse.Status.CREATED;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
    // ... custom queries and methods ...
}
