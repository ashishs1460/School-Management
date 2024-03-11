package com.ashish.school.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private String firstname;
    private String lastname;
    private String email;
}
