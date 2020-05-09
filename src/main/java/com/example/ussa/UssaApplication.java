package com.example.ussa;

import com.example.ussa.Controller.TimeTableReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import javax.annotation.PostConstruct;
import java.util.*;


@EntityScan(basePackageClasses = {
        UssaApplication.class,
        Jsr310JpaConverters.class
})

@SpringBootApplication
public class UssaApplication {

    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }


    public static void main(String[] args) throws Exception {

        SpringApplication.run(UssaApplication.class, args);

       // TimeTableReader start = new TimeTableReader();
        //start.readCourseList();





    }

  /*  @Bean
    public CommandLineRunner demo(UserRepository repository, InstructorRepository repository2, CourseRepository repository3) {
        return (args) -> {
            // save a few customers

            User U1 = new User("ALi", "All", "ali@live.com", "12345678");
            List<Course> Courses = new ArrayList<Course>();

            Instructor i1 = new Instructor("mr. AA");
            Instructor i2 = new Instructor("mr. BB");
            List<Instructor> instructors = new ArrayList<Instructor>();
            instructors.add(i1);
            instructors.add(i2);


            Course c1 = new Course("Operating System", "OS301", 'A', instructors, null );
            Course c2 = new Course("Database", "DB301", 'B', instructors, null );
            Course c3 = new Course("Linier Algebera", "MS301", 'A', instructors, null );
            Course c4 = new Course("International Relations", "SS301", 'A', instructors, null );
            Course c5 = new Course("Entre", "MG301", 'B', instructors, null );
            Courses.add(c1);
            Courses.add(c2);
            Courses.add(c3);
            Courses.add(c4);
            Courses.add(c5);

            repository2.save(i1);
            repository2.save(i2);

            instructors.get(0).addCourse(c1);
            instructors.get(0).addCourse(c2);
            instructors.get(1).addCourse(c3);
            instructors.get(1).addCourse(c4);

            U1.setCourses(Courses);






            repository3.save(c1);
            repository3.save(c2);
            repository3.save(c3);
            repository3.save(c4);
            repository3.save(c5);

            repository.save(U1);


        };
    }*/

}
