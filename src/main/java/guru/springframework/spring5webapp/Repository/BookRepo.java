package guru.springframework.spring5webapp.Repository;

import guru.springframework.spring5webapp.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book,Long> {
}
