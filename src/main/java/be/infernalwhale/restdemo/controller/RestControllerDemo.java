package be.infernalwhale.restdemo.controller;

import be.infernalwhale.restdemo.model.Beer;
import be.infernalwhale.restdemo.model.BeerDTO;
import be.infernalwhale.restdemo.model.Brewer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestControllerDemo {
    // Communication in the application   : method-calls
    // Communication from outside the app : HttpRequests
    // HttpRequest-header contains 2 parts: verb/method & url

    // https://portal.intecbrussel.be/api/v1/webadmin/courses
    // https://portal.intecbrussel.be/api/v1/webadmin/courses/25
    // proto://server-address(:port)/application-path

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        System.out.println("Hello World method called...");
        return "Hello World";
    }

//    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @PostMapping("/hello")
    public String helloWorldPost() {
        System.out.println("Hello World (POST) method called...");
        return "Hello World (POST)";
    }

    @RequestMapping("/goodbye")
    public ResponseEntity goodByeCruelWorld() {
        System.out.println("Goodbye World method called");
        return ResponseEntity.notFound().build();
    }

//    @RequestMapping("/goodbye/hello")
    @GetMapping("/goodbye/hello")
    public ResponseEntity goodbyeHello() {
        System.out.println("Goodbye/Hello World method called");

        Optional<String> stringOptional = Optional.of("Hello goodbye");

        if (stringOptional.isEmpty()) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(stringOptional.get());
    }

//    @RequestMapping(value = "/puttest", method = RequestMethod.PUT)
    @PutMapping("/puttest")
    public ResponseEntity putTesting() {
        System.out.println("PUT method called");
        return ResponseEntity.ok("You called the PUT method with PutMapping");
    }

    // Responses will be made in the form : HttpResponse
    // 2 parts:
    //     - status (of the request)
    //     - (possible) payload
    // does this mean we have to return 2 objects???
    // wrapper-object


    // Returning objects, how does it work?
    @GetMapping("/beer")
    public ResponseEntity getBeer() {
        Brewer brewer = new Brewer("Lambik Brouwerij");
        Beer beer = new Beer(1, "Lambik", 8D, brewer);
        brewer.setBeer(beer);

        return ResponseEntity.ok(new BeerDTO(beer));
    }

    // Circular dependencies or bidirectional relations
    // 1. don't have bi-directional dependencies
    // 2. Use references/id's instead of objects to reference back to another object
    // 3. @JsonBackReference and @JsonManagedReference annotations
    // 4. Write and use DTO classes
}
