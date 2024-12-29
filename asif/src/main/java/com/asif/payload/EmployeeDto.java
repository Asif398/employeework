package com.asif.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;

@Getter
@Setter
//@Component
public class EmployeeDto {



private Long id;
@NotBlank
@Size(min=3,message="At least 3 char requeired")
private String name;
@Email
private String emailId;
@Size(min=10,message="should  be 10  digits")
private String mobile;
//private Date  date;


}


