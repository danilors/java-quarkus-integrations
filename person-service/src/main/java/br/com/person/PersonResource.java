package br.com.person;

import br.com.person.entity.Person;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

import static org.jboss.resteasy.reactive.RestResponse.Status.CREATED;

@Path("/people")
@ApplicationScoped
public class PersonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Person>> listAll() {
        return Person.listAll();
    }

    @POST
    public Uni<RestResponse<Person>> create(Person person) {
        return Panache.withTransaction(person::persist)
                .replaceWith(RestResponse.status(CREATED, person));
    }
}
