package com.example.ussa.Controller;
import com.example.ussa.Model.Course;
import com.example.ussa.exception.AppException;
import com.example.ussa.exception.ResourceNotFoundException;
import com.example.ussa.Model.User;
import com.example.ussa.Model.Instructor;
import com.example.ussa.Model.Course;
import com.example.ussa.payload.*;
import com.example.ussa.repository.CourseRepository;
import com.example.ussa.repository.UserRepository;
import com.example.ussa.repository.InstructorRepository;
import com.example.ussa.security.UserPrincipal;
import com.example.ussa.security.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRep;

    @Autowired
    private InstructorRepository instructorRep;



    private static final Logger logger = LoggerFactory.getLogger(UserController.class);



    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }



    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));



        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName() ,user.getCourses());

        return userProfile;
    }

    @GetMapping("/users/{username}/courses")
    public List<Course> getCourses(@PathVariable(value = "username") String username) {
            // Let people login with either username or email
        System.out.println("Test");
            User user = userRepository.findByUsernameOrEmail(username, username).orElseThrow(() -> new UsernameNotFoundException("User not found teststtt" + username));




        return user.getCourses();
    }




}