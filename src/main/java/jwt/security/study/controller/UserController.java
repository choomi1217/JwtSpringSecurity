package jwt.security.study.controller;

import jakarta.validation.Valid;
import jwt.security.study.dto.UserDto;
import jwt.security.study.entity.User;
import jwt.security.study.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.signUp(userDto));
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<User> getMyUserInfo(){
        return ResponseEntity.ok(userService.getUserWithAuthorities().get());
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<User> getMyUserInfi(@PathVariable String username){
        return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
    }

}
