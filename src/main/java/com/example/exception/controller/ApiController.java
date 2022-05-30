package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class ApiController {

    //TODO required : name 의 값이 없어도 실행
    @GetMapping("")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);

        int a = 10 + age;
        return user;

    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user){
        System.out.println(user);
        return user;
    }

    //TODO ApiController 안에서 선언을 해주게 되면 컨트롤러 안에서 에러를 잡게 된다.
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println("api controller");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
