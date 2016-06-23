package pl.edu.agh.wat.domain.model;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min=5, max= 50, message = "{error.experience.type.size}" )
    private String username;
    @Size(min=5, max= 1000, message = "{error.experience.type.size}")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
