package satya.spring.security.battle.ground.initial_configuration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping("/")
    public String home() {
        return "Welcome Home";
    }
    @GetMapping("/contact")
    public String contact() {
        return "Contact Us";
    }
    @GetMapping("/about")
    public String about() {
        return "About Us";
    }
    @GetMapping("/help")
    public String help() {
        return "Help";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Dashboard";
    }
    @GetMapping("/settings")
    public String settings() {
        return "Settings";
    }
}
