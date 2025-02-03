package br.com.person;

import br.com.person.entity.Person;
import br.com.person.repository.PersonRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

import static org.jboss.resteasy.reactive.RestResponse.Status.CREATED;

@Path("/people")
@ApplicationScoped
public class PersonResource  {

    @Inject
    private PersonRepository personRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Person>> listAll() {
        return personRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<RestResponse<Person>> create(Person person) {
        return  Panache.withTransaction(person::persist)
                .replaceWith(RestResponse.status(CREATED, person));
    }
}
