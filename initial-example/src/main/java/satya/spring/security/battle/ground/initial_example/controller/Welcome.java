package satya.spring.security.battle.ground.initial_example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    /**
     * This is a simple method which returns a welcome message.
     */
    @GetMapping("/")
    public String helloWorldMessage() {
        return "Hello World !!";
    }
}
