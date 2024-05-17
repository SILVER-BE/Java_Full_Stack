package com.ohgiraffers.restapi.section03.valid;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/valid")
public class ValidTestController {

    @GetMapping("/users/{userNo}")
    public ResponseEntity<Void> findUserByNo() throws UserNotFoundException {

        boolean check = true;
        if(check) {
            throw new UserNotFoundException("회원 정보를 찾을 수 없습니다.");
            //의도적 오류 발생시키기
        }

        return ResponseEntity.ok().build(); //끝!
    }

    @PostMapping("/users")
    public ResponseEntity<Void> registUsers(@Valid @RequestBody UserDTO user) {
        //                                  -유효성-

        return ResponseEntity
                .created(URI.create("/valid/users/1")) //유저번호 1번으로 지정
                .build(); //끝!
    }

}
