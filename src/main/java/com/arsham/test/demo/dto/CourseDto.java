package com.arsham.test.demo.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {

    @NotNull
    private String name;
}
