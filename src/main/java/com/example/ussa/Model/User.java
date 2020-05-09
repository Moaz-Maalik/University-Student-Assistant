package com.example.ussa.Model;
import com.example.ussa.Model.audit.DateAudit;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})

public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @NotBlank
    @Size(max = 40)
    @Getter
    @Setter
    private String name;

    @NotBlank
    @Size(max = 15)
    @Getter
    @Setter
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    @Getter
    @Setter
    private String email;

    @NotBlank
    @Size(max = 100)
    @Getter
    @Setter
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_Courses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id"))
    private List<Course> Courses = new ArrayList<>();


    public User() {

    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void addCourse(Course c){
        Courses.add(c);
    }

    public void removeCoures(Course c){
        Courses.remove(c);
    }

    public List<Course> getCourses() {
        return Courses;
    }

    public void setCourses(List<Course> Courses) {
        this.Courses = Courses;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}