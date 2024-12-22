package guru.springframework.spring5webapp.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String isbn;


    public Book(){}

    public Book(String title, String isbn){
        this.isbn = isbn;
        this.title = title;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    @ManyToMany
    @JoinTable(name="author_book", joinColumns = @JoinColumn(name="book_id"),
                inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
}
