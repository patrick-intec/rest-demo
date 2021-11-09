package be.infernalwhale.restdemo.controller;

import be.infernalwhale.restdemo.model.Beer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/params")
public class RestControllerWithParams {
    // Request Parameters (PathVariable, Request Params, Request Body)

    // https://portal.intecbrussel.be/api/v1/webadmin/courses
    // https://portal.intecbrussel.be/api/v1/webadmin/courses/25
    // https://portal.intecbrussel.be/api/v1/webadmin/courses/26
    // https://portal.intecbrussel.be/api/v1/webadmin/courses/27

    // PathVariable - Parameters with information about the resource
    @GetMapping("/beer/{id}")
    public ResponseEntity getBeerWithPathVariable(@PathVariable Integer id) {
        System.out.println(id);
        System.out.println(id.getClass());
        return ResponseEntity.ok(id);
    }

    @GetMapping("/beer/{id}/{name}")
    public ResponseEntity getBeerWithTwoPathVariable(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id);
        System.out.println(name);

        return ResponseEntity.ok(id);
    }

    // Request Params - Parameters with information about the request
    // http://localhost:8080/params/beer?sortedBy=alcohol
    @GetMapping("/beer")
    public ResponseEntity getBeerWithRequestParams(@RequestParam(name = "sortedBy", required = false, defaultValue = "name") String sortBy) {
        System.out.println("SortedBy: " + sortBy);
        return ResponseEntity.ok(sortBy);
    }

    // http://localhost:8080/params/beer?sortedBy=alcohol&limit=10
    @GetMapping("/beers")
    public ResponseEntity getBeerWithTwoRequestParams(@RequestParam("sortedBy") String sortBy, @RequestParam("limit") Integer limit) {
        return ResponseEntity.ok(sortBy + " " + limit);
    }


    // RequestBody
    @PostMapping("/beer")
    public ResponseEntity postBeer(@RequestBody Beer beer) {
        System.out.println(beer.toString());
        return ResponseEntity.ok(beer);
    }
}
