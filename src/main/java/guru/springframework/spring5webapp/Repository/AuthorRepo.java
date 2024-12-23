package guru.springframework.spring5webapp.Repository;

import guru.springframework.spring5webapp.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AuthorRepo extends CrudRepository<Author,Long > {
}
