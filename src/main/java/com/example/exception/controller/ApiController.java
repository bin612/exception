package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/user")
@Validated // 속성 제약조건에 대한 그룹을 만들어 적용시킬 수 있다.
public class ApiController {

    //TODO required : name 의 값이 없어도 실행
    @GetMapping("")
    public User get(

            @Size(min = 2)
            @RequestParam String name,

            @NotNull
            @Min(1)
            @RequestParam Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);

        return user;

    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user){
        System.out.println(user);
        return user;
    }

    //TODO ApiController 안에서 선언을 해주게 되면 컨트롤러 안에서 에러를 잡게 된다.
    //@ExceptionHandler(value = MethodArgumentNotValidException.class)
    //public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
    //System.out.println("api controller");
    //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//    }

}
