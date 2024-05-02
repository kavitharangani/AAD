package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.dto.UserDTO;
import lk.ijse.gdse65.AAD_Course_Work.dto.LoginDTO;
import lk.ijse.gdse65.AAD_Course_Work.response.LoginResponse;
import lk.ijse.gdse65.AAD_Course_Work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class User {
    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Users OK";
    }

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO)
    {
        String id = userService.addUser(userDTO);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
