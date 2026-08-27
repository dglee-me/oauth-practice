package kr.co.dglee.authorization.server.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping(value = "/admin")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Admin endpoint");
    }
}
