package satya.spring.security.battle.ground.custom_in_memory_user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
    @GetMapping("/about")
    public String about() {
        return "About";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Dashboard";
    }
    @GetMapping("/admin-dashboard")
    public String adminDashoard() {
        return "Admin Dashboard";
    }
}
