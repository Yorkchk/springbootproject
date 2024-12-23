package guru.springframework.spring5webapp.BootStrap;

import guru.springframework.spring5webapp.Repository.AuthorRepo;
import guru.springframework.spring5webapp.Repository.BookRepo;
import guru.springframework.spring5webapp.Repository.PublisherRepo;
import guru.springframework.spring5webapp.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private PublisherRepo publisherRepo;


    public BootStrap(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo){
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("Youssef","Ottawa","white house",
                "Ontario","K1N");

        Author daniel = new Author("Daniel","Golman");
        Book emin = new Book("Emotional Inteligence", "1");

        daniel.getBooks().add(emin);
        emin.getAuthors().add(daniel);


        authorRepo.save(daniel);
        bookRepo.save(emin);
        publisherRepo.save(publisher);

        Author mano = new Author("Morris","Mano");
        Book ceg = new Book("computer architecture", "2");

        mano.getBooks().add(ceg);
        ceg.getAuthors().add(mano);



        publisher.getBooks().add(emin);
        publisher.getBooks().add(ceg);
        emin.setPublisher(publisher);
        ceg.setPublisher(publisher);





        authorRepo.save(mano);
        bookRepo.save(ceg);
        publisherRepo.save(publisher);



        System.out.println("Start BootStrap");
        System.out.println("authors count : " + authorRepo.count());
        System.out.println("publisher books count : " + bookRepo.count());


    }
}
