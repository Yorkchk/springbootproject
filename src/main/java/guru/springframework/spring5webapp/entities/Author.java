package guru.springframework.spring5webapp.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;


    public Author(){}

    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        else if(o == null || o.getClass() != getClass()){
            return false;
        }

        Author obj = (Author) o;

        return id != null ? id.equals(obj.id) : obj.id == null;
    }

    @Override
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString(){
        return "id : " + id + "\n"
                + "title " + firstName + "\n"
                + "isbn " + lastName;
    }


    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}
