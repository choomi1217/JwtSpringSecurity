package jwt.security.study.controller;

import jakarta.validation.Valid;
import jwt.security.study.dto.UserDto;
import jwt.security.study.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

}
