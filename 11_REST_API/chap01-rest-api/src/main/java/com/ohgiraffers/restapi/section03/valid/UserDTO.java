package com.ohgiraffers.restapi.section03.valid;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private int no;

    @NotNull(message = "아이디는 반드시 입력되어야 합니다.")
    @NotBlank(message = "아이디는 공백일 수 없습니다.")
    private String id;

    @NotNull(message = "비밀번호는 반드시 입력되어야 합니다.")
    @NotBlank(message = "비밀번호는 공백일 수 없습니다.")
    @Length(max = 10, message = "비밀번호 길이는 10자를 초과할 수 없습니다.")
    private String pwd;

    @NotNull(message = "이름은 반드시 입력되어야 합니다.")
    @NotBlank(message = "이름은 공백일 수 없습니다.")
    @Size(max = 10, message = "이름의 길이는 10자를 초과할 수 없습니다.")
    private String name;

    @Past(message = "가입일은 현재보다 과거 날짜가 입력 되어야 합니다.")   //반드시 현재시점보다 과거가 들어와야함
    //@Future //반드시 현재시점보다 미래가 들어와야함
    private Date enrollDate;
}
