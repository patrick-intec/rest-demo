package be.infernalwhale.restdemo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component   // General annotation for beans
@Controller  // Bean who is in contact with the outside world
@Service     // Bean belonging to the service/business layer
@Repository  // Bean belonging to the data layer
public class DemoController {

}
