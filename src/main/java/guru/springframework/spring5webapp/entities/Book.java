package guru.springframework.spring5webapp.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String isbn;

    @ManyToOne()
    private Publisher publisher;


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
    public Publisher getPublisher(){
        return publisher;
    }

    public void setPublisher(Publisher publisher){
        this.publisher = publisher;
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
    public List<Author> getAuthors(){
        return authors;
    }
    public void setAuthors(List<Author> authors){
        this.authors = authors;
    }


    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        else if(o == null || o.getClass() != getClass()){
            return false;
        }

        Book obj = (Book) o;

        return id != null ? id.equals(obj.id) : obj.id == null;
    }



    @Override
    public String toString(){
        return "id : " + id + "\n"
                + "title " + title + "\n"
                + "isbn " + isbn;
    }


    @ManyToMany
    @JoinTable(name="author_book", joinColumns = @JoinColumn(name="book_id"),
                inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();
}
